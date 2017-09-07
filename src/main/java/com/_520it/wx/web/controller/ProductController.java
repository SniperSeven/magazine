package com._520it.wx.web.controller;

import com._520it.wx.domain.Bill;
import com._520it.wx.domain.BillItem;
import com._520it.wx.domain.Client;
import com._520it.wx.domain.Product;
import com._520it.wx.page.PageResult;
import com._520it.wx.query.ProductQueryObject;
import com._520it.wx.service.IBillItemService;
import com._520it.wx.service.IBillService;
import com._520it.wx.service.IClientService;
import com._520it.wx.service.IProductService;
import com._520it.wx.util.AjaxResult;
import com._520it.wx.util.SecurityUtil;
import com._520it.wx.util.WeixinUtil;
import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;
import org.apache.commons.io.IOUtils;
import org.apache.poi.util.SystemOutLogger;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.util.*;

/**
 * Created by zmh on 2017/8/21.
 */
@Controller
public class ProductController extends BaseController {

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private IProductService service;

    @Autowired
    private IClientService clientService;

    @Autowired
    private IBillItemService itemService;

    @Autowired
    private IBillService billService;

    @RequestMapping("/product_view")
    public String product() {
        return "product";
    }

    @RequestMapping("/product_list")
    @ResponseBody
    public PageResult list(ProductQueryObject qo) {

        return service.pageQuery(qo);
    }

    @RequestMapping("/product_listAll")
    @ResponseBody
    public List<Product> listAll() {
        return service.selectAll();
    }

    @RequestMapping("/product_save")
    @ResponseBody
    public AjaxResult save(Product product, MultipartFile file, MultipartFile file2, HttpServletRequest request) {
        try {
            if (file != null) {
                String path = saveFile(product, file, request);
                product.setImageURL(path);
            }
            if (file2 != null) {
                String path = saveFile(product, file2, request);
                product.setSecondImg(path);
            }
            service.insert(product);
            return new AjaxResult(true, "商品保存成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult(false, "商品保存失败");
        }
    }

    private String saveFile(Product product, MultipartFile file, HttpServletRequest request) throws Exception {
        String realPath = request.getSession().getServletContext().getRealPath("/static/image/");
        String path = UUID.randomUUID().toString();
        String fileName = file.getOriginalFilename();
        String fileType = fileName.substring(fileName.lastIndexOf("."));
        File targetFile = new File(realPath, path + fileType);
        System.out.println(targetFile);
        FileOutputStream os = new FileOutputStream(targetFile);
        IOUtils.copy(file.getInputStream(), os);
        os.close();
        return ("/static/image/" + path + fileType);
    }

    @RequestMapping("/product_saveHead")
    @ResponseBody
    public AjaxResult saveHead(Product product, MultipartFile file, MultipartFile file2, MultipartFile file3,
                               HttpServletRequest request) {
        try {
            if (file != null) {
                String path = saveFile(product, file, request);
                product.setImageURL(path);
            }
            if (file2 != null) {
                String path = saveFile(product, file2, request);
                product.setSecondImg(path);
            }
            if (file3 != null) {
                String path = saveFile(product, file3, request);
                product.setDetailImg(path);
            }
            service.insertHeadProduct(product);
            return new AjaxResult(true, "商品保存成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult(false, "商品保存失败");
        }
    }

    @RequestMapping("/product_delete")
    @ResponseBody
    public AjaxResult del(Long id) {
        try {
            service.deleteByPrimaryKey(id);
            return new AjaxResult(true, "商品删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult(false, "商品删除失败");
        }
    }

    @RequiresPermissions("product:edit")
    @RequestMapping("/product_edit")
    @ResponseBody
    public AjaxResult edit(Product product) {
        try {
            service.updateByPrimaryKey(product);
            return new AjaxResult(true, "商品编辑成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult(false, "商品编辑失败");
        }
    }

    @RequestMapping("/product_index")
    public String index(ProductQueryObject qo, HttpServletRequest req) {

        String code = req.getParameter("code");
        String ticket = WeixinUtil.getTicket();
        String noncestr = "zmh";
        String timestamp = "454545545";
        String url = "http://zmh.nat400.top/product_index.do?code=" + code + "&state=";
        String[] arr = {"jsapi_ticket=" + ticket, "timestamp=" + timestamp, "noncestr=" + noncestr, "url=" + url};
        Arrays.sort(arr);
        String str = "";
        for (int i = 0; i < arr.length; i++) {
            if (i != arr.length - 1) {
                str += arr[i] + "&";
            } else {
                str += arr[i];
            }
        }
        System.out.println("====================" + str);
        String signature = SecurityUtil.SHA1(str);
        System.out.println(signature);
        req.setAttribute("signature", signature);

        List<Product> headProducts = service.getHeadProduct();
        req.setAttribute("headProducts", headProducts);

        Client client1 = (Client) req.getSession().getAttribute("CLIENT_IN_SESSION");
        if (client1 != null) {
            Bill bill = billService.selectUnsuccessByCLientId(client1.getId());
            if (bill != null && bill.getItems() != null && bill.getItems().size() != 0) {
                BigDecimal productNum = new BigDecimal("0");
                for (BillItem item : bill.getItems()) {
                    productNum = productNum.add(item.getNumber());
                }
                req.getSession().setAttribute("productNum", productNum.toString());
            } else {
                req.getSession().setAttribute("productNum", 0);
            }
        }


        PageResult result = service.pageQuery(qo);
        req.setAttribute("result", result);


        if (code != null) {
            String openid = WeixinUtil.getOpenid(code);
            Client client = clientService.selectByOpenid(openid);
            req.getSession().setAttribute("CLIENT_IN_SESSION", client);
        }
        return "index";
    }

    @RequestMapping("/product_addCart")
    @ResponseBody
    public AjaxResult addCart(Long productId, HttpServletRequest request, Integer amount) {
        try {
            Product product = service.selectByPrimaryKey(productId);
            Client client = (Client) request.getSession().getAttribute("CLIENT_IN_SESSION");
            Bill bill = billService.selectUnsuccessByCLientId(client.getId());

            if (bill == null) {
                bill = new Bill();
                bill.setClient(client);

                BillItem item = new BillItem();
                item.setNumber(new BigDecimal(amount));
                item.setProduct(product);
                item.setSmallAccount(product.getSalePrice().multiply(new BigDecimal(amount)));
                ArrayList<BillItem> items = new ArrayList<>();
                items.add(item);
                bill.setItems(items);

                bill.setSaleDate(new Date());
                bill.setTotalNumber(new BigDecimal(amount));
                bill.setTotalPrice(item.getSmallAccount());
                bill.setState("待付款");

                billService.insert(bill);
                item.setBillId(bill.getId());
                itemService.insert(item);

            } else {
                //如果有订单--订单里有这个商品
                List<BillItem> billItems = itemService.selectByBillId(bill.getId());
                System.out.println(billItems);
                for (BillItem item : billItems) {
                    if (billItems.size() == 0) {
                        break;
                    }
                    item = itemService.selectByPrimaryKey(item.getId());
                    if (item.getProduct().equals(product)) {
                        item.setNumber(item.getNumber().add(new BigDecimal(amount)));
                        item.setSmallAccount(item.getSmallAccount().add(product.getSalePrice().multiply(new BigDecimal
                                (amount))));
                        itemService.updateByPrimaryKey(item);

                        bill.setTotalPrice(bill.getTotalPrice().add(product.getSalePrice().multiply(new BigDecimal
                                (amount))));
                        bill.setTotalNumber(bill.getTotalNumber().add(new BigDecimal(amount)));
                        billService.updateByPrimaryKey(bill);
                        return new AjaxResult(true, "商品编辑成功");
                    }
                }
                BillItem item = new BillItem();
                item.setNumber(new BigDecimal(amount));
                item.setProduct(product);
                item.setSmallAccount(product.getSalePrice().multiply(new BigDecimal(amount)));
                item.setBillId(bill.getId());

                billItems.add(item);
                bill.setItems(billItems);
                bill.setTotalNumber(bill.getTotalNumber().add(new BigDecimal(amount)));
                bill.setTotalPrice(bill.getTotalPrice().add((product.getSalePrice().multiply(new BigDecimal(amount)))));
                billService.updateByPrimaryKey(bill);

                itemService.insert(item);
            }
            return new AjaxResult(true, "商品编辑成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult(false, "商品编辑失败");
        }

    }

    @RequestMapping("/shoppingCart")
    public String goToCart(HttpServletRequest request) {
        Client client = (Client) request.getSession().getAttribute("CLIENT_IN_SESSION");
        if (client != null) {
            Bill bill = billService.selectUnsuccessByCLientId(client.getId());
            System.out.println(bill);
            request.setAttribute("bill", bill);
        }
        return "buy";

    }

    @RequestMapping("/product_dealBill")
    public String dealBill(HttpServletRequest request, Bill bill) {
        Bill oldBill = billService.selectByPrimaryKey(bill.getId());
        List<BillItem> items = bill.getItems();
        BigDecimal totalAccount = BigDecimal.ZERO;
        BigDecimal totalAmount = BigDecimal.ZERO;
        for (BillItem item : items) {
            item.setBillId(bill.getId());
            item.setSmallAccount(item.getNumber().multiply(item.getProduct().getSalePrice()));
            totalAccount = totalAccount.add(item.getSmallAccount());
            totalAmount = totalAmount.add(item.getNumber());
            itemService.updateByPrimaryKey(item);
        }
        oldBill.setTotalNumber(totalAmount);
        oldBill.setTotalPrice(totalAccount);
        System.out.println(totalAccount);
//		oldBill.setState("待发货");
        oldBill.setSaleDate(new Date());
        billService.updateByPrimaryKey(oldBill);

        System.out.println(oldBill);

        request.getSession().setAttribute("bill", oldBill);
        return "bsale";
    }

    @RequestMapping("/edit_address")
    public String editAddress() {

        return "address";

    }

    @RequestMapping("/back_dealBill")
    public String backDeal(HttpServletRequest request, String address) {
        Client client = (Client) request.getSession().getAttribute("CLIENT_IN_SESSION");
        System.out.println(address);
        client.setAddress(address);
        request.getSession().setAttribute("CLIENT_IN_SESSION", client);
        return "bsale";

    }

    @RequestMapping("/dealBill")
    public String dillBill() {
        return "bsale";
    }

    @RequestMapping("/success")
    public String sucess() {
        return "success";

    }

    @RequestMapping("/indevidal")
    public String gotoIndevial() {
        return "mycenter";

    }

    @RequestMapping("/pay")
    @ResponseBody
    public void pay(HttpServletRequest request, String address, String tel) {

        Client client = (Client) request.getSession().getAttribute("CLIENT_IN_SESSION");
        client.setAddress(address);
        client.setTel(tel);
        request.getSession().setAttribute("CLIENT_IN_SESSION", client);
        Bill bill = (Bill) request.getSession().getAttribute("bill");
        bill.setState("待发货");
        billService.updateByPrimaryKey(bill);
        clientService.updateByPrimaryKey(client);
        request.getSession().setAttribute("CLIENT_IN_SESSION", client);

        /*给用户发购买成功信息*/
        List<BillItem> items = bill.getItems();
        StringBuilder productName = new StringBuilder();
        for (BillItem item : items) {
            productName.append(item.getProduct().getName()).append(",");
        }
        productName.delete(productName.length() - 1, productName.length());
        WeixinUtil.template(client.getOpenId(), productName.toString(), bill.getTotalPrice().toString());
    }


}

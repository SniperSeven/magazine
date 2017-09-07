package com._520it.wx.web.controller;

import com._520it.wx.domain.Bill;
import com._520it.wx.page.PageResult;
import com._520it.wx.query.BillQueryObject;
import com._520it.wx.service.IBillService;
import com._520it.wx.util.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by zmh on 2017/8/21.
 */
@Controller
public class BillController extends BaseController {

	@Autowired
	private IBillService service;

	@RequestMapping("/bill_view")
	public String bill() {
		return "bill";
	}

	@RequestMapping("/bill_list")
	@ResponseBody
	public PageResult list(BillQueryObject qo) {

		return service.pageQuery(qo);
	}

	@RequestMapping("/bill_listAll")
	@ResponseBody
	public List<Bill> listAll() {
		return service.selectAll();
	}

	@RequestMapping("/bill_save")
	@ResponseBody
	public AjaxResult save(Bill r) {
		try {
			service.insert(r);
			return new AjaxResult(true, "订单保存成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new AjaxResult(false, "订单保存失败");
		}
	}

	@RequestMapping("/bill_delete")
	@ResponseBody
	public AjaxResult del(Long id) {
		try {
			service.deleteByPrimaryKey(id);
			return new AjaxResult(true, "订单删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new AjaxResult(false, "订单删除失败");
		}
	}

	@RequestMapping("/bill_edit")
	@ResponseBody
	public AjaxResult edit(Bill bill) {
		try {
			service.updateByPrimaryKey(bill);
			return new AjaxResult(true, "订单编辑成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new AjaxResult(false, "订单编辑失败");
		}
	}

	@RequestMapping("/bill_delivery")
	@ResponseBody
	public AjaxResult delivery(Long id) {
		try {
			service.delivery(id);
			return new AjaxResult(true, "订单发货成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new AjaxResult(false, "订单发货失败");
		}
	}
}

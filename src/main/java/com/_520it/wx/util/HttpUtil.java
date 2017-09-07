package com._520it.wx.util;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StreamUtils;
import org.springframework.util.StringUtils;



/**
 * Http工具类
 * 
 * 
 */
public class HttpUtil {

	/**
	 * 发送get请求
	 * 
	 * @throws Exception
	 */
	public static String get(String url) {

		String result = "";
		InputStream in = null;
		try {
			// 打开和URL之间的连接
			HttpURLConnection conn = (HttpURLConnection) new URL(url)
					.openConnection();
			// 设置通用的请求属性
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestMethod("GET");
			// 建立实际的连接
			conn.connect();
			// 定义输入流来读取URL的响应
			in = conn.getInputStream();
			result = StreamUtils.copyToString(in, Charset.forName("utf-8"));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	/**
	 * 发送post请求
	 * 
	 * @throws Exception
	 */
	public static String post(String url, String paramStr) {
		InputStream in = null;
		OutputStream os = null;
		String result = "";
		try {
			// 打开和URL之间的连接
			HttpURLConnection conn = (HttpURLConnection) new URL(url)
					.openConnection();
			// 设置通用的请求属性
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			// 发送POST请求须设置
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			os = conn.getOutputStream();
			// 注意编码格式，防止中文乱码
			if (StringUtils.hasText(paramStr)) {
				os.write(paramStr.getBytes("utf-8"));
				os.close();
			}
			
			in = conn.getInputStream();
			result = StreamUtils.copyToString(in, Charset.forName("utf-8"));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (os != null) {
					os.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return result;
	}


	/**
	 * 上传其他永久素材(图片素材的上限为5000，其他类型为1000)
	 *
	 * @return
	 * @throws Exception
	 */
	public static JSONObject addMaterialEver(String fileurl, String type, String token) {
		try {
			File file = new File(fileurl);
			//上传素材
			String path = "https://api.weixin.qq.com/cgi-bin/material/add_material?access_token=" + token + "&type=" + type;
			String result = connectHttpsByPost(path, null, file);
			result = result.replaceAll("[\\\\]", "");
			System.out.println("result:" + result);
			JSONObject resultJSON = JSON.parseObject(result);
			if (resultJSON != null) {
				if (resultJSON.get("media_id") != null) {
					System.out.println("上传" + type + "永久素材成功");
					return resultJSON;
				} else {
					System.out.println("上传" + type + "永久素材失败");
				}
			}
			return null;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		} catch (KeyManagementException e) {
			e.printStackTrace();
		}
		return null;
	}


	/**
	 * 上传其他永久素材(图片素材的上限为5000，其他类型为1000)
	 *
	 * @return
	 * @throws Exception
	 */
	public static JSONObject addMaterialEver(String fileurl, String token) {
		try {
			File file = new File(fileurl);
			//上传素材
			String path = "https://api.weixin.qq.com/cgi-bin/media/uploadimg?access_token=" + token;
			String result = connectHttpsByPost(path, null, file);
			result = result.replaceAll("[\\\\]", "");
			System.out.println("result:" + result);
			JSONObject resultJSON = JSON.parseObject(result);
			if (resultJSON != null) {
				if (resultJSON.get("url") != null) {
					System.out.println("上传永久素材成功");
					return resultJSON;
				} else {
					System.out.println("上传永久素材失败");
				}
			}
			return null;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		} catch (KeyManagementException e) {
			e.printStackTrace();
		}
		return null;
	}


	public static  String connectHttpsByPost(String path, String KK, File file) throws IOException, NoSuchAlgorithmException, NoSuchProviderException, KeyManagementException {
		URL urlObj = new URL(path);
		//连接
		HttpURLConnection con = (HttpURLConnection) urlObj.openConnection();
		String result = null;
		con.setDoInput(true);

		con.setDoOutput(true);

		con.setUseCaches(false); // post方式不能使用缓存

		// 设置请求头信息
		con.setRequestProperty("Connection", "Keep-Alive");
		con.setRequestProperty("Charset", "UTF-8");
		// 设置边界
		String BOUNDARY = "----------" + System.currentTimeMillis();
		con.setRequestProperty("Content-Type",
				"multipart/form-data; boundary="
						+ BOUNDARY);

		// 请求正文信息
		// 第一部分：
		StringBuilder sb = new StringBuilder();
		sb.append("--"); // 必须多两道线
		sb.append(BOUNDARY);
		sb.append("\r\n");
		sb.append("Content-Disposition: form-data;name=\"media\";filelength=\"" + file.length() + "\";filename=\""

				+ file.getName() + "\"\r\n");
		sb.append("Content-Type:application/octet-stream\r\n\r\n");
		byte[] head = sb.toString().getBytes("utf-8");
		// 获得输出流
		OutputStream out = new DataOutputStream(con.getOutputStream());
		// 输出表头
		out.write(head);

		// 文件正文部分
		// 把文件已流文件的方式 推入到url中
		DataInputStream in = new DataInputStream(new FileInputStream(file));
		int bytes = 0;
		byte[] bufferOut = new byte[1024];
		while ((bytes = in.read(bufferOut)) != -1) {
			out.write(bufferOut, 0, bytes);
		}
		in.close();
		// 结尾部分
		byte[] foot = ("\r\n--" + BOUNDARY + "--\r\n").getBytes("utf-8");// 定义最后数据分隔线
		out.write(foot);
		out.flush();
		out.close();
		StringBuffer buffer = new StringBuffer();
		BufferedReader reader = null;
		try {
			// 定义BufferedReader输入流来读取URL的响应
			reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String line = null;
			while ((line = reader.readLine()) != null) {
				buffer.append(line);
			}
			if (result == null) {
				result = buffer.toString();
			}
		} catch (IOException e) {
			System.out.println("发送POST请求出现异常！" + e);
			e.printStackTrace();
		} finally {
			if (reader != null) {
				reader.close();
			}
		}
		return result;
	}

}
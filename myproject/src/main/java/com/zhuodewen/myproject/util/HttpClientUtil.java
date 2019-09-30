/*
package com.zhuodewen.myproject.util;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class HttpClientUtil {
	 
	*/
/**
	 * 带参数的get请求
	 * @param url
	 * @param param
	 * @return String
	 *//*

	public static String doGet(String url, Map<String, String> param) {
		// 创建Httpclient对象
		CloseableHttpClient httpclient = HttpClients.createDefault();
		// 定义接收返回数据的字符串
		String resultString = "";
		// 定义接收调用节后的response对象
		CloseableHttpResponse response = null;
		try {
			// 创建uri
			URIBuilder builder = new URIBuilder(url);
			// 设置参数
			if (param != null) {
				for (String key : param.keySet()) {
					builder.addParameter(key, param.get(key));
				}
			}
			// 创建http GET请求
			URI uri = builder.build(); 
			HttpGet httpGet = new HttpGet(uri);
			// 执行请求
			response = httpclient.execute(httpGet);
			// 判断返回状态是否为200
			if (response.getStatusLine().getStatusCode() == 200) {
				// 接收返回结果
				resultString = EntityUtils.toString(response.getEntity(), "UTF-8");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// 关闭连接对象*2
				if (response != null) {
					response.close();
				}
				httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return resultString;
	}
	
	*/
/**
	 * 不带参数的get请求
	 * @param url
	 * @return String
	 *//*

	public static String doGet(String url) {
		// 创建Httpclient对象
		CloseableHttpClient httpclient = HttpClients.createDefault();
		// 定义接收返回数据的字符串
		String resultString = "";
		// 定义接收调用节后的response对象
		CloseableHttpResponse response = null;
		try {
			// 创建uri
			URIBuilder builder = new URIBuilder(url);
			// 创建http GET请求
			URI uri = builder.build();
			HttpGet httpGet = new HttpGet(uri);
			// 执行请求
			response = httpclient.execute(httpGet);
			// 判断返回状态是否为200
			if (response.getStatusLine().getStatusCode() == 200) {
				// 接收返回结果
				resultString = EntityUtils.toString(response.getEntity(), "UTF-8");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// 关闭连接对象*2
				if (response != null) {
					response.close();
				}
				httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return resultString;
	}
 
	*/
/**
	 * 带参数的post请求
	 * @param url
	 * @param param
	 * @return String
	 *//*

	public static String doPost(String url, Map<String, String> param) {
		// 创建Httpclient对象
		CloseableHttpClient httpClient = HttpClients.createDefault();
		// 定义接收返回数据的字符串
		String resultString = "";
		// 定义接收调用节后的response对象
		CloseableHttpResponse response = null;
		try {
			// 创建Http Post请求
			HttpPost httpPost = new HttpPost(url);
			// 创建参数列表
			if (param != null) {
				List<NameValuePair> paramList = new ArrayList<>();
				for (String key : param.keySet()) {
					paramList.add(new BasicNameValuePair(key, param.get(key)));
				}
				// 模拟表单
				UrlEncodedFormEntity entity = new UrlEncodedFormEntity(paramList);
				httpPost.setEntity(entity);	// 设置
			}
			// 执行http请求并接收返回结果
			response = httpClient.execute(httpPost);
			resultString = EntityUtils.toString(response.getEntity(), "utf-8");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				response.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return resultString;
	}
 
	*/
/**
	 * 不带参数的post请求
	 * @param url
	 * @return String
	 *//*

	public static String doPost(String url) {
		// 创建Httpclient对象
		CloseableHttpClient httpClient = HttpClients.createDefault();
		// 定义接收返回数据的字符串
		String resultString = "";
		// 定义接收调用节后的response对象
		CloseableHttpResponse response = null;
		try {
			// 创建Http Post请求
			HttpPost httpPost = new HttpPost(url);
			// 执行http请求并接收返回结果
			response = httpClient.execute(httpPost);
			resultString = EntityUtils.toString(response.getEntity(), "utf-8");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭连接对象
			try {
				response.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return resultString;
	}
	
	*/
/**
	 * 传送json类型的post请求
	 * @param url
	 * @param json
	 * @return String
	 *//*

	public static String doPostJson(String url, String json) {
		// 创建Httpclient对象
		CloseableHttpClient httpClient = HttpClients.createDefault();
		// 定义接收返回数据的字符串
		String resultString = "";
		// 定义接收调用节后的response对象
		CloseableHttpResponse response = null;
		try {
			// 创建Http Post请求
			HttpPost httpPost = new HttpPost(url);
			//[设置编码,防止中文乱码]
			httpPost.setHeader("Content-Type", "application/json;charset=UTF-8");	
			// 创建请求内容
			StringEntity entity = new StringEntity(json, ContentType.APPLICATION_JSON);
			entity.setContentType("application/json");	//[设置参数类型]
			httpPost.setEntity(entity);					// 添加json参数
			// 执行http请求并接收返回结果
			response = httpClient.execute(httpPost);
			resultString = EntityUtils.toString(response.getEntity(), "utf-8");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// 释放资源
				if (httpClient != null) {
					httpClient.close();
				}
				if (response != null) {
					response.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return resultString;
	}
}
*/

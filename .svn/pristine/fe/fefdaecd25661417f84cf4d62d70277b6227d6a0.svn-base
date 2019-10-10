package com.java1234.http;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import com.java1234.util.StringUtil;


public class HttpClient {
	
	
	public static void main(String[] args) {
	}
	
	
	public static String post(String url, String data) throws ClientProtocolException, IOException {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httppost = new HttpPost(url);
		String result = "";
		StringEntity entity = new StringEntity(data, "utf-8");// 解决中文乱码问题
		entity.setContentEncoding("UTF-8");
		entity.setContentType("application/json");
		httppost.setEntity(entity);
		CloseableHttpResponse response = httpclient.execute(httppost);
		HttpEntity httpEntity = response.getEntity();
		if (httpEntity != null) {
			result = EntityUtils.toString(httpEntity, "UTF-8");
		}
		response.close();
		httpclient.close();
		return result;
	}
	

	/**
	 * 发送get 请求一个url返回 返回的内容
	 * 
	 */
	public static String get(String url) {
		String html = null;
		CloseableHttpClient httpClient = HttpClients.createDefault(); // 创建httpClient实例
		HttpGet httpGet = new HttpGet(url); // 创建httpget实例
		CloseableHttpResponse response = null;
		try {
			response = httpClient.execute(httpGet); // 执行http get请求
		} catch (ClientProtocolException e) { // http协议异常
			e.printStackTrace();
		} catch (IOException e) { // io异常
			e.printStackTrace();
		}
		HttpEntity entity = response.getEntity(); // 获取返回实体
		try {
			// System.out.println("网页内容："+EntityUtils.toString(entity,
			// "utf-8")); // 获取网页内容
			html = EntityUtils.toString(entity, "utf-8");
		} catch (ParseException e) { // 解析异常
			e.printStackTrace();
		} catch (IOException e) { // io异常
			e.printStackTrace();
		}
		try {
			response.close(); // response关闭
		} catch (IOException e) { // io异常
			e.printStackTrace();
		}
		try {
			httpClient.close(); // httpClient关闭
		} catch (IOException e) {
			e.printStackTrace();
		}
		return html;
	}
	
	
	public static String getHtmlByPost(String url, String yzm, String phone, boolean useDaiLi, String ip, int port)
			throws ClientProtocolException, IOException {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httppost = new HttpPost(url);

		httppost.setHeader("Accept", "*/*");
		httppost.setHeader("Accept-Encoding", "gzip, deflate");
		httppost.setHeader("Accept-Language", "zh-CN,zh;q=0.8");
		httppost.setHeader("Connection", "keep-alive");
		httppost.setHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
		httppost.setHeader("Cookie",
				"__cfduid=d788de813737581b85309e78edcb4311d1491017109; aliyungf_tc=AQAAAFdFGCTBew4AVl3sKqQ8eBpkf1Km; acw_tc=AQAAAEbwFS2VhQEAVl3sKi4q2hv9UPUY; PHPSESSID=9ks560p3cfsl4ijssdbs293vm0; acw_sc=58df42bb4cb66ad520a52d2d33feebd47c9e51ba; SXHNET=ILOVESXH@2");
		httppost.setHeader("Host", "www.shanxinhui.net");
		httppost.setHeader("Origin", "http://www.shanxinhui.net");
		httppost.setHeader("Referer", "http://www.shanxinhui.net/index/index/register.html");
		httppost.setHeader("User-Agent",
				"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.102 Safari/537.36");
		httppost.setHeader("X-Requested-With", "XMLHttpRequest");

		// 判断 是否 创建代理 高匿名代理
		if (useDaiLi) {
			HttpHost proxy = new HttpHost(ip, port);
			RequestConfig requestConfig = RequestConfig.custom().setProxy(proxy).build();
			httppost.setConfig(requestConfig);
		}

		// 创建参数队列
		List<NameValuePair> formparams = new ArrayList<NameValuePair>();

		String result = null;
		formparams.add(new BasicNameValuePair("phone", phone));
		formparams.add(new BasicNameValuePair("length", "6"));
		formparams.add(new BasicNameValuePair("msg", "注册"));
		formparams.add(new BasicNameValuePair("type", "0"));
		formparams.add(new BasicNameValuePair("verify", yzm));
		formparams.add(new BasicNameValuePair("validTime", "60"));

		UrlEncodedFormEntity uefEntity;

		uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8");
		httppost.setEntity(uefEntity);
		// System.out.println("executing request " + httppost.getURI());
		CloseableHttpResponse response = httpclient.execute(httppost);

		HttpEntity entity = response.getEntity();
		if (entity != null) {
			result = EntityUtils.toString(entity, "UTF-8");
		}
		response.close();
		httpclient.close();
		return result;
	}
	
	public static String zhaopin_post(String url, String data)
			throws ClientProtocolException, IOException {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httppost = new HttpPost(url);
		
		// 创建参数队列
		List<NameValuePair> formparams = new ArrayList<NameValuePair>();
		String result = null;
		formparams.add(new BasicNameValuePair("data", data));

		UrlEncodedFormEntity uefEntity;

		uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8");
		httppost.setEntity(uefEntity);
		// System.out.println("executing request " + httppost.getURI());
		CloseableHttpResponse response = httpclient.execute(httppost);

		HttpEntity entity = response.getEntity();
		if (entity != null) {
			result = EntityUtils.toString(entity, "UTF-8");
		}
		response.close();
		httpclient.close();
		return result;
	}
	
	
	/**
	 * 
	 * 百度人脸检测 api
	 * @param url https://aip.baidubce.com/rest/2.0/face/v1/detect
	 * @param image 图片的base64    图片的base64编码是不包含图片头的，如（data:image/jpg;base64,）
	 * @param face_fields   age,beauty,expression,faceshape,gender,glasses,landmark,race,qualities 
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public static String baidu_face_jiance(String url, String image,String max_face_num	,String face_fields)
			throws ClientProtocolException, IOException {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httppost = new HttpPost(url);
		
		httppost.setHeader("Content-Type", "application/x-www-form-urlencoded");
		
		// 创建参数队列
		List<NameValuePair> formparams = new ArrayList<NameValuePair>();

		String result = null;
		formparams.add(new BasicNameValuePair("image", image));
		if(StringUtil.isEmpty(max_face_num)){
			formparams.add(new BasicNameValuePair("max_face_num", "1"));
		}else{
			formparams.add(new BasicNameValuePair("max_face_num", max_face_num));
		}
		formparams.add(new BasicNameValuePair("face_fields", face_fields));
		UrlEncodedFormEntity uefEntity;
		
		
		uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8");
		httppost.setEntity(uefEntity);
		// System.out.println("executing request " + httppost.getURI());
		CloseableHttpResponse response = httpclient.execute(httppost);

		HttpEntity entity = response.getEntity();
		if (entity != null) {
			result = EntityUtils.toString(entity, "UTF-8");
		}
		response.close();
		httpclient.close();
		return result;
	}
	
	
	
	
	
}

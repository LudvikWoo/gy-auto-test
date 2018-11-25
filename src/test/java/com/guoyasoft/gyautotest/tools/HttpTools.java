package com.guoyasoft.gyautotest.tools;

import com.alibaba.fastjson.JSON;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.net.ssl.SSLContext;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;

public class HttpTools <T> {

  public  Object sendHttpJsonAPI(String path,Object request,Class response){
    System.out.println("-------请求路径————————");
    System.out.println(path);
    String reqJson= JSON.toJSONString(request,true);
    System.out.println("-----请求报文：-----------");
    System.out.println(reqJson);
    String respJson=HttpTools.doPostByJson(path, reqJson, "UTF-8", "application/json");
    System.out.println("-------------响应报文------------");
    System.out.println(respJson);
    Object resp=JSON.parseObject(respJson,response);
    return resp;
  }

  //private static Logger logger = LoggerFactory.getLogger(HttpTools.class);

  /**
   * 方法说明 http get 请求
   *
   * @param uri 请求地址
   * @return 请求响应内容
   */
  public static String doGet(String uri) {
    String content = null;
    CloseableHttpClient httpClient = HttpClients.createDefault();
    HttpGet httpGet = new HttpGet(uri);
    // 执行请求.
    content = doRequest(httpClient, httpGet);
    return content;
  }

  /**
   * 方法说明 http post 请求
   *
   * @param uri 请求地址
   * @param params 请求附带的键值对参数
   * @return 请求响应内容
   */
  public static String doPost(String uri, Map<String, Object> params) {
    String content = null;
    CloseableHttpClient httpClient = HttpClients.createDefault();
    HttpPost httpPost = new HttpPost(uri);
    // 组装post请求参数
    List<NameValuePair> nameValuePairList = new ArrayList<NameValuePair>();
    Set<String> keySet = params.keySet();
    for (String key : keySet) {
      nameValuePairList.add(new BasicNameValuePair(key, (String) params.get(key)));
    }

    HttpEntity entity = null;
    try {
      entity = new UrlEncodedFormEntity(nameValuePairList, "UTF-8");
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }
    httpPost.setEntity(entity);
    // 执行请求
    content = doRequest(httpClient, httpPost);
    return content;
  }

  /**
   * 方法说明 http post 请求
   *
   * @param uri 请求地址
   * @param postData 请求附带的文本数据 请求附带的文本数据格式
   * @return 请求响应内容
   */
  public static String doPost(String uri, String postData) {
    return doPost(uri, postData, "UTF-8");
  }

  public static String doPost(String uri, String postData, String contentType) {
    String content = null;
    CloseableHttpClient httpClient = HttpClients.createDefault();
    HttpPost httpPost = new HttpPost(uri);
    StringEntity postEntity = new StringEntity(postData, contentType);
    postEntity.setContentType(contentType);
    httpPost.setEntity(postEntity);
    // 执行请求
    content = doRequest(httpClient, httpPost);
    return content;
  }

  /**
   * 方法说明 https get 请求(附带验证个人证书PKCS12)
   *
   * @param uri 请求地址
   * @param certFileUrl 个人PKCS12证书本地路径
   * @param password 证书密钥
   * @return 请求响应内容
   */
  public static String doGetWithCertPKCS12(String uri, String certFileUrl, String password) {
    String content = null;
    CloseableHttpClient httpClient = getSslHttpClient(certFileUrl, password);
    HttpGet httpGet = new HttpGet(uri);
    // 执行请求.
    content = doRequest(httpClient, httpGet);
    return content;
  }

  /**
   * 方法说明 https post 请求(附带验证个人证书PKCS12)
   *
   * @param uri 请求地址
   * @param postData 请求附带的文本数据
   * @param certFileUrl 个人PKCS12证书本地路径
   * @param password 证书密钥
   * @return 请求响应内容
   */
  public static String doPostWithCertPKCS12(String uri, String postData, String certFileUrl,
      String password) {
    String content = null;
    CloseableHttpClient httpClient = getSslHttpClient(certFileUrl, password);
    HttpPost httpPost = new HttpPost(uri);
    StringEntity postEntity = new StringEntity(postData, "UTF-8");
    httpPost.setEntity(postEntity);
    // 执行请求.
    content = doRequest(httpClient, httpPost);
    return content;
  }

  /**
   * 方法说明 初始化带个人PKCS12证书的 HttpClient
   *
   * @param certLocalPath 个人PKCS12证书本地路径
   * @param password 证书密钥
   * @return HttpClient
   */
  private static CloseableHttpClient getSslHttpClient(String certLocalPath, String password) {
    CloseableHttpClient httpClient = null;
    KeyStore keyStore = null;
    FileInputStream instream = null;
    try {
      keyStore = KeyStore.getInstance("PKCS12");
      instream = new FileInputStream(new File(certLocalPath));// 加载本地的证书进行https加密传输
      keyStore.load(instream, password.toCharArray());// 设置证书密码
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        instream.close();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    SSLContext sslcontext = null;
    try {
      sslcontext = SSLContexts.custom().loadKeyMaterial(keyStore, password.toCharArray()).build();
    } catch (Exception e) {
      e.printStackTrace();
    }
    SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext,
        new String[]{"TLSv1"}, null,
        SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
    httpClient = HttpClients.custom().setSSLSocketFactory(sslsf).build();
    return httpClient;
  }

  /**
   * 方法说明 发起 http 请求
   *
   * @param request 请求对象
   * @return 请求响应内容
   */
  private static String doRequest(CloseableHttpClient httpClient, HttpUriRequest request) {
    CloseableHttpResponse response = null;
    try {
      //logger.debug("发起http请求：{} ", request.getURI());
      response = httpClient.execute(request);
    } catch (ClientProtocolException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        httpClient.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    return praseResponse(response);
  }

  /**
   * 方法说明 解析请求响应
   *
   * @param response 响应对象
   * @return 请求响应内容
   */
  private static String praseResponse(CloseableHttpResponse response) {
    String content = "";
    if (response != null) {
      // 获取响应实体
      HttpEntity entity = response.getEntity();
      // 打印响应状态
      //logger.debug("请求返回状态：{} ", response.getStatusLine());
      if (entity != null) {
        try {
          content = EntityUtils.toString(entity, "UTF-8");
        } catch (ParseException e) {
          e.printStackTrace();
        } catch (IOException e) {
          e.printStackTrace();
        } finally {
          try {
            response.close();
          } catch (IOException e) {
            e.printStackTrace();
          }
        }
      }
    }
    // 打印响应内容
    //logger.debug("请求返回结果:{} ", content);
    return content;
  }
  public static String doPostByJson(String url, String jsonParams,String encoding){
    return doPostByJson(url, jsonParams, encoding,"application/json");
  }
  public static String doPostByJson(String url, String jsonParams){
    return doPostByJson(url, jsonParams, "UTF-8","application/json");
  }
  public static String doPostByParameters(String url, String jsonParams){
    return doPostByJson(url, jsonParams, "UTF-8","application/x-www-form-urlencoded");
  }
  public static String doPostByJson(String url, String jsonParams, String encoding,String contentType){
    try{

      int statusCode = 0;
      String body = "";
      String resultCode = "";

      // 设置协议http和https对应的处理socket链接工厂的对象
      Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
          .register("http", PlainConnectionSocketFactory.INSTANCE).build();

      PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager(
          socketFactoryRegistry);
      HttpClients.custom().setConnectionManager(connManager);

      // 创建自定义的httpclient对象
      CloseableHttpClient client = HttpClients.custom().setConnectionManager(connManager).build();
      // 创建post方式请求对象
      HttpPost httpPost = new HttpPost(url);

      StringEntity uefEntity = new StringEntity(jsonParams, encoding);
      uefEntity.setContentType(contentType);

      // 设置参数到请求对象中
      httpPost.setEntity(uefEntity);

      // 执行请求操作，并拿到结果（同步阻塞）
      CloseableHttpResponse response = client.execute(httpPost);

    /*  statusCode = response.getStatusLine().getStatusCode();


      if (200 != statusCode) {
        resultCode = "-1";
        return resultCode;
      }
*/

      // 获取结果实体
      HttpEntity entity = response.getEntity();
      if (entity != null) {
        // 按指定编码转换结果实体为String类型
        body = EntityUtils.toString(entity, encoding);
      }
      EntityUtils.consume(entity);

      // 释放链接
      response.close();
      return body;
    }catch (Exception e){
      e.printStackTrace();
      return null;
    }
  }
}

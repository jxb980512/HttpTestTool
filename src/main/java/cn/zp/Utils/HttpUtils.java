package cn.zp.Utils;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class HttpUtils {
    private PoolingHttpClientConnectionManager cm;

    public HttpUtils() {
        this.cm = new PoolingHttpClientConnectionManager();
        //设置最大链接数
        this.cm.setMaxTotal(100);
        //设置每个主机最大链接数
        this.cm.setDefaultMaxPerRoute(10);
    }

    //GET方式请求数据:返回页面数据
    public String doGetHtml(String url, Map<String, String> params) throws Exception {
        RequestConfig defaultConfig = RequestConfig.custom().setCookieSpec(CookieSpecs.STANDARD).build();

        // 创建get请求实例
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //创建urlBuilder
        URIBuilder uriBuilder = new URIBuilder(url);
        for (Map.Entry<String, String> entry : params.entrySet()) {
            String mapKey = entry.getKey();
            String mapValue = entry.getValue();
            uriBuilder.setParameter(mapKey, mapValue);
        }
//        uriBuilder.setParameter("keyword","httpclient");
        //设置参数
        HttpGet httpGet = new HttpGet(uriBuilder.build());
        //设置cookie编码
        if (httpGet.getFirstHeader("Set-Cookie") != null) {
            String cookie = httpGet.getFirstHeader("Set-Cookie").getValue();
            httpGet.addHeader("cookie", cookie);
        }
        httpGet.setConfig(defaultConfig);
        System.out.println(httpGet);
        CloseableHttpResponse response = null;
        String content = "";
        try {
            response = httpClient.execute(httpGet);
            if (response != null) {
                content = EntityUtils.toString(response.getEntity(), "utf8");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return content;
    }

    public String doPostPar(String url, List<NameValuePair> params) throws Exception {
        CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(this.cm).build();
        HttpPost httpGet = new HttpPost(url);
        //创建表单中Entity对象:第一个参数封装的表单数据，第二个是编码
        UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(params, "utf8");
        //设置表单的Entity对象到Post请求中
        httpGet.setEntity(formEntity);
        CloseableHttpResponse response = null;
        String content = null;
        try {
            response = httpClient.execute(httpGet);
            if (response != null) {
                content = EntityUtils.toString(response.getEntity(), "utf8");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return content;
    }

    public String doPut(String url, Map<String, String> params, Charset encoding) throws Exception {
        CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(this.cm).build();
        HttpPut httpPut = new HttpPut(url);
        //header存放 LPCC_TOKEN
        //httpPut.addHeader(Const.,"jwt "+authorization);
        httpPut.addHeader(HTTP.CONTENT_TYPE, "application/json; charset=utf-8");
        if (params != null && params.size() > 0) {
            StringEntity se = new StringEntity(JsonUtil.mapToJson(params), encoding);
            httpPut.setEntity(se);
        }
        HttpResponse httpResponse = null;
        String res = null;
        try {
            httpResponse = httpClient.execute(httpPut);
            if (httpResponse != null) {
                res = EntityUtils.toString(httpResponse.getEntity(), encoding);
            }
        } catch (IOException e) {
        }
        return res;
    }

    public String doDelete(String url, Map<String, String> params) throws Exception {
        RequestConfig defaultConfig = RequestConfig.custom().setCookieSpec(CookieSpecs.STANDARD).build();

        // 创建get请求实例
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //创建urlBuilder
        URIBuilder uriBuilder = new URIBuilder(url);
        for (Map.Entry<String, String> entry : params.entrySet()) {
            String mapKey = entry.getKey();
            String mapValue = entry.getValue();
            uriBuilder.setParameter(mapKey, mapValue);
         }
            HttpDelete httpDelete = new HttpDelete(uriBuilder.build());
            //设置cookie编码
            if (httpDelete.getFirstHeader("Set-Cookie") != null) {
                String cookie = httpDelete.getFirstHeader("Set-Cookie").getValue();
                httpDelete.addHeader("cookie", cookie);
            }
            httpDelete.setConfig(defaultConfig);
            System.out.println(httpDelete);
            CloseableHttpResponse response = null;
            String content = "";
            try {
                response = httpClient.execute(httpDelete);
                if (response != null) {
                    content = EntityUtils.toString(response.getEntity(), "utf8");
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        return content;
    }
}

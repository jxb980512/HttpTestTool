package cn.zp.Utils;

import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.*;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.Map;

public class codeUtils {
    private PoolingHttpClientConnectionManager cm;

    public codeUtils() {
        this.cm = new PoolingHttpClientConnectionManager();
        //设置最大链接数
        this.cm.setMaxTotal(100);
        //设置每个主机最大链接数
        this.cm.setDefaultMaxPerRoute(10);
    }

    public int codeGet(String url, Map<String, String> params) {
        RequestConfig defaultConfig = RequestConfig.custom().setCookieSpec(CookieSpecs.STANDARD).build();
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = null;
        try {
            URIBuilder uriBuilder = new URIBuilder(url);
            for (Map.Entry<String, String> entry : params.entrySet()) {
                String mapKey = entry.getKey();
                String mapValue = entry.getValue();
                uriBuilder.setParameter(mapKey, mapValue);
            }
            httpGet = new HttpGet(uriBuilder.build());
            if (httpGet.getFirstHeader("Set-Cookie") != null) {
                String cookie = httpGet.getFirstHeader("Set-Cookie").getValue();
                httpGet.addHeader("cookie", cookie);
            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        httpGet.setConfig(defaultConfig);
        CloseableHttpResponse response=null;
        int code=0;
        try {
            response = httpClient.execute(httpGet);
            code=response.getStatusLine().getStatusCode();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
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
        return code;

    }
    public int codePost(String url, Map<String, String> params, Charset encoding) {
        CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(this.cm).build();
        HttpPost httpPost = new HttpPost(url);
        httpPost.addHeader(HTTP.CONTENT_TYPE, "application/json; charset=utf-8");
        if (params != null && params.size() > 0) {
            StringEntity se = null;
            try {
                se = new StringEntity(JsonUtil.mapToJson(params), encoding);
            } catch (Exception e) {
                e.printStackTrace();
            }
            httpPost.setEntity(se);
        }
        CloseableHttpResponse response = null;
        int code=0;
        try {
            response = httpClient.execute(httpPost);
            code = response.getStatusLine().getStatusCode();
        } catch (Exception e) {
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
        return code;
    }
    public int codePut(String url, Map<String, String> params, Charset encoding) {
        CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(this.cm).build();
        HttpPut httpPut = new HttpPut(url);
        httpPut.addHeader(HTTP.CONTENT_TYPE, "application/json; charset=utf-8");
        if (params != null && params.size() > 0) {
            StringEntity se = null;
            try {
                se = new StringEntity(JsonUtil.mapToJson(params), encoding);
            } catch (Exception e) {
                e.printStackTrace();
            }
            httpPut.setEntity(se);
        }
        CloseableHttpResponse response = null;
        int code=0;
        try {
            response = httpClient.execute(httpPut);
            code = response.getStatusLine().getStatusCode();
        } catch (Exception e) {
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
        return code;
    }
    public int codeDelete(String url, Map<String, String> params) {
        RequestConfig defaultConfig = RequestConfig.custom().setCookieSpec(CookieSpecs.STANDARD).build();
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpDelete httpDelete = null;
        try {
            URIBuilder uriBuilder = new URIBuilder(url);
            for (Map.Entry<String, String> entry : params.entrySet()) {
                String mapKey = entry.getKey();
                String mapValue = entry.getValue();
                uriBuilder.setParameter(mapKey, mapValue);
            }
            httpDelete = new HttpDelete(uriBuilder.build());
            if (httpDelete.getFirstHeader("Set-Cookie") != null) {
                String cookie = httpDelete.getFirstHeader("Set-Cookie").getValue();
                httpDelete.addHeader("cookie", cookie);
            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        httpDelete.setConfig(defaultConfig);
        CloseableHttpResponse response=null;
        int code=0;
        try {
            response = httpClient.execute(httpDelete);
            code=response.getStatusLine().getStatusCode();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
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
        return code;

    }
    private RequestConfig getConfig() {
        RequestConfig config = RequestConfig.custom().setConnectionRequestTimeout(500).setConnectTimeout(1000).setSocketTimeout(10000).build();
        return config;
    }
}

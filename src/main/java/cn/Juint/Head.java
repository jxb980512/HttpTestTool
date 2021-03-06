package cn.Juint;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Head {
    @Test
    public void show1() throws IOException {
        String destURLStr= "http://localhost:8080/test.jsp#";
        URL destURL = null;
        URLConnection urlCon = null;
        HttpURLConnection httpUrlCon= null;
        try {
            destURL = new URL(destURLStr);
            urlCon = destURL.openConnection();
            httpUrlCon = (HttpURLConnection)urlCon;
            //set request property
            httpUrlCon.setRequestProperty("Accept-Encoding", "gzip,deflate,sdch");
            //可根据需要添加自定义请求头
//            httpUrlCon.setRequestProperty("Test Header1", "test1");
//            httpUrlCon.setRequestProperty("Test Header2", "test2");
            httpUrlCon.connect();
            //echo request property
            echoRequestHeaders(httpUrlCon);
            //echo response property
            echoResponseHeaders(httpUrlCon);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void echoRequestHeaders(HttpURLConnection httpUrlCon){
        System.out.println("Request Headers:");
        System.out.println(" " + httpUrlCon.getRequestMethod() + " / " + " HTTP/1.1");
        System.out.println(" Host: " + httpUrlCon.getRequestProperty("Host"));
        System.out.println(" Connection: " + httpUrlCon.getRequestProperty("Connection"));
        System.out.println(" Accept: " + httpUrlCon.getRequestProperty("Accept"));
        System.out.println(" User-Agent: " + httpUrlCon.getRequestProperty("User-Agent"));
        System.out.println(" Accept-Encoding: " + httpUrlCon.getRequestProperty("Accept-Encoding"));
        System.out.println(" Accept-Language: " + httpUrlCon.getRequestProperty("Accept-Language"));
        System.out.println(" Cookie: " + httpUrlCon.getRequestProperty("Cookie"));
        System.out.println(" Connection: " + httpUrlCon.getHeaderField("Connection"));//利用另一种读取HTTP头字段
        System.out.println();
    }
    public static void echoResponseHeaders(HttpURLConnection httpUrlCon) throws IOException{
        System.out.println("Response Headers:");
        System.out.println(" " + "HTTP/1.1 " + httpUrlCon.getResponseCode() + " " + httpUrlCon.getResponseMessage());
        System.out.println(" status: " + httpUrlCon.getResponseCode() + " " + httpUrlCon.getResponseMessage());
        System.out.println(" content-encoding: " + httpUrlCon.getContentEncoding());
        System.out.println(" content-length : " + httpUrlCon.getContentLength());
        System.out.println(" content-type: " + httpUrlCon.getContentType());
        System.out.println(" Date: " + httpUrlCon.getDate());
        System.out.println(" ConnectTimeout: " + httpUrlCon.getConnectTimeout());
        System.out.println(" expires: " + httpUrlCon.getExpiration());
        System.out.println(" content-type: " + httpUrlCon.getHeaderField("content-type"));//利用另一种读取HTTP头字段
        System.out.println();
    }
}
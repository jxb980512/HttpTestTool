package cn.Juint;

import cn.zp.Utils.HttpHeaderUtils;
import cn.zp.Utils.HttpUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.Header;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;

public class FastJson {
    @Test
    public void Test1() {
        String s = "";
        HashMap map = new HashMap();
        map.put("ueser", "1");
        String url = "http://www.baidu.com";
        try {
            HttpUtils utils = new HttpUtils();//获取响应体
            s = utils.doGetHtml(url, map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //直接解析字符串
        Document dao = Jsoup.parse(s);
        String title = dao.getElementsByTag("title").first().text();
        Elements script = dao.getElementsByTag("script");
        Attributes attributes = dao.attributes();
        System.out.println(attributes.toString());
        Elements span = dao.select("span");
        for (Element str:span) {
            System.out.println(str.text());

        }

    }
        @Test
       public void Test3(){
        String url = "http://www.baidu.com";
            try {
                Document dao = Jsoup.parse(new URL(url), 1000);
                String title = dao.getElementsByTag("title").first().text();
                System.out.println(title);
            } catch (IOException e) {


            }
        }
    }

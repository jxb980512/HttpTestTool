package cn.Juint;

import cn.zp.Utils.HttpHeaderUtils;
import org.apache.http.Header;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class ManyHeader {
    @Test
    public void Test1(){
        String[][] head=new String[10][20];
        String[] a=new String[10];
        HttpHeaderUtils headerUtils = new HttpHeaderUtils();
        Header[] headers = null;
        int d=0,f=0;
        HashMap date = new HashMap();
        date.put("user","1");
        String url="http://www.baidu.com";
        try {
            headers = headerUtils.doGetHtml(url,date);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        for (Header str:headers){
                String str1=String.valueOf(str);
                head[d][f++]=str1;

        }
    }
}

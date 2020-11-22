package cn.Juint;

import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
import java.util.Set;

public class HeadTest {
    @Test
    public void show() throws Exception {
        String link="http://localhost:8080/ServletTest1?user=1&password=peng";
        URL url = new URL(link);
        URLConnection conn = url.openConnection();
        Map headers = conn.getHeaderFields();
        Set<String> keys = headers.keySet();
        for( String key : keys ){
            String val = conn.getHeaderField(key);
            System.out.println(key+"："+val);
        }
    }
}

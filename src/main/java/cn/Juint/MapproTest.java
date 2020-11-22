package cn.Juint;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class MapproTest {
    @Test
    public void Test1(){
        HashMap<String,HashMap<String,String>> map=new HashMap();
        HashMap map1=new HashMap();
        map1.put("zp","peng");
        map1.put("zp1","peng1");
        map.put("1",map1);
        HashMap<String, String> hashMap = map.get("1");

    }
    @Test
    public void Test2(){
        String[][] a=new String[10][10];
        int k=1;
        for(int i=0;i<2;i++){
            for(int j=0;j<2;j++){
               a[i][j]=String.valueOf(k++);
            }
        }
        System.out.println(a.length);
    }
}

package cn.Juint.Read;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;

public class ReadTest {
    @Test
    public void Test() throws Exception {
        String[][] date= new String[10][10];
        String value=null;
        int i=0,j=0,d=0,e=0;
        XSSFWorkbook workbook = new XSSFWorkbook("D:\\data\\data.xlsx");
        XSSFSheet at = workbook.getSheetAt(0);
        for (Row row:at) {
            for (Cell cell:row) {
                value = String.valueOf(cell.getStringCellValue());
                date[i][j++]=value;
            }
            j=0;
            i++;
        }
        String[] uri=new String[10];
        String[][] keys=new String[10][20];
        String[][] values=new String[10][20];
        HashMap<String,HashMap<String,String>> map=new HashMap();
        for(int n=0;date[n][0]!=null;n++){
            uri[n]=date[n][0];
        }
        for(int b=0;b<10;b++){
            for(int c=1;date[b][c]!=null;c=c+2){
                keys[b][e++]=date[b][c];
            }
        }
        for(int b=0;b<10;b++){
            for(int c=2;date[b][c]!=null;c=c+2){
                values[b][d++]=date[b][c];
            }
        }
        for(int m=0;m<keys.length;m++){
            HashMap<String, String> map1 = new HashMap<>();
            for(int a=0;a<keys[m].length;a++){
                map1.put(keys[m][a],values[m][a]);
            }
            map.put(String.valueOf(m),map1);
        }


    }
}

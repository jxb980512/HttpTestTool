package cn.zp.Servlet;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;

@WebServlet("/ServletDateWay2")
public class ServletDateWay2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[][] date= new String[10][10];
        String tijiao = request.getParameter("Opt");
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
        String key="";
        String val="";
        String[] uri=new String[20];
        String[][] keys=new String[10][20];
        String[][] values=new String[10][20];
        HashMap<String,HashMap<String,String>> map=new HashMap();
        for(int n=0;date[n][0]!=null;n++){
            uri[n]=date[n][0];
        }
        for(int b=0;b<10;b++){
            for(int c=1;date[b][c]!=null;c=c+2){
                keys[b][e++]=date[b][c];
                key=key+date[b][c]+".";
            }
            key=key+",";
        }
        for(int b=0;b<10;b++){
            for(int c=2;date[b][c]!=null;c=c+2){
                values[b][d++]=date[b][c];
                val=val+date[b][c]+".";
            }
            val=val+",";
        }
        for(int m=0;m<keys.length;m++){
            HashMap<String, String> map1 = new HashMap<>();
            for(int a=0;a<keys[m].length;a++){
                if(keys[m][a]!=null){
                    map1.put(keys[m][a],values[m][a]);
                }
            }
            map.put(String.valueOf(m),map1);
        }
        request.setAttribute("kf",key);
        request.setAttribute("vf",val);
        request.setAttribute("url",uri);
        request.setAttribute("Date",map);
        if (Objects.equals(tijiao, "get")){
            request.getRequestDispatcher("/ServletGet2").forward(request,response);
        } else if(Objects.equals(tijiao, "post")){
            request.getRequestDispatcher("/ServletPost2").forward(request,response);
        } else if(Objects.equals(tijiao, "put")){
            request.getRequestDispatcher("/ServletPut2").forward(request,response);
        }
        else if(Objects.equals(tijiao, "delete")){
            request.getRequestDispatcher("/ServletDelete2").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request,response);
    }
}

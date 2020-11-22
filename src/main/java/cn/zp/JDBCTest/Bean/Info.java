package cn.zp.JDBCTest.Bean;

public class Info {
    private int id;
    private String ke;



    private String val;
    private String da;
    private String ti;
    private String method;
    private String co;

    public Info() {
    }

    public Info(int id, String url, String ke, String val, String da, String ti, String method, String co) {
        this.id = id;
        this.url = url;
        this.ke = ke;
        this.val = val;
        this.da = da;
        this.ti = ti;
        this.method = method;
        this.co = co;
    }

    private String url;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getKe() {
        return ke;
    }

    public void setKe(String ke) {
        this.ke = ke;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    public String getDa() {
        return da;
    }

    public void setDa(String da) {
        this.da = da;
    }

    public String getTi() {
        return ti;
    }

    public void setTi(String ti) {
        this.ti = ti;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getCo() {
        return co;
    }

    public void setCo(String co) {
        this.co = co;
    }
    @Override
    public String toString() {
        return "Info{" +
                "id=" + id +
                ", ke='" + ke + '\'' +
                ", val='" + val + '\'' +
                ", da='" + da + '\'' +
                ", ti='" + ti + '\'' +
                ", method='" + method + '\'' +
                ", co='" + co + '\'' +
                ", url='" + url + '\'' +
                '}';
    }



}

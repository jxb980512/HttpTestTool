package cn.zp.PageBean;

import java.util.List;

public class PageBean<T> {
    private int totCount;//总记录数
    private int totpage;//总页码
    private List<T> lsit;
    private int currentPage;//当前页码
    private int rows;//每页的记录数

    public int getTotCount() {
        return totCount;
    }

    public void setTotCount(int totCount) {
        this.totCount = totCount;
    }

    public int getTotpage() {
        return totpage;
    }

    public void setTotpage(int totpage) {
        this.totpage = totpage;
    }

    public List<T> getLsit() {
        return lsit;
    }

    public void setLsit(List<T> lsit) {
        this.lsit = lsit;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "totCount=" + totCount +
                ", totpage=" + totpage +
                ", lsit=" + lsit +
                ", currentPage=" + currentPage +
                ", rows=" + rows +
                '}';
    }
}

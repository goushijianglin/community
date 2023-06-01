package com.cc.community.entity;

/**
 * @author jiawei
 * @create 2023/05/28
 */

public class Page {
    private int current=1;
    private int limit = 10;

    private int rows;
    private String path;

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        if(rows>=0) {
            this.rows = rows;
        }
    }

    public int getCurrent() {
        return current;

    }

    public void setCurrent(int current) {
        if (current > 0) {
            this.current = current;
        }
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        if (limit >= 1 && limit <= 100) {
            this.limit = limit;
        }
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getFrom() {
        if((current-2)>0){
            return current-2;
        }else {
            return 1;
        }
    }


    public int getTo() {
        if((current+2)<=getTotal()){
            return current+2;

        }else {
            return getTotal();
        }
    }

    public int getStartDiscuss() {
        return (current - 1) * limit;
    }

    public int getTotal() {
        return (int) Math.ceil(rows / limit);
    }
}

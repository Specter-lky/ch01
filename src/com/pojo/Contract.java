package com.pojo;

import java.util.Date;

public class Contract {
    private int ct_no;
    private String s_name;
    private String c_name;
    private Date ct_date;
    private int ct_status;

    public Contract() {
    }

    public Contract(int ct_no, String s_name, String c_name, Date ct_date, int ct_status) {
        this.ct_no = ct_no;
        this.s_name = s_name;
        this.c_name = c_name;
        this.ct_date = ct_date;
        this.ct_status = ct_status;
    }

    public int getCt_no() {
        return ct_no;
    }

    public void setCt_no(int ct_no) {
        this.ct_no = ct_no;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public Date getCt_date() {
        return ct_date;
    }

    public void setCt_date(Date ct_date) {
        this.ct_date = ct_date;
    }

    public int getCt_status() {
        return ct_status;
    }

    public void setCt_status(int ct_status) {
        this.ct_status = ct_status;
    }
    @Override
    public String toString(){
        return "ct_no:"+ct_no+",s_name:"+s_name+",c_name:"+c_name+",ct_date:"+ct_date;
    }
}

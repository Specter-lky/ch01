package com.pojo;

import java.util.Date;

public class Contract {
    private int ct_no;
    private int s_no;
    private String s_name;
    private int c_no;
    private String c_name;
    private Date ct_date;
    private int ct_status;

    public Contract(int ct_no, int s_no, String s_name, int c_no, String c_name, Date ct_date, int ct_status) {
        this.ct_no = ct_no;
        this.s_no = s_no;
        this.s_name = s_name;
        this.c_no = c_no;
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

    public int getS_no() {
        return s_no;
    }

    public void setS_no(int s_no) {
        this.s_no = s_no;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public int getC_no() {
        return c_no;
    }

    public void setC_no(int c_no) {
        this.c_no = c_no;
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
}

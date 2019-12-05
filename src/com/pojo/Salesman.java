package com.pojo;

public class Salesman {
    private int s_no;
    private String s_name;
    private String s_phone;
    private String s_adress;
    private String s_password;

    public Salesman(int s_no, String s_name, String s_phone, String s_adress,String s_password) {
        this.s_no = s_no;
        this.s_name = s_name;
        this.s_phone = s_phone;
        this.s_adress = s_adress;
        this.s_password=s_password;
    }

    public Salesman(){
        super();
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

    public String getS_phone() {
        return s_phone;
    }

    public void setS_phone(String s_phone) {
        this.s_phone = s_phone;
    }

    public String getS_adress() {
        return s_adress;
    }

    public void setS_adress(String s_adress) {
        this.s_adress = s_adress;
    }

    public String getS_password() { return s_password; }

    public void setS_password(String s_password) { this.s_password = s_password; }

    @Override
    public String toString(){
        return "s_no:"+s_no+",s_name:"+s_name+",s_phone:"+s_phone+",s_adress:"+s_adress+",s_password:"+s_password+"";
    }
}

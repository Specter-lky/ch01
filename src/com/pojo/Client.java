package com.pojo;

public class Client {
    private String c_name;
    private String c_phone;
    private String c_adress;

    public Client( String c_name, String c_phone, String c_adress) {
        this.c_name = c_name;
        this.c_phone = c_phone;
        this.c_adress = c_adress;
    }


    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public String getC_phone() {
        return c_phone;
    }

    public void setC_phone(String c_phone) {
        this.c_phone = c_phone;
    }

    public String getC_adress() {
        return c_adress;
    }

    public void setC_adress(String c_adress) {
        this.c_adress = c_adress;
    }
    @Override
    public String toString(){
        return "c_name:"+c_name+",c_phone:"+c_phone+",c_adress:"+c_adress+"";
    }
}

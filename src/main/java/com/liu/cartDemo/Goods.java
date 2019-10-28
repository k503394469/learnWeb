package com.liu.cartDemo;

public class Goods {
    private Integer pid;
    private String pname;
    private String pdesc;
    private Double price;
    private Integer num;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPdesc() {
        return pdesc;
    }

    public void setPdesc(String pdesc) {
        this.pdesc = pdesc;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", pdesc='" + pdesc + '\'' +
                ", price=" + price +
                ", num=" + num +
                '}';
    }
}

package com.example.entity;


import java.util.Date;

/**
 *  商品类 -- POJO(Plain Ordinary Java Object简单Java实体)
 */
public class Product {

  private String pid;
  private String pname;
  private double market_price;
  private double shop_price;
  private String pimage;
  private Date pdate=new Date();

  /*  是否热门: 1-热门("新上架")    0-非热门 */
  private int is_hot;
  private String pdesc;

  /*  是否下架:  0-未下架    1-已下架*/
  private long pflag;
  private String cid;   /*  所属的商品分类(外键) */

  public String getPid() {
    return pid;
  }

  public void setPid(String pid) {
    this.pid = pid;
  }

  public String getPname() {
    return pname;
  }

  public void setPname(String pname) {
    this.pname = pname;
  }

  public double getMarket_price() {
    return market_price;
  }

  public void setMarket_price(double market_price) {
    this.market_price = market_price;
  }

  public double getShop_price() {
    return shop_price;
  }

  public void setShop_price(double shop_price) {
    this.shop_price = shop_price;
  }

  public String getPimage() {
    return pimage;
  }

  public void setPimage(String pimage) {
    this.pimage = pimage;
  }

  public Date getPdate() {
    return pdate;
  }

  public void setPdate(Date pdate) {
    this.pdate = pdate;
  }

  public int getIs_hot() {
    return is_hot;
  }

  public void setIs_hot(int is_hot) {
    this.is_hot = is_hot;
  }

  public String getPdesc() {
    return pdesc;
  }

  public void setPdesc(String pdesc) {
    this.pdesc = pdesc;
  }

  public long getPflag() {
    return pflag;
  }

  public void setPflag(long pflag) {
    this.pflag = pflag;
  }

  public String getCid() {
    return cid;
  }

  public void setCid(String cid) {
    this.cid = cid;
  }
}

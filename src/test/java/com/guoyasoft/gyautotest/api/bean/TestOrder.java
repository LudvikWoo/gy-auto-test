package com.guoyasoft.gyautotest.api.bean;

import java.util.List;

public class TestOrder {

  /**
   * ordeerPrice : 0
   * orderLineList : [{"qty":0,"skuCode":"string"}]
   * receiver : string
   * receiverPhone : string
   * receivingAddress : string
   * userName : string
   */

  private int ordeerPrice;
  private String receiver;
  private String receiverPhone;
  private String receivingAddress;
  private String userName;
  private List<OrderLineListLogin> orderLineList;

  public int getOrdeerPrice() {
    return ordeerPrice;
  }

  public void setOrdeerPrice(int ordeerPrice) {
    this.ordeerPrice = ordeerPrice;
  }

  public String getReceiver() {
    return receiver;
  }

  public void setReceiver(String receiver) {
    this.receiver = receiver;
  }

  public String getReceiverPhone() {
    return receiverPhone;
  }

  public void setReceiverPhone(String receiverPhone) {
    this.receiverPhone = receiverPhone;
  }

  public String getReceivingAddress() {
    return receivingAddress;
  }

  public void setReceivingAddress(String receivingAddress) {
    this.receivingAddress = receivingAddress;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public List<OrderLineListLogin> getOrderLineList() {
    return orderLineList;
  }

  public void setOrderLineList(List<OrderLineListLogin> orderLineList) {
    this.orderLineList = orderLineList;
  }

  public static class OrderLineListLogin {

    /**
     * qty : 0
     * skuCode : string
     */

    private int qty;
    private String skuCode;

    public int getQty() {
      return qty;
    }

    public void setQty(int qty) {
      this.qty = qty;
    }

    public String getSkuCode() {
      return skuCode;
    }

    public void setSkuCode(String skuCode) {
      this.skuCode = skuCode;
    }
  }
}

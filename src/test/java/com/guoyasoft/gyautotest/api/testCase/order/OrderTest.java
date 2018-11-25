package com.guoyasoft.gyautotest.api.testCase.order;

import com.guoyasoft.gyautotest.api.bean.order.AddOrderReq;
import com.guoyasoft.gyautotest.api.bean.order.AddOrderReq.OrderLineListLogin;
import com.guoyasoft.gyautotest.tools.JdbcTools;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.testng.annotations.Test;

public class OrderTest {

  public void addOrder(){
    AddOrderReq addOrderReq=new AddOrderReq();
    List<OrderLineListLogin> list=new ArrayList<OrderLineListLogin>();
    OrderLineListLogin item=new OrderLineListLogin();
    item.setQty(10);
    item.setSkuCode("sdfdfdf");
    list.add(item);
    addOrderReq.setOrderLineList(list);
  }

  @Test
  public void testMethod(){
    try {
      JdbcTools jdbcTools=new JdbcTools();
      Map record=jdbcTools.getRecord("select * from Course where c_id='01'");
      System.out.println(record.get("c_name"));

      String driver="com.mysql.jdbc.Driver";
      String url="jdbc:mysql://qa.guoyasoft.com:3306/db_practice?useUnicode=true&characterEncoding=utf8";
      String userName="";
      String password="";
      String sql="";
      JdbcTools jdbcTools1=new JdbcTools();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

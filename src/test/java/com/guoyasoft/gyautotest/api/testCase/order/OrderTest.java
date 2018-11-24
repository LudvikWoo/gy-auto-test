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
      Map map = JdbcTools.getRecord("SELECT t.`customer_id`,t.`customer_name`,t.`cert` FROM t_user_customer t WHERE t.`customer_name`='吴令'");
      System.out.println("客户ID="+(int)map.get("customer_id"));
      System.out.println("客户姓名="+(String)map.get("customer_name"));

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

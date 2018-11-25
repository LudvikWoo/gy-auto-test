package com.guoyasoft.gyautotest.api.testCase.account;

import org.testng.annotations.Test;

public class AccountTest {
  @Test
  public void getAccInfo(){
    System.out.println("-------------账户模块：获取账户信息------------");
  }

  @Test
  public void charge(){
    System.out.println("-------------账户模块：充值------------");
  }

  @Test
  public void recharge(){
    System.out.println("-------------账户模块：扣款------------");
  }

  @Test
  public void withdraw(){
    System.out.println("-------------账户模块：提现------------");
  }

}

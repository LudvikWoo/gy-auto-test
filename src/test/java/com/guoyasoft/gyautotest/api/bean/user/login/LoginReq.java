package com.guoyasoft.gyautotest.api.bean.user.login;

public class LoginReq {

  /**
   * pwd : string
   * userName : string
   */

  private String pwd;
  private String userName;

  public String getPwd() {
    return pwd;
  }

  public void setPwd(String pwd) {
    this.pwd = pwd;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }
}

package com.guoyasoft.gyautotest.api.bean.user.login;

public class LoginResp {

  /**
   * respCode : 9999
   * respDesc : 登录失败,用户名不存在
   */

  private String respCode;
  private String respDesc;

  public String getRespCode() {
    return respCode;
  }

  public void setRespCode(String respCode) {
    this.respCode = respCode;
  }

  public String getRespDesc() {
    return respDesc;
  }

  public void setRespDesc(String respDesc) {
    this.respDesc = respDesc;
  }
}

package com.guoyasoft.gyautotest.api.bean.user.signUp;

public class SignUpResp {

  /**
   * respBase : {"respCode":"0000","respDesc":"注册成功；用户ID:16635"}
   * userName : wuling666
   * accoutId : 16679
   * cstId : 25990
   * userId : 16635
   */

  private RespBaseLogin respBase;
  private String userName;
  private int accoutId;
  private int cstId;
  private int userId;

  public RespBaseLogin getRespBase() {
    return respBase;
  }

  public void setRespBase(RespBaseLogin respBase) {
    this.respBase = respBase;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public int getAccoutId() {
    return accoutId;
  }

  public void setAccoutId(int accoutId) {
    this.accoutId = accoutId;
  }

  public int getCstId() {
    return cstId;
  }

  public void setCstId(int cstId) {
    this.cstId = cstId;
  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public static class RespBaseLogin {

    /**
     * respCode : 0000
     * respDesc : 注册成功；用户ID:16635
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
}

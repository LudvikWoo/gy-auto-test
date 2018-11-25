package com.guoyasoft.gyautotest.api.bean.changePwd;

public class ChangePwdReq {

  /**
   * newPwd : string
   * oldPwd : string
   * reNewPwd : string
   * userName : string
   */

  private String newPwd;
  private String oldPwd;
  private String reNewPwd;
  private String userName;

  public String getNewPwd() {
    return newPwd;
  }

  public void setNewPwd(String newPwd) {
    this.newPwd = newPwd;
  }

  public String getOldPwd() {
    return oldPwd;
  }

  public void setOldPwd(String oldPwd) {
    this.oldPwd = oldPwd;
  }

  public String getReNewPwd() {
    return reNewPwd;
  }

  public void setReNewPwd(String reNewPwd) {
    this.reNewPwd = reNewPwd;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }
}

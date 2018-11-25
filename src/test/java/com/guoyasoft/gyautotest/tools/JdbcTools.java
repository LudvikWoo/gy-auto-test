package com.guoyasoft.gyautotest.tools;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class JdbcTools {
  private  Connection conn;
  private  PreparedStatement ps;
  private  ResultSet rs;
  private  Statement st;
  private String driver;
  private String url;
  private String username;
  private String password;

  public JdbcTools(){
    Properties prop=PropertiesTools.getProperties("src\\test\\resources\\db\\mysql.properties");
    // 第1步：选择驱动，有mysql的，有orace，类似不同版本的浏览器
    this.driver = prop.getProperty("db.mysql.driver");
    // 第2步：提供链接地址，哪台主机，哪个应用port，哪个实例（类似tomcat的应用名）
    this.url =prop.getProperty("db.mysql.url");
    // 第3步：登录，用户名、密码
    this.username = prop.getProperty("db.mysql.username");
    // 第4步：建立链接，固定写法
    this.password = prop.getProperty("db.mysql.password");
  }

  public JdbcTools(String driver,String url,String username,String password){
    this.driver=driver;
    this.url=url;
    this.username=username;
    this.password=password;
  }

  public Connection getConnection() {
    try {
      Class.forName(driver); // classLoader,加载对应驱动
      conn = (Connection) DriverManager.getConnection(url, username,
          password);
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return conn;
  }

  public int update(String sql) {
    System.out.println(sql);
    int result = 0;
    // 第1步：建立数据库链接
    Connection conn = getConnection();
    // 第2步：写SQL魔板
    // 第3步：按照真实数据生成执行SQL
    Statement st;
    ResultSet set;
    try {
      st = conn.createStatement();
      // 执行拼装好的sql,如果是更新，则返回更新条数
      result = st.executeUpdate(sql);
      // 关闭链接
      st.close();
      conn.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return result;
  }

  public Map getRecord(String sql) {
    try{
      System.out.println(sql);
      List<Map> list=getRecords(sql);
      if(list.size()==1){
        return list.get(0);
      }else if(list.size()==0){
        System.out.println("-----------查询结果为空-------------");
        return null;
      }else{
        System.out.println("-----------查询结果为"+list.size()+"记录，请核实数据---------");
        return null;
      }
    }catch (Exception e){
      e.printStackTrace();
      return null;
    }
  }

  // 测试能否与oracle数据库连接成功
  public  List<Map> getRecords(String sql) {
    getConnection();
    if (conn == null) {
      System.out.println("与数据库连接失败！");
    } else {
      System.out.println("与数据库连接成功！");
    }
    try {
      st = (Statement) conn.createStatement(); // 创建用于执行静态sql语句的Statement对象，st属局部变量

      ResultSet rs = st.executeQuery(sql); // 执行sql查询语句，返回查询数据的结果集
      ResultSetMetaData rsmd = rs.getMetaData();
      int fieldCount = rsmd.getColumnCount();
      List records = new ArrayList();
      while (rs.next()) {
        Map valueMap = new LinkedHashMap();
        for (int i = 1; i <= fieldCount; i++) {
          String fieldClassName = rsmd.getColumnClassName(i);
          String fieldName = rsmd.getColumnName(i);
          _recordMappingToMap(fieldClassName, fieldName, rs, valueMap);
        }
        records.add(valueMap);
      }
      System.out.println("记录条数："+records.size());
      return records;
    } catch (SQLException e) {
      e.printStackTrace();
      System.out.println("查询数据失败");
      return null;
    }finally {
      try {
        conn.close(); // 关闭数据库连接
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }
  /**
   * 将ResultSet结果集中的记录映射到Map对象中.
   *
   * @param fieldClassName 是JDBC API中的类型名称,
   * @param fieldName 是字段名，
   * @param rs 是一个ResultSet查询结果集,
   * @param fieldValue Map对象,用于存贮一条记录.
   */
  private void _recordMappingToMap(String fieldClassName, String fieldName, ResultSet rs, Map
      fieldValue)
      throws SQLException {
    fieldName = fieldName.toLowerCase();
    // 优先规则：常用类型靠前
    if (fieldClassName.equals("java.lang.String")) {
      String s = rs.getString(fieldName);
      if (rs.wasNull()) {
        fieldValue.put(fieldName, null);
      } else {
        fieldValue.put(fieldName, s);
      }
    } else if (fieldClassName.equals("java.lang.Integer")) {
      int s = rs.getInt(fieldName);
      if (rs.wasNull()) {
        fieldValue.put(fieldName, null);
      } else {
        fieldValue.put(fieldName, s);// 早期jdk需要包装，jdk1.5后不需要包装
      }
    } else if (fieldClassName.equals("java.lang.Long")) {
      long s = rs.getLong(fieldName);
      if (rs.wasNull()) {
        fieldValue.put(fieldName, null);
      } else {
        fieldValue.put(fieldName, s);
      }
    } else if (fieldClassName.equals("java.lang.Boolean")) {
      boolean s = rs.getBoolean(fieldName);
      if (rs.wasNull()) {
        fieldValue.put(fieldName, null);
      } else {
        fieldValue.put(fieldName, s);
      }
    } else if (fieldClassName.equals("java.lang.Short")) {
      short s = rs.getShort(fieldName);
      if (rs.wasNull()) {
        fieldValue.put(fieldName, null);
      } else {
        fieldValue.put(fieldName, s);
      }
    } else if (fieldClassName.equals("java.lang.Float")) {
      float s = rs.getFloat(fieldName);
      if (rs.wasNull()) {
        fieldValue.put(fieldName, null);
      } else {
        fieldValue.put(fieldName, s);
      }
    } else if (fieldClassName.equals("java.lang.Double")) {
      double s = rs.getDouble(fieldName);
      if (rs.wasNull()) {
        fieldValue.put(fieldName, null);
      } else {
        fieldValue.put(fieldName, s);
      }
    } else if (fieldClassName.equals("java.sql.Timestamp")) {
      java.sql.Timestamp s = rs.getTimestamp(fieldName);
      if (rs.wasNull()) {
        fieldValue.put(fieldName, null);
      } else {
        fieldValue.put(fieldName, s);
      }
    } else if (fieldClassName.equals("java.sql.Date") || fieldClassName
        .equals("java.util.Date")) {
      java.util.Date s = rs.getDate(fieldName);
      if (rs.wasNull()) {
        fieldValue.put(fieldName, null);
      } else {
        fieldValue.put(fieldName, s);
      }
    } else if (fieldClassName.equals("java.sql.Time")) {
      java.sql.Time s = rs.getTime(fieldName);
      if (rs.wasNull()) {
        fieldValue.put(fieldName, null);
      } else {
        fieldValue.put(fieldName, s);
      }
    } else if (fieldClassName.equals("java.lang.Byte")) {
      byte s = rs.getByte(fieldName);
      if (rs.wasNull()) {
        fieldValue.put(fieldName, null);
      } else {
        fieldValue.put(fieldName, new Byte(s));
      }
    } else if (fieldClassName.equals("[B") || fieldClassName.equals("byte[]")) {
      // byte[]出现在SQL Server中
      byte[] s = rs.getBytes(fieldName);
      if (rs.wasNull()) {
        fieldValue.put(fieldName, null);
      } else {
        fieldValue.put(fieldName, s);
      }
    } else if (fieldClassName.equals("java.math.BigDecimal")) {
      BigDecimal s = rs.getBigDecimal(fieldName);
      if (rs.wasNull()) {
        fieldValue.put(fieldName, null);
      } else {
        fieldValue.put(fieldName, s);
      }
    } else if (fieldClassName.equals("java.lang.Object") || fieldClassName
        .equals("oracle.sql.STRUCT")) {
      Object s = rs.getObject(fieldName);
      if (rs.wasNull()) {
        fieldValue.put(fieldName, null);
      } else {
        fieldValue.put(fieldName, s);
      }
    } else if (fieldClassName.equals("java.sql.Array") || fieldClassName
        .equals("oracle.sql.ARRAY")) {
      java.sql.Array s = rs.getArray(fieldName);
      if (rs.wasNull()) {
        fieldValue.put(fieldName, null);
      } else {
        fieldValue.put(fieldName, s);
      }
    } else if (fieldClassName.equals("java.sql.Clob")) {
      java.sql.Clob s = rs.getClob(fieldName);
      if (rs.wasNull()) {
        fieldValue.put(fieldName, null);
      } else {
        fieldValue.put(fieldName, s);
      }
    } else if (fieldClassName.equals("java.sql.Blob")) {
      java.sql.Blob s = rs.getBlob(fieldName);
      if (rs.wasNull()) {
        fieldValue.put(fieldName, null);
      } else {
        fieldValue.put(fieldName, s);
      }
    } else {// 对于其它任何未知类型的处理
      Object s = rs.getObject(fieldName);
      if (rs.wasNull()) {
        fieldValue.put(fieldName, null);
      } else {
        fieldValue.put(fieldName, s);
      }
    }
  }
}

package com.guoyasoft.gyautotest.tools;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * @program: guoya-test-demo
 * @description: ${description}
 * @author: YSL
 * @create: 2018-11-06 11:38
 **/
public class PropertiesTools {

  /**
   *
   * @param fileName，1.同文件夹，直接写文件名；2. 不同文件夹，写src/xxx/文件名
   * @return
   */
  public static Properties getProperties(String fileName) {
    try {
      InputStream in = new BufferedInputStream(new FileInputStream(fileName));
      Properties p = new Properties();
      p.load(in);
      return p;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }
}

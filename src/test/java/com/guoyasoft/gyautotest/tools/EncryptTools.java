package com.guoyasoft.gyautotest.tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * @program: guoya-virtual-mall
 * @description: ${description}
 * @author: YSL
 * @create: 2018-10-30 17:41
 **/
public class EncryptTools {

  public static String enMD5(String s) {
    MessageDigest md = null;
    try {
      md = MessageDigest.getInstance("MD5");
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    }
    // 计算md5函数
    md.update(s.getBytes());
    return new BigInteger(1, md.digest()).toString(16);
  }

  public static String enBase64(String s) throws UnsupportedEncodingException {
    Base64.Encoder encoder = Base64.getEncoder();
    byte[] textByte = s.getBytes("UTF-8");
    return encoder.encodeToString(textByte);
  }

  public static String deBase64(String s) throws UnsupportedEncodingException {
    Base64.Decoder decoder = Base64.getDecoder();

    return new String(decoder.decode(s), "UTF-8");
  }

  /**
   * <p>将文件转成base64 字符串</p>
   *
   * @param path 文件路径
   */
  public static String encodeBase64File(String path) throws Exception {
    File file = new File(path);
    FileInputStream inputFile = new FileInputStream(file);
    byte[] buffer = new byte[(int) file.length()];
    inputFile.read(buffer);
    inputFile.close();
    return new BASE64Encoder().encode(buffer);
  }

  /**
   * <p>将base64字符解码保存文件</p>
   */
  public static void decoderBase64File(String base64Code, String targetPath) throws Exception {
    byte[] buffer = new BASE64Decoder().decodeBuffer(base64Code);
    FileOutputStream out = new FileOutputStream(targetPath);
    out.write(buffer);
    out.close();
  }

  /**
   * <p>将base64字符保存文本文件</p>
   */
  public static void toFile(String base64Code, String targetPath) throws Exception {
    byte[] buffer = base64Code.getBytes();
    FileOutputStream out = new FileOutputStream(targetPath);
    out.write(buffer);
    out.close();
  }

  public static void main(String[] args) {
    try {
      String base64Code = encodeBase64File("c:\\JD_home.jpg");
      System.out.println(base64Code);
      decoderBase64File(base64Code, "c:\\JD_home_解密.jpg");
      toFile(base64Code, "c:\\JD_home_解密_2.txt");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

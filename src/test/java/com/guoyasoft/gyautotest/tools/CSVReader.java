package com.guoyasoft.gyautotest.tools;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;

/**
 * 需要添加依赖包
    <!-- 读取csv文件 -->
  		<dependency>
  			<groupId>net.sourceforge.javacsv</groupId>
  			<artifactId>javacsv</artifactId>
 			  <version>2.0</version>
 		  </dependency>
 */
public class CSVReader {
    /**
     * 1. 容器：
     *      1.1   固定大小：数组，先确定大小，再以下标存放数据，最后以下标取数据
     *      1.2 不固定大小：ArrayList，先add(数据)往里面添加数据（不能指定位置，因为是边加边扩，只能加到最后一个），get()以下标取数据
     *      1.2.4.3_69_71 不固定大小，且要按照标签存放，按照标签取数据：HashMap，先以put(“变量名”，数据)存数据，再以get("变量名")取数据
     *
     * 2. 循环
     *      2.1 for循环：for(变量类型 定义一个变量=初始值;最大值;增量)，知道最大循环次数的情况
     *      2.2 while循环：不知道要多少次，只知道一个结束的标识，循环到false为止
     *
     * 2.4.3_69_71. if(帅吗？){ok}else if(高吗){ok}else if(有钱吗？){ok}else{滚犊子！}
     *
     * 4. try{业务逻辑}catch(Exception e){异常处理逻辑}
     *      4.1 e.printStackTrace()：打印报错日志信息
     *      4.2 错误日志阅读方式：
     *              4.2.1 从上往下读，也就是找到日志报错开始的地方
     *              4.2.2 第一行是报错类型
     *              4.2.2.4.3_69_71 后面是具体位置，at在哪儿，然后从后往前读
     *              4.2.4 ()括号里面是哪个java文件的哪一行报错
     *              4.2.5 倒数第一个：方法名
     *              4.2.6 倒数第二个：类名
     *              4.2.7 倒数第三个：包名
     */
    public static Object[][] readCSV(String csvFilePath) {
        //try{业务代码}catch(Exception e){如果做业务的过程中出了错，的异常处理逻辑}
        try {
            //容器：对象少的时候，直接把对象列出来；当对象很多的时候，要用一个容器装起来打包
            ArrayList<String[]> csvFileList = new ArrayList<String[]>();
            // 这个不用背，只要看得懂会用就行。创建CSV读对象 例如:CsvReader(文件路径，分隔符，编码格式);
            CsvReader reader = new CsvReader(csvFilePath, ',', Charset.forName("GBK"));
            // 跳过表头 如果需要表头的话，这句可以忽略
            reader.readHeaders();
            // 逐行读入除表头的数据
            //boolean变量：真假true或者false
            while (reader.readRecord()) {
                System.out.println(reader.getRawRecord());
                //将一行的字符串按照“，”逗号分成多列，存放到String[]数组中
                //再将这个string[]放到list容器中存起来
                csvFileList.add(reader.getValues());
            }
            //数据取完了，关闭文件
            reader.close();



            // 遍历读取的CSV文件
            //for是一个整数次的循环，三个参数：最小值，最大值，增量，取个变量名存放每次循环的序列值

            Object[][] result=new Object[csvFileList.size()][csvFileList.get(0).length];
            for (int row = 0; row < csvFileList.size(); row++) {
            	result[row]=csvFileList.get(row);
            }

           return result;
        } catch (IOException e) {
            e.printStackTrace();
        }
		return null;
    }
    public static void writeCSV(String csvFilePath) {
        try {
            // 创建CSV写对象 例如:CsvWriter(文件路径，分隔符，编码格式);
            CsvWriter csvWriter = new CsvWriter(csvFilePath, ',', Charset.forName("UTF-8"));
            // 写表头
            String[] csvHeaders = { "编号", "姓名", "年龄" };
            csvWriter.writeRecord(csvHeaders);
            // 写内容
            for (int i = 0; i < 20; i++) {
                String[] csvContent = { i + "000000", "StemQ", "1" + i };
                csvWriter.writeRecord(csvContent);
            }
            csvWriter.close();
            System.out.println("--------CSV文件已经写入--------");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

            //JavaCSV.writeCSV(csvFilePath);
            CSVReader.readCSV("C:\\softwareData\\workspace\\guoya-test\\src\\main\\resources\\testNG\\searchData.csv");
    }
}

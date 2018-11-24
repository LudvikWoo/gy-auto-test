package com.guoyasoft.gyautotest.api.testCase.soap.tv;

import com.guoyasoft.gyautotest.api.soap.tv.getTVprogramDateSet.ArrayOfString;
import com.guoyasoft.gyautotest.api.soap.tv.getTVprogramDateSet.IpAddressSearchWebService;
import com.guoyasoft.gyautotest.api.soap.tv.getTVprogramDateSet.IpAddressSearchWebServiceSoap;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import org.testng.annotations.Test;

public class TVTest {
  private static final QName SERVICE_NAME = new QName("http://WebXml.com.cn/", "IpAddressSearchWebService");

  @Test
  public void testMethod(){
    URL wsdlURL = IpAddressSearchWebService.WSDL_LOCATION;

    IpAddressSearchWebService ss = new IpAddressSearchWebService(wsdlURL, SERVICE_NAME);
    IpAddressSearchWebServiceSoap port = ss.getIpAddressSearchWebServiceSoap12();

    {
      System.out.println("Invoking getCountryCityByIp...");
      String _getCountryCityByIp_theIpAddress = "192.168.60.139";
      ArrayOfString _getCountryCityByIp__return = port.getCountryCityByIp(_getCountryCityByIp_theIpAddress);
      System.out.println("getCountryCityByIp.result=" + _getCountryCityByIp__return);
      System.out.println( _getCountryCityByIp__return.getString().get(0));
      System.out.println( _getCountryCityByIp__return.getString().get(1));
    }

  }
}

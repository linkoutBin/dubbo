package com.testfork.dubbo.service;

import org.junit.Test;
import com.testfork.dubbo.service.export.ServiceExport;
import com.testfork.dubbo.service.provider.PrintServiceProvider;
import lombok.extern.slf4j.Slf4j;

/**
 * Author: xingshulin Date: 2019/2/26 上午11:07
 *
 *
 * Description: 服务发布测试类 Version: 1.0
 **/
@Slf4j
public class ServicePublish {

  @Test
  public void publish() {
    ServiceExport.publish(PrintService.class, new PrintServiceProvider(), 20880);
  }

  @Test
  public void publish1() {
    ServiceExport.publish(PrintService.class, new PrintServiceProvider(), 20881);
  }

}

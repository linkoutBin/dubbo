package com.testfork.dubbo.service.consumer;

import com.testfork.dubbo.service.PrintService;
import com.testfork.dubbo.service.reference.ServiceReference;
import lombok.extern.slf4j.Slf4j;

/**
 * Author: xingshulin Date: 2019/2/25 下午7:00
 *
 *
 * Description: TODO Version: 1.0
 **/
@Slf4j
public class ServiceConsumer {

  public static void main(String[] args) {
    ServiceReference serviceReference = new ServiceReference();
    log.info("调用服务2");
    Object o1 = serviceReference.get(PrintService.class);
    PrintService printService = (PrintService) o1;
    printService.print("this is print service");

    log.info("调用结束");
  }

}

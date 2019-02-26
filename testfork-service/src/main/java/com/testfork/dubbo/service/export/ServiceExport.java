package com.testfork.dubbo.service.export;

import java.util.ArrayList;
import java.util.List;
import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.ServiceConfig;
import lombok.extern.slf4j.Slf4j;

/**
 * Author: xingshulin Date: 2019/2/25 下午6:06
 *
 *
 * Description: 服务暴露处理类 Version: 1.0
 **/
@Slf4j
public class ServiceExport {

  private static final Object lock = new Object();

  private static List<String> list = new ArrayList<String>();

  public static <T> void publish(Class<T> clazz, Object o, int port) {

    ApplicationConfig applicationConfig = new ApplicationConfig();
    applicationConfig.setName("testfork-service");

    RegistryConfig registryConfig = new RegistryConfig();
    registryConfig.setProtocol("zookeeper");
    registryConfig.setAddress("localhost:2181");

    ProtocolConfig protocolConfig = new ProtocolConfig();
    protocolConfig.setName("dubbo");
    protocolConfig.setPort(port);
    protocolConfig.setThreads(20);

    ServiceConfig<T> service = new ServiceConfig<T>();
    service.setApplication(applicationConfig);
    service.setRegistry(registryConfig);
    service.setProtocol(protocolConfig);
    service.setInterface(clazz);
    service.setRef((T) o);
    service.setVersion("1.0.0");

    service.export();
    Runtime.getRuntime().addShutdownHook(new Thread() {
      @Override
      public void run() {
        log.info("Dubbo服务终止");
      }
    });
    synchronized (lock) {
      try {
        log.info("DUBBO服务发布成功");
        lock.wait();
      } catch (InterruptedException e) {
        log.error(e.getMessage(), e);
      }
    }
  }
}

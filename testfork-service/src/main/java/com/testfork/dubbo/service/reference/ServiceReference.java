package com.testfork.dubbo.service.reference;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;

/**
 * Author: xingshulin Date: 2019/2/25 下午7:01
 *
 *
 * Description: TODO Version: 1.0
 **/
public class ServiceReference {

  private static final ApplicationConfig applicationConfig = new ApplicationConfig();
  private static final RegistryConfig registryConfig = new RegistryConfig();

  static {
    applicationConfig.setName("service-consumer");
    registryConfig.setProtocol("zookeeper");
    registryConfig.setAddress("localhost:2181");
  }

  public static Object get(Class<?> clazz) {
    ReferenceConfig referenceConfig = new ReferenceConfig();
    referenceConfig.setApplication(applicationConfig);
    referenceConfig.setRegistry(registryConfig);
    referenceConfig.setRetries(2);
    referenceConfig.setInterface(clazz);
    referenceConfig.setVersion("1.0.0");
    return referenceConfig.get();
  }
}

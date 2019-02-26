package com.testfork.dubbo.service.provider;

import com.testfork.dubbo.service.SimpleService;

/**
 * Author: xingshulin Date: 2019/2/25 下午5:55
 *
 *
 * Description: 服务提供者 Version: 1.0
 **/
public class ServiceProvider implements SimpleService {

  public String printMessage(String message) {
    return String.format("简单服务接口消息：%s", message);
  }
}

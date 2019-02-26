package com.testfork.dubbo.service.provider;

import com.testfork.dubbo.service.PrintService;
import lombok.extern.slf4j.Slf4j;

/**
 * Author: xingshulin Date: 2019/2/26 上午11:59
 *
 *
 * Description: TODO Version: 1.0
 **/
@Slf4j
public class PrintServiceProvider implements PrintService {

  public void print(String content) {
    log.info("打印内容:{}", content);
  }
}

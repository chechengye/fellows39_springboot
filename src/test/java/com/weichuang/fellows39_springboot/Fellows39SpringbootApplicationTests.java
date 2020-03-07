package com.weichuang.fellows39_springboot;

import com.weichuang.fellows39_springboot.pojo.Person;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * SpringBoot  选用的是 slf4j - logback记录日志
 */
@SpringBootTest
class Fellows39SpringbootApplicationTests {
	Logger logger = LoggerFactory.getLogger(Fellows39SpringbootApplicationTests.class);
	@Autowired
	Person person;
	@Test
	void contextLoads() {
		System.out.println(person);
	}

	/**
	 * 日志级别 trace < debug < info < warn < error
	 * SpringBoot默认配置的日志级别是info
	 * 可以通过logging.level属性来修改级别，设定级别+ 高于它的级别会打印
	 */
	@Test
	void loggingFn(){
		logger.trace("这是trace日志");
		logger.debug("这是debug日志");
		logger.info("这是info日志");
		logger.warn("这是warn日志");
		logger.error("这是error日志");
	}

}

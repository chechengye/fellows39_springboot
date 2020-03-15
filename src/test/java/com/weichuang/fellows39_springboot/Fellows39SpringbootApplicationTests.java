package com.weichuang.fellows39_springboot;

import com.weichuang.fellows39_springboot.pojo.Book;
import com.weichuang.fellows39_springboot.pojo.Employee;
import com.weichuang.fellows39_springboot.pojo.Person;
import com.weichuang.fellows39_springboot.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * SpringBoot  选用的是 slf4j - logback记录日志
 */
@SpringBootTest
class Fellows39SpringbootApplicationTests {
	Logger logger = LoggerFactory.getLogger(Fellows39SpringbootApplicationTests.class);
	@Autowired
	Person person;

	//缓存相关对象获取
	@Autowired
	RedisTemplate redisTemplate;
	@Autowired
	StringRedisTemplate stringRedisTemplate;
	@Autowired
	RedisTemplate empRedisTemplate;
	@Autowired
	EmployeeService employeeService;

	@Autowired
	RabbitTemplate rabbitTemplate;
	@Autowired
	AmqpAdmin amqpAdmin;

	@Autowired
	DataSource dataSource;
	@Test
	void contextLoads() {
		System.out.println(person);
	}

	@Test
	void jdbcFn(){
		System.out.println("jdbcFn : " + dataSource.getClass());
		try {
			System.out.println("jdbcFn : " + dataSource.getConnection());
		} catch (SQLException e) {
			e.printStackTrace();
		}
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

	/**
	 * stringRedisTemplate.opsForValue() [String类型的操作]
	 * stringRedisTemplate.opsForList() [List类型操作]
	 * stringRedisTemplate.opsForHash() [hash类型操作]
	 * stringRedisTemplate.opsForSet() [set集合操作]
	 * stringRedisTemplate.opsForZSet() [zse有序集合操作]
	 */
	@Test
	void cacheTestFn(){
		//stringRedisTemplate.opsForValue().append("msg" , "hello");
		System.out.println(stringRedisTemplate.opsForValue().get("msg"));
		//stringRedisTemplate.opsForList().leftPush("mylist" , "10");
		//stringRedisTemplate.opsForList().leftPush("mylist" , "20");
		//stringRedisTemplate.opsForHash()
		//stringRedisTemplate.opsForSet().
	}
	@Test
	void cacheTestFn2(){
		Employee employee = employeeService.getEmployeeById(5);
		//默认保存的对象，使用的jdk序列化机制，序列化后的数据保存到redis中
		//1、自己将对象转换成为json格式:不推荐
		//2、redisTemplate修改它的默认的序列化规则 : 推荐
		//redisTemplate.opsForValue().set("emp-05" , employee);
		empRedisTemplate.opsForValue().set("emp-05" , employee);
	}

	@Test
	void rabbitMqTestFn(){
		Map<String , Object> map = new HashMap<>();
		map.put("msg","这是第一个消息");
		map.put("data", Arrays.asList("hello" , 1234 , false));
		//对象被Jdk默认序列化之后发送
		//rabbitTemplate.convertAndSend("exchange.direct" , "qingmeng.news" , map);
		rabbitTemplate.convertAndSend("exchange.topic" , "*.news" , new Book("三国演义","罗贯中"));

		//Message message = new Message();
		//send方法直接发送消息对象的，不推荐

	}
	@Test
	void receiveFn(){
		Object o = rabbitTemplate.receiveAndConvert("qingmeng.news");
		//System.out.println(o.getClass());
		System.out.println(rabbitTemplate.receiveAndConvert("qingmeng.news"));
	}
	@Test
	void amqpAdminFn(){
		//amqpAdmin.declareExchange(new DirectExchange("amqpadmin.direct"));
		//amqpAdmin.declareQueue(new Queue("amqpadmin.queue" , true));
		amqpAdmin.declareBinding(new Binding("amqpadmin.queue" , Binding.DestinationType.QUEUE,"amqpadmin.direct" , "amqpadmin.queue" , null));
	}
}

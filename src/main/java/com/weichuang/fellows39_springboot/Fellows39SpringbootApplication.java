package com.weichuang.fellows39_springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

//注解： 来标识/标注 一个主程序类，说明它是一个SpringBoot应用
/**
 * @SpringBootConfiguration ： SpringBoot配置类 @Configuration 是Spring内部的注解，标识一个类为配置类--对应的就是配置文件@Component 组件
 * @EnableAutoConfiguration : 开启自动配置功能；以前我们手动配置的东西，SpringBoot帮我们自动配置。
 * 		@AutoConfigurationPackage：
 * 			@Import(AutoConfigurationPackages.Registrar.class) ： 自动配置包,他会扫描添加了@SpringBootApplication的类的所在目录下面的子目录
 *		@Import(AutoConfigurationImportSelector.class) ： 给容器中导入组件。将你所需组件的的全类名的方式返回；这些组件就会添加到容器中；会给容器中导入非常多的
 *				XXXAutoConfiguration;就相当于导入了场景需要所有的组件。并配置好。
 *			        META-INF/spring.factories文件夹下面寻找对应的类
 *	J2EE的整体整合解决方案或自动配置都在spring-boot-autoconfigure-2.2.5.jar
 *
 *
 *
 * Redis相关：
 * Redis 是一个开源（BSD许可）的，内存中的数据结构存储系统，它可以用作数据库、缓存和消息中间件。
 * 面试题：问到redis，几乎必问 它支持五种数据类型： 数据结构为： key - value
 * string 字符串（strings）， hash散列（hashes）， list列表（lists）， set集合（sets）， zset有序集合（sorted sets）
 *
 * RabbitMQ相关
 *
 * docker run -d -p 5672:5672 -p 15672:15672 --name rabbitmq_01 99cbda713eff
 * 访问：ip : 5672 输入用户名与密码 : guest
 *
 * direct : 单播式的，点对点式。会默认匹配到一个对应的队列
 * fanout ； 广播式的，发送消息到所有绑定的队列
 * topic : 订阅式的交换器，匹配一定的路由键规则
 *
 *  @RabbitListener + @EnableRabbit配合使用
 *  AmqpAdmin ： 创建交换器、队列、绑定规则
 *
 */
@SpringBootApplication
//用mapper扫描注解，替换mapper接口中的所有@Mapper
@MapperScan("com.weichuang.fellows39_springboot.mapper")
//开启基于注解的缓存
@EnableCaching
@EnableRabbit
public class Fellows39SpringbootApplication {

	public static void main(String[] args) {
		//SpringBoot启动的主函数，它必须依赖于@SpringBootApplication
		SpringApplication.run(Fellows39SpringbootApplication.class, args);
	}

}

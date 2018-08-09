package com.example.apigateway;

import com.example.apigateway.filter.AccessFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 * 1. 系统的统一入口，屏蔽了系统内部各个微服务的细节
 * 2. 与服务治理框架结合，实现自动化的服务实例维护以及负载均衡的路由转发
 * 3. 可以实现接口权限校验与为服务业务逻辑的解耦
 * 4. 通过服务网关中的过滤器，在各生命周期中去校验请求的内容，
 * 	将原本在对外服务层做的校验迁移，保证了微服务的无状态性，
 * 	同时降低了微服务的测试难度，让服务本身更计中关注业务逻辑的处理
 *
 */
@EnableZuulProxy
@SpringBootApplication
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
//		new SpringApplicationBuilder(ApiGatewayApplication.class).web(true).run(args);
	}

	@Bean
	public AccessFilter accessFilter(){
		return new AccessFilter();
	}
}

package com.javacents.socialsignin;

import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.javacents.socialsignin.controller.interceptor.SessionInterceptor;

@Configuration
@EnableWebMvc
@ComponentScan("com.javacents.socialsignin.controller")
public class WebMvcConfig extends WebMvcAutoConfiguration {

	@Bean
	public WebMvcConfigurerAdapter adapter() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addInterceptors(InterceptorRegistry registry) {
				SessionInterceptor interceptor = new SessionInterceptor();
				registry.addInterceptor(interceptor).excludePathPatterns("/", "/account/login", "/account/logout", "/signin/facebook",
						"/error");
			}
		};
	}
}
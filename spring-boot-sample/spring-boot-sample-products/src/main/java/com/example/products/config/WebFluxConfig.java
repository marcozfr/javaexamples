package com.example.products.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import org.springframework.web.reactive.function.server.RouterFunction;

import com.example.products.model.Product;

//@EnableWebFlux
@Configuration
public class WebFluxConfig {

//	@Bean
//	public RouterFunction<Product> route(GreetingHandler greetingHandler) {
//
//		return RouterFunctions.route(
//				RequestPredicates.GET("/hello").and(RequestPredicates.accept(MediaType.TEXT_PLAIN)),
//				greetingHandler::hello);
//	}

}

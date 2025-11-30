package com.go5u.foodflowplatform.apigateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
public class CorsGlobalConfiguration {

        @Bean
        public CorsWebFilter corsWebFilter() {
                CorsConfiguration corsConfig = new CorsConfiguration();

                // Use allowedOriginPatterns to support wildcards with credentials
                corsConfig.setAllowedOriginPatterns(Arrays.asList(
                                "https://stfoodflowfront2024.z13.web.core.windows.net",
                                "http://localhost:4200",
                                "http://localhost:*",
                                "http://127.0.0.1:*",
                                "https://*.azurewebsites.net",
                                "https://*.web.core.windows.net"));

                // Allow all HTTP methods
                corsConfig.setAllowedMethods(Arrays.asList(
                                "GET", "POST", "PUT", "DELETE", "OPTIONS", "PATCH", "HEAD"));

                // Allow all headers
                corsConfig.addAllowedHeader("*");

                // Allow credentials
                corsConfig.setAllowCredentials(true);

                // Cache preflight response for 1 hour
                corsConfig.setMaxAge(3600L);

                // Expose headers
                corsConfig.setExposedHeaders(Arrays.asList(
                                "Authorization",
                                "Content-Type",
                                "X-Requested-With",
                                "Accept",
                                "Origin",
                                "Access-Control-Request-Method",
                                "Access-Control-Request-Headers"));

                UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
                source.registerCorsConfiguration("/**", corsConfig);

                return new CorsWebFilter(source);
        }
}

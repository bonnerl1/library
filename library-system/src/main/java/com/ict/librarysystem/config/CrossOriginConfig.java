package com.ict.librarysystem.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author: Lizbeth9421
 * @Date: 2021/12/18/21:30
 */
@Configuration
public class CrossOriginConfig implements WebMvcConfigurer {

    /**
     * 重新接口default方法解决跨越问题
     *
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 设置允许跨域的路径
        registry.addMapping("/**")
                // 设置允许跨域请求的域名
                .allowedOriginPatterns("*")
                // 是否允许证书
                .allowCredentials(true)
                // 设置允许HTTP协议的8种请求类型，此处列举了6种
                .allowedMethods("GET", "POST", "DELETE", "PUT", "HEAD", "OPTIONS")
                // 设置允许的header属性
                .allowedHeaders("*")
                // 跨域允许时间
                .maxAge(3600);
    }
}


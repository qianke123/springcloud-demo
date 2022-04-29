package com.example.springclouddemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
//开启swagger2,若启动类上添加了该注解，则配置类可以不添加
@EnableSwagger2
public class SwaggerConfig implements WebMvcConfigurer {

    // 创建swagger bean
    @Bean
    public Docket docket() {
        // Docket是swagger全局配置对象
        // DocumentationType：指定文档类型为swagger2
        return new Docket(DocumentationType.SWAGGER_2)
                // swagger信息
                .apiInfo(apiInfo());
    }

    // swagger文档信息
    public ApiInfo apiInfo() {
        // 作者信息
        Contact contact = new Contact(
                // 文档发布者的名称
                "iqiuq",
                // 文档发布者的网站地址
                "https://iqiuq.gitee.io/qiuqblogs/",
                // 文档发布者的电子邮箱
                "qiuyonghui258@163.com"
        );
        return new ApiInfo(
                // 标题
                "swagger api",
                // 文档描述
                "演好自己人生的剧本",
                // 版本号
                "1.0",
                // 服务组url地址
                "urn:tos",
                // 作者信息
                contact,
                // 开源组织
                "Apache 2.0",
                // 开源地址
                "http://www.apache.org/licenses/LICENSE-2.0",
                // 集合
                new ArrayList()
        );
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/statics/**").addResourceLocations("classpath:/statics/");
        // 解决 SWAGGER 404报错
        registry.addResourceHandler("/swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}


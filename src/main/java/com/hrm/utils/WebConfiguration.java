/*
package com.hrm.utils;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.charset.StandardCharsets;
import java.util.List;

*/
/**
 * @Author: Cai 🥬
 * @Date: 2022-12-25 13:09
 * @Version: 1.0
 *//*

@Configurable
public class WebConfiguration implements WebMvcConfigurer {
    
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        // 解决 controller 返回字符串中文乱码问题
        System.out.println("解决 controller 返回字符串中文乱码问题");
        for (HttpMessageConverter<?> converter : converters) {
            if (converter instanceof StringHttpMessageConverter) {
                System.out.println("setDefaultCharset");
                ((StringHttpMessageConverter)converter).setDefaultCharset(StandardCharsets.UTF_8);
            }
        }
    }
}
*/

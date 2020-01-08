//package com.littlepage.airplaneticketsystem.intercepter;
//
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.util.ResourceUtils;
//import org.springframework.web.servlet.config.annotation.*;
//
//@Configuration
//public class WebConfig implements WebMvcConfigurer {
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new LoginInterceptor()).
//                addPathPatterns("/**").
//                excludePathPatterns("/index.html","/_fragments.html",
//                        "/","/admin/login","/admin/register",
//                        "/admin/register/valiRegister",
//                        "/admin/login/valiLogin",
//                        "/css/**","/img/**","/js/**");
//    }
//}
//

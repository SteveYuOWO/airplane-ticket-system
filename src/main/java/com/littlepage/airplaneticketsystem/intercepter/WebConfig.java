//package com.littlepage.airplaneticketsystem.intercepter;
//
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.*;
//
///**
// * Config the web mvc interceptor
// */
//@Configuration
//public class WebConfig implements WebMvcConfigurer {
//    /**
//     * add the LoginInterceptor and add Patterns "/**" as
//     * the pattern we want to intercept
//     *
//     *
//     *
//     * the exclude path patterns is that we doesn't want to
//     * intercept
//     * @param registry
//     */
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

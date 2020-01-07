package com.littlepage.airplaneticketsystem.controller;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * This is the Test Controller, in
 *  develop situation , for different part of
 *    solution of wrong page.
 *
 *
 *
 *
 *
 *
 *    404        NOTFOUND
 *    500        SERVER EXCEPTION
 *    error      ERROR EXPR FROM PROGRAM
 */
//@Controller
@RequestMapping("test")
public class TestError {

    /**
     *
     * if we visit a NOTFOUND page,
     *      servlet will redirect to 404 page
     *
     *
     *
     *
     * Another situation, when the server can not analyse
     *      the page, servlet will redirect to 500 page
     *
     *
     *
     *
     *
     *
     * while have some problem like mathmatic problem,
     *  we will throw the exception and skip to another page
     */
    @RequestMapping("error")
    public String Hello(){
        int math=1/0;
        return "index";
    }

}

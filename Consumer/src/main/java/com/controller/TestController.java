package com.controller;

import com.service.TestService;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.rpc.RpcContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Reference(version = "1.0.0")
    private TestService testServiceImpl;

    @RequestMapping("/insert")
    public String insert() {
        testServiceImpl.insert();
        return "insert";
    }

    @RequestMapping("/delete")
    public String delete() {
        testServiceImpl.delete();
        return "delete";
    }

    @RequestMapping("/update")
    public String update() {
        testServiceImpl.update();
        return "update";
    }

    @RequestMapping("/select")
    public String select() {
        testServiceImpl.select();
        return "select";
    }

}

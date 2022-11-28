package com.service;
import org.apache.dubbo.config.annotation.Service;

@Service(version = "1.0.0", interfaceClass = TestService.class)
public class TestServiceImpl implements TestService {
    @Override
    public void insert() {
        System.out.print("insert");
    }

    @Override
    public void delete() {
        System.out.println("delete");
    }

    @Override
    public void update() {
        System.out.println("update");
    }

    @Override
    public void select() {
        System.out.println("select");
    }
}

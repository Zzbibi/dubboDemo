package com.service;

/**
 * @Author zhangzhen
 * @create 2022/12/17 15:48
 */
public class TestServiceImpl implements TestService {
    @Override
    public void insert() {
        System.out.println("Insert...");
    }

    @Override
    public void delete() {
        System.out.println("delete...");
    }

    @Override
    public void update() {
        System.out.println("update...");
    }

    @Override
    public void select() {
        System.out.println("select...");
    }
}

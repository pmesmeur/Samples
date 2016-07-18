package com.bw.osgi.provider.impl;

import com.bw.osgi.provider.able.HelloWorldService;

public class HelloWorldServiceImpl implements HelloWorldService {
    @Override
    public void hello(){
        System.out.println("Hello World !");
    }
}
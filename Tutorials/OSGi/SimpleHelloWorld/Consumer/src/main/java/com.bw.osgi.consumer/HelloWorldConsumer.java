package com.bw.osgi.consumer;

import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.bw.osgi.provider.able.HelloWorldService;

public class HelloWorldConsumer implements ActionListener {
    private final HelloWorldService service;
    private final Timer timer;

    public HelloWorldConsumer(HelloWorldService service) {
        super();

        this.service = service;

        timer = new Timer(1000, this);
    }

    public void startTimer(){
        timer.start();
    }

    public void stopTimer() {
        timer.stop();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        service.hello();
    }
}
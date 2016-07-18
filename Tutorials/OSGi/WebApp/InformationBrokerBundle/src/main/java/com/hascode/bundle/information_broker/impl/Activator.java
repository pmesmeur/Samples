package com.hascode.bundle.information_broker.impl;

import java.util.Properties;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import com.hascode.bundle.information_broker.api.InformationBroker;

public class Activator implements BundleActivator {
    public void start(BundleContext ctx) throws Exception {
        ctx.registerService(InformationBroker.class.getName(),
                new InformationBrokerImpl(), new Properties());
    }

    public void stop(BundleContext ctx) throws Exception {
    }
}

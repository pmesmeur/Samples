package com.hascode.bundle.information_broker_servlet.impl;

import javax.servlet.ServletException;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.http.HttpService;
import org.osgi.service.http.NamespaceException;
import org.osgi.util.tracker.ServiceTracker;

import com.hascode.bundle.information_broker.api.InformationBroker;

public class Activator implements BundleActivator {
    private ServiceTracker infoSrvTracker;

    private ServiceTracker httpSrvTracker;

    public void start(BundleContext ctx) throws Exception {
        infoSrvTracker = new ServiceTracker(
                ctx,
                InformationBroker.class.getName(),
                null);
        httpSrvTracker = new ServiceTracker(ctx, HttpService.class.getName(),
                null) {
            public Object addingService(ServiceReference reference) {
                HttpService httpService = (HttpService) super.addingService(reference);
                try {
                    httpService.registerServlet(
                            "/",
                            new InfoBrokerServlet(
                                    infoSrvTracker),
                            null, null);
                } catch (ServletException e) {
                } catch (NamespaceException e) {
                }
                return httpService;
            }

            public void removedService(ServiceReference reference,
                                       Object service) {
                ((HttpService) service).unregister("/");
                super.removedService(reference, service);
            }
        };

        infoSrvTracker.open();
        httpSrvTracker.open();
    }

    public void stop(BundleContext ctx) throws Exception {
        infoSrvTracker.close();
        httpSrvTracker.close();
    }
}

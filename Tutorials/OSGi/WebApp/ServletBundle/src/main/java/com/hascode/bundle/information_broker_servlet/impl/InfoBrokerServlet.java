package com.hascode.bundle.information_broker_servlet.impl;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.util.tracker.ServiceTracker;
import com.hascode.bundle.information_broker.api.InformationBroker;

public class InfoBrokerServlet extends HttpServlet {
    private static final long serialVersionUID = 1110490906466282279L;
    private ServiceTracker serviceTracker;

    public InfoBrokerServlet(ServiceTracker serviceTracker) {
        this.serviceTracker = serviceTracker;
    }
    protected void doGet(HttpServletRequest req, HttpServletResponse res) {
        try {
            res.getOutputStream().println("<html><body>");
            InformationBroker broker = (InformationBroker) serviceTracker.getService();
            if (broker != null) {
                res.getOutputStream().println(broker.getInformation());
            }
            res.getOutputStream().println("</body></html>");
        } catch (IOException e) {
        }
    }
}
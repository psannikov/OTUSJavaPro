package ru.otus.pro.psannikov.jetty;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import ru.otus.pro.psannikov.jetty.handlers.HelloWorldServlet;
import ru.otus.pro.psannikov.jetty.handlers.auth.TokenServlet;
import ru.otus.pro.psannikov.jetty.handlers.data.Multiply;


public class Main {
    public static void main(String[] args) throws Exception {
        Server server = new Server(9090);
        ServletContextHandler context = new ServletContextHandler(server, "/");
        context.addServlet(HelloWorldServlet.class, "/hello");
        context.addServlet(Multiply.class, "/mutiply");
        context.addServlet(TokenServlet.class, "/auth");
        server.start();
    }
}
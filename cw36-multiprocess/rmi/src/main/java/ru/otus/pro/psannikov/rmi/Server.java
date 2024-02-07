package ru.otus.pro.psannikov.rmi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {
    public static void main(String[] args) {
        try {
            System.getProperties().put("java.rmi.server.hostname", "localhost");

            Calculator obj = new CalculatorImpl();
            Calculator stub = (Calculator) UnicastRemoteObject.exportObject(obj, 0);

            // Bind the remote object's stub in the registry
            Registry registry = LocateRegistry.createRegistry(1234);
            registry.bind("Calculator", stub);

            System.err.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }

    static class CalculatorImpl implements Calculator {
        @Override
        public int sum(int op1, int op2) {
            return op1 + op2;
        }
    }
}

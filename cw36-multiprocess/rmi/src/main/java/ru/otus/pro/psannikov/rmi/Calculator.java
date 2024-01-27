package ru.otus.pro.psannikov.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Calculator extends Remote {
    int sum(int op1, int op2) throws RemoteException;
}

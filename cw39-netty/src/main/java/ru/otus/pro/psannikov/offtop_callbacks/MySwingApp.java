package ru.otus.pro.psannikov.offtop_callbacks;

import javax.swing.*;
import java.awt.*;

public class MySwingApp extends JFrame {
    public MySwingApp() throws HeadlessException {
        setTitle("A");
        setBounds(500,400,400,400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JButton btn = new JButton("SEND");
        btn.addActionListener((e) -> {
            MyNet.fileReceived((p) -> {
                JOptionPane.showConfirmDialog(null, "Был получен файл: " + p.getFileName().toString());
            });
        });
        add(btn);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MySwingApp();
    }
}

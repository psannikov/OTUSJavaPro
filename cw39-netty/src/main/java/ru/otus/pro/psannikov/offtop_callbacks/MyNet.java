package ru.otus.pro.psannikov.offtop_callbacks;

import java.nio.file.Path;
import java.nio.file.Paths;

public class MyNet {
    public static void sendMsg(Callback finishCallback) {
        // файл отправлен
        finishCallback.callback();
    }

    public static void fileReceived(FileReceiverCallback fileReceivedCallback) {
        // ...
        Path path = Paths.get("1.txt");
        fileReceivedCallback.callback(path);
    }
}

package ru.otus.pro.psannikov.offtop_callbacks;

import java.nio.file.Path;

public interface FileReceiverCallback {
    void callback(Path path);
}

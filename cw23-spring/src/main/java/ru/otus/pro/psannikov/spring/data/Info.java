package ru.otus.pro.psannikov.spring.data;

public class Info {
    private final String serverName;
    private final String version;

    public Info(final String serverName, final String version) {
        this.serverName = serverName;
        this.version = version;
    }

    public String getServerName() {
        return serverName;
    }

    public String getVersion() {
        return version;
    }
}

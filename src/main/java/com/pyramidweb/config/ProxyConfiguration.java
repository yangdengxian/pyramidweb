package com.pyramidweb.config;

import org.springframework.beans.factory.annotation.Value;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;

public class ProxyConfiguration {
    private static String proxyHost="";

    private static String proxyPort="8080";

    public static Proxy getProxy() {
        SocketAddress addr = new InetSocketAddress(proxyHost, Integer.parseInt(proxyPort));
        return new Proxy(Proxy.Type.HTTP, addr);
    }
}

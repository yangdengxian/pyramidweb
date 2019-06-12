package com.pyramidweb.config;

import org.springframework.beans.factory.annotation.Value;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
/**
 * 网络代理配置
 * @author ydx
 * @date 2019-06-05
 * @version 1.0.0
 */
public class ProxyConfiguration {
    private static String proxyHost="";

    private static String proxyPort="8080";

    public static Proxy getProxy() {
        SocketAddress addr = new InetSocketAddress(proxyHost, Integer.parseInt(proxyPort));
        return new Proxy(Proxy.Type.HTTP, addr);
    }
}

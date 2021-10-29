package dev.getgo.teletegrambot.bot.util;

import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.telegram.telegrambots.bots.DefaultBotOptions;

public class HttpProxyConfiger {
    public static DefaultBotOptions configProxy() {
        DefaultBotOptions defaultBotOptions = new DefaultBotOptions();
        defaultBotOptions.setProxyPort(10809);
        defaultBotOptions.setProxyHost("127.0.0.1");
        defaultBotOptions.setProxyType(DefaultBotOptions.ProxyType.HTTP);

//        RequestConfig.Builder builder = RequestConfig.copy(RequestConfig.custom().build());
//
//        HttpHost httpHost = new HttpHost("127.0.0.1", 10809, "http");
//        RequestConfig requestConfig = builder
//                .setSocketTimeout(75000)
//                .setConnectTimeout(75000)
//                .setConnectionRequestTimeout(75000)
//                .setProxy(httpHost)
//                .build();
//        defaultBotOptions.setRequestConfig(requestConfig);
        return defaultBotOptions;
    }
}
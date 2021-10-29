package dev.getgo.teletegrambot.bot.util;

import org.telegram.telegrambots.bots.DefaultBotOptions;

public class HttpProxyConfiger {
    public static DefaultBotOptions configProxy() {
        DefaultBotOptions defaultBotOptions = new DefaultBotOptions();
        defaultBotOptions.setProxyPort(10809);
        defaultBotOptions.setProxyHost("127.0.0.1");
        defaultBotOptions.setProxyType(DefaultBotOptions.ProxyType.HTTP);
        return defaultBotOptions;
    }
}
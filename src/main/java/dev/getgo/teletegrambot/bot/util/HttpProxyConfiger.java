package dev.getgo.teletegrambot.bot.util;
import java.util.Properties;
 
public class HttpProxyConfiger {
    public static void configProxy(){
        Properties prop=System.getProperties();
 
        prop.setProperty("proxySet","true");
        prop.setProperty("http.proxyHost","192.168.xx.xx");
        prop.setProperty("http.proxyPort","port");
 
    }
}
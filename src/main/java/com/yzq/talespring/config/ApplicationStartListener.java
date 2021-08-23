package com.yzq.talespring.config;

import lombok.Data;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.ApplicationListener;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author yanni
 */
@Data
public class ApplicationStartListener implements ApplicationListener<WebServerInitializedEvent> {


    public int serverPort;

    @Override
    public void onApplicationEvent(WebServerInitializedEvent event) {
        int port = event.getApplicationContext().getWebServer().getPort();
        InetAddress address = null;
        try {
            address = InetAddress.getLocalHost();
            System.out.println("network: http://" + address.getHostAddress() + ":" + port + "/swagger-ui/");
            System.out.println("network: http://" + address.getHostAddress() + ":" + port);
            System.out.println("local: http://localhost:"+port);
            System.out.println("local: http://localhost:"+port+"/swagger-ui/");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }


}



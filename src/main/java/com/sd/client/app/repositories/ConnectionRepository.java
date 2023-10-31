package com.sd.client.app.repositories;

import com.sd.client.app.App;

public class ConnectionRepository  {
    public ConnectionRepository() {
    }

    public static void connect(String ip_value,String port_value){
        if(ip_value.isEmpty() && port_value.isEmpty()){
            AppRepository.setApp(new App("127.0.0.1",8080));
        }else{
            AppRepository.setApp(new App(ip_value,Integer.valueOf(port_value)));
        }
    }
}

package com.example.clientsd.app;

import com.example.clientsd.app.packages.BasePackage;
import com.example.clientsd.app.runnables.ConnectionRunnable;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class App {
   private final static BlockingQueue<String> queue = new LinkedBlockingQueue<>();

    public static void connect(String ip,Integer port) {
            ConnectionRunnable connection_runnable = new ConnectionRunnable(queue,ip,port);
            Thread connection_thread = new Thread(connection_runnable);
            connection_thread.start();
    }

    public static void sendPackage(BasePackage message) throws InterruptedException {
        String json = message.toString();
        queue.put(json);
    }

    public static void die(){
        try {
            queue.put("die");
        } catch (InterruptedException e) {
            System.exit(1);
        }
    }
}

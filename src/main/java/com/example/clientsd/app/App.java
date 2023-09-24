package com.example.clientsd.app;

import com.example.clientsd.app.packages.BasePackage;
import com.example.clientsd.app.runnables.ConnectionRunnable;

import java.io.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class App {
   private static BlockingQueue<String> queue = new LinkedBlockingQueue<>();

    public static void connect(String ip,Integer port) throws IOException {
        ConnectionRunnable connection_runnable = new ConnectionRunnable(queue,ip,port);
        Thread connection_thread = new Thread(connection_runnable);
        connection_thread.start();
    }

    public static void sendPackage(BasePackage message) throws InterruptedException {
        String json = message.toString();
         queue.put(json);
    }
}

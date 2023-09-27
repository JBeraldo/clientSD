package com.example.clientsd.app.runnables;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;

public class ConnectionRunnable implements Runnable {
    private final String ip;
    private final int port;
    private final BlockingQueue<String> queue;

    public ConnectionRunnable(BlockingQueue<String> queue ,String ip, int port) {
        this.queue = queue;
        this.ip = ip;
        this.port = port;
    }

    @Override
    public void run() {
        Socket socket;
        PrintWriter out;
        BufferedReader in;

        try {
            socket = new Socket(this.ip,this.port);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            while (true) {
                String message = queue.take();
                if (Objects.equals(message, "die")) {
                    break;
                }


                System.out.println("Enviado: "+message);
                out.println(message);

                // end loop


                System.out.println("echo: " + in.readLine());
            }

            out.close();
            in.close();
            socket.close();

        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: " + ip);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for "
                    + "the connection to: " + ip);
            System.exit(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}

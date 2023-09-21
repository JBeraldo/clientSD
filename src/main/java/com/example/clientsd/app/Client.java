package com.example.clientsd.app;

import java.io.*;
import java.net.*;

public class Client{
    public static void connect(String ip,String port) throws IOException {
        Socket echoSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;

        try {
            echoSocket = new Socket(ip, Integer.parseInt(port));
            out = new PrintWriter(echoSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(
                    echoSocket.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: " + ip);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for "
                    + "the connection to: " + ip);
            System.exit(1);
        }

        BufferedReader stdIn = new BufferedReader(
                new InputStreamReader(System.in));
        String userInput;

        System.out.println ("Type Message (\"Bye.\" to quit)");
        while ((userInput = stdIn.readLine()) != null)
        {
            out.println(userInput);

            // end loop
            if (userInput.equals("Bye."))
                break;

            System.out.println("echo: " + in.readLine());
        }

        out.close();
        in.close();
        stdIn.close();
        echoSocket.close();
    }
}

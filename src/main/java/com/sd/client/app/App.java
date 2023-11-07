package com.sd.client.app;


import com.sd.client.app.exceptions.ResponseErrorException;
import com.sd.client.app.packages.SimpleResponse;
import com.sd.client.view.validators.ValidationResponse;
import com.sd.client.view.validators.Validator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class App {

    public Socket socket;
    public PrintWriter out;
    public  BufferedReader in;

    public App(String ip, Integer port) {
        connect(ip,port);
    }

    public App() {
    }

    public void connect(String ip, Integer port) {
        try {
            socket = new Socket(ip, port);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public String read() throws IOException, ResponseErrorException {
        String raw_response =  getIn().readLine();
        if(raw_response != null){
            SimpleResponse simpleResponse = SimpleResponse.fromJson(raw_response, SimpleResponse.class);
            if (simpleResponse.isError()){
                Validator.responseErrors(simpleResponse);
                throw new ResponseErrorException();
            }
            else{
                Validator.successAlert(new ValidationResponse(simpleResponse.getMessage()));
            }
            return raw_response;
        }
        throw new ResponseErrorException();
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public PrintWriter getOut() {
        return out;
    }

    public void setOut(PrintWriter out) {
        this.out = out;
    }

    public BufferedReader getIn() {
        return in;
    }

    public void setIn(BufferedReader in) {
        this.in = in;
    }
}

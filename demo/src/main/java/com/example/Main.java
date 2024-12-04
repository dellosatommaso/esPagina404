package com.example;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException{
        ServerSocket ss = new ServerSocket(3000);
        int i = 0;
        do{
            Socket s0 = ss.accept();
            i++;
            System.out.println("Connessione numero " + i);
            MioThread t1 = new MioThread(s0);
            t1.start();
        }while(true);
    }
        
}
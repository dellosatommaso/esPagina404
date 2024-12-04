package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class MioThread extends Thread{
    
    Socket s0;

    public MioThread(Socket s0){
        this.s0 = s0;
    }
    
    @Override
    public void run(){
        try{
            BufferedReader in = new BufferedReader(new InputStreamReader(s0.getInputStream()));
            DataOutputStream out = new DataOutputStream(s0.getOutputStream());

            do{
                String s1 = in.readLine();
                System.out.println(s1);

                if(s1.equals(null)){
                    break;
                }

                String[] x = s1.split(" ");
                String metodo = x[0];

                if(metodo == "GET"){
                    String responseBody = "<html><body> <p>Errore</p> <b>Pagina non trovata</b> </body></html>";
                    out.writeBytes("HTTP/1.1 404 Not found\r\n");
                    out.writeBytes("Content-Lenght: " + responseBody.length() + "\r\n");
                    out.writeBytes("Content-Type: text/html\r\n");
                    out.writeBytes("\r\n");
                    break;
                }
            }while(true);    

        } catch(Exception e){
            e.printStackTrace();
        }
    }
}

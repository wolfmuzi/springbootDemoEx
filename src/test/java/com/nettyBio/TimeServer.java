package com.nettyBio;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author: lj
 * @description:
 * @date: 16:29 2018/1/9
 */
public class TimeServer {
    public static void main (String[] args) throws IOException{
        int port = 8080;
        if (args != null && args.length > 0){
            try {
                port = Integer.valueOf(args[0]);
            }catch (NumberFormatException e){
            }
        }
        ServerSocket server = null;
        try {
            server = new ServerSocket(port);
            System.out.println("the time server is start in port" + port);
            Socket socket = null;
            while (true){
                socket = server.accept();
                new Thread(new TimeServerHandler(socket)).start();
            }
        }finally{
            if(server != null){
                System.out.println("the time server close");
                server.close();
                server = null;
            }
        }
    }
}

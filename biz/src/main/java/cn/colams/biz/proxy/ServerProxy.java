package cn.colams.biz.proxy;

import java.net.ServerSocket;
import java.net.Socket;


public class ServerProxy {
    public static void main(String args[]) throws Exception {
        ServerSocket server = new ServerSocket(8888);
        while (true) {
            Socket socket = server.accept();
            ActionSocket ap = new ActionSocket(socket);
            ap.start();
        }
    }
}



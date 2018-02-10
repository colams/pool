package cn.colams.biz.proxy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class ActionSocket extends Thread {


    private Socket socket = null;

    public ActionSocket(Socket s) {
        this.socket = s;
    }

    @Override
    public void run() {
        try {
            this.action();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void action() throws Exception {
        if (this.socket == null) {
            return;
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
        for (String temp = br.readLine(); temp != null; temp = br.readLine()) {
            System.out.println(temp);
        }
        br.close();
    }
}

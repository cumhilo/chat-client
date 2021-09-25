package me.cxmilo.chat.client;

import me.cxmilo.chat.client.chat.thread.ShutdownThread;
import me.cxmilo.chat.client.service.Service;
import me.cxmilo.chat.client.service.impl.ClientConnectService;

import java.util.Scanner;

public class ChatController {

    private static Service conn;

    public static void main(String[] args) {
        // The scanner is temporally, im just testing rn
        // it will be removed later
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        String channel = scanner.nextLine();

        conn = new ClientConnectService(name, channel);

        if (!conn.start()) {
            System.out.println("An error occurred, please check your connection or server connection and try again!");
            return;
        }

        // Shutdown hook
        // I don't think this will work, sorry it's my first time trying this
        Runtime.getRuntime().addShutdownHook(new ShutdownThread());
    }

    /**
     * @return User connection to the server
     */
    public static Service getConnection() {
        return conn;
    }
}

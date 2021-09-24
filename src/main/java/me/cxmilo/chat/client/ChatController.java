package me.cxmilo.chat.client;

import me.cxmilo.chat.client.service.Service;
import me.cxmilo.chat.client.service.impl.ClientConnectService;

import java.util.Scanner;

public class ChatController {

    public static void main(String[] args) {
        // The scanner is temporally, im just testing rn
        // it will be removed later
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        String channel = scanner.nextLine();

        Service conn = new ClientConnectService(name, channel);
        conn.start();
    }
}

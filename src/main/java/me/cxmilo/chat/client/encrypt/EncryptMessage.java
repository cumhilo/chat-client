package me.cxmilo.chat.client.encrypt;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class EncryptMessage {

    public static byte[] toBase64(String message) {
        return Base64.getEncoder().encode(message.getBytes(StandardCharsets.UTF_8));
    }
}

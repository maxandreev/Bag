package com.crystalnix.mandreev.filebag.utils;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by max on 09.09.15.
 */
public class DigestMaker {

    public static String getStringDigest(byte[] bytes, String digestMethod) throws NoSuchAlgorithmException, IOException {
        MessageDigest md = MessageDigest.getInstance(digestMethod);

        md.update(bytes);

        byte[] hash = md.digest();

        StringBuilder hexString = new StringBuilder();

        for (int i = 0; i < hash.length; i++) {
            if ((0xff & hash[i]) < 0x10) {
                hexString.append("0"
                        + Integer.toHexString((0xFF & hash[i])));
            } else {
                hexString.append(Integer.toHexString(0xFF & hash[i]));
            }
        }

        return hexString.toString();
    }
}

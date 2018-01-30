package com.ant.gallerytestapp.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by mihailantipev on 29.01.18.
 */

public class HashHelper {

    public static String md5(final String s) {
        try {
            // Create MD5 Hash
            MessageDigest digest = java.security.MessageDigest.getInstance("MD5");
            digest.update(s.getBytes());
            byte messageDigest[] = digest.digest();

            // Create Hex String
            StringBuilder hexString = new StringBuilder();
            for (byte aMessageDigest : messageDigest) {
                String h = Integer.toHexString(0xFF & aMessageDigest);
                while (h.length() < 2) {
                    h = "0" + h;
                }
                hexString.append(h);
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            // TODO: Handle exception
        }
        return "";
    }
}

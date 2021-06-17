package com.archforce.arc.facility.utils;

import com.archforce.arc.facility.log.LogUtils;
import org.apache.commons.lang.StringUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encrypt {
    public Encrypt() {
    }

    public static String SHA256(final String string) {
        return SHA(string, "SHA-256");
    }

    public static String SHA512(final String string) {
        return SHA(string, "SHA-512");
    }

    private static String SHA(final String strText, final String type) {
        String strResult = null;
        if (!StringUtils.isEmpty(strText)) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(type);
                messageDigest.update(strText.getBytes());
                byte[] byteBuffer = messageDigest.digest();
                StringBuilder strHexString = new StringBuilder();

                for (int i = 0; i < byteBuffer.length; ++i) {
                    String hex = Integer.toHexString(255 & byteBuffer[i]);
                    if (hex.length() == 1) {
                        strHexString.append('0');
                    }
                    strHexString.append(hex);
                }
                strResult = strHexString.toString();
            } catch (NoSuchAlgorithmException var8) {
                LogUtils.error(Encrypt.class, "Encrypt加密解密类异常", "Encrypt加密解密类异常", var8);
            }
        }
        return strResult;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(SHA256("archforce"));
        System.out.println(SHA512("archforce"));
    }

}

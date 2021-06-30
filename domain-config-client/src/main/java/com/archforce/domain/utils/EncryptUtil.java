package com.archforce.domain.utils;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class EncryptUtil {
    private static final String password = "ARCHFORCE";
    private static final String passwordPwd = "ARCHFORCEPWD";

    public EncryptUtil() {
    }

    private static String encode(String input, String password) {
        StandardPBEStringEncryptor encrypt = new StandardPBEStringEncryptor();
        encrypt.setAlgorithm("PBEWithMD5AndDES");
        encrypt.setPassword(password);
        String result = encrypt.encrypt(input);
        return result;
    }

    public static String encode(String input) {
        return  encode(input, "ARCHFORCE");
    }

    public static String encodePwd(String input) {
        return encode(input, "ARCHFORCEPWD");
    }

    public static String decode(String input, String password) {
        StandardPBEStringEncryptor encrypt = new StandardPBEStringEncryptor();
        encrypt.setAlgorithm("PBEWithMD5AndDES");
        encrypt.setPassword(password);
        String result = encrypt.decrypt(input);
        return result;
    }

    public static String decode(String input) {
        return  decode(input, "ARCHFORCE");
    }

    public static String decodePwd(String input) {
        return decode(input, "ARCHFORCEPWD");
    }
}

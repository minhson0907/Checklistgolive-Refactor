package android.base;

import java.util.Base64;

public class EncryptionAndDecryption {

    public static void main(String[] args) {

        String encrptData= "";

        byte[] encodedBytes = Base64.getEncoder().encode(encrptData.getBytes());

        System.out.println("encodedBytes --------------->" + new String(encodedBytes));

    }
}

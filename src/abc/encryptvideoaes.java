package abc;

import java.io.*;
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class encryptvideoaes {
    public static String initVector = "1234567890123456"; // 16 characters
    // 16 characters



    public static void encrypt(String key, String filePath, String outPath) throws FileNotFoundException, IOException {
        try {
            IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
            try (FileInputStream fis = new FileInputStream(filePath)) {
                FileOutputStream fos = new FileOutputStream(outPath);
// Write bytes
                try (CipherOutputStream cosl = new CipherOutputStream(fos, cipher)) {
// Write bytes
                    int b;
                    byte[] d = new byte[8];
                    while ((b = fis.read(d)) != -1) {
                        cosl.write(d, 0, b);
                    }
// Flush and close streams.
                    cosl.flush();
                }
            }
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException | NoSuchPaddingException |
                 InvalidKeyException | InvalidAlgorithmParameterException ex) {
            System.out.print(ex.getMessage());
        }

    }
    public static void decrypt(String key, String outPath, String inPath) throws FileNotFoundException, IOException {
        try {
            IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8")); SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
            Cipher cipher =Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher. DECRYPT_MODE, skeySpec, iv);
            FileInputStream fis= new FileInputStream(outPath);
            CipherInputStream cisl;
            try (FileOutputStream fos = new FileOutputStream(inPath)) {
                cisl =new CipherInputStream(fis, cipher);
// CipherInputStream cis2 = new CipherInputStream(fis, cipher2);
                int b;
                byte[] d = new byte[8];
                while ((b =cisl.read(d)) != -1) {
                    fos.write(d, 0, b);
                } fos.flush();
            }
// Cipher InputStream cis2 = new CipherInputStream(fis, cipher2);
            cisl.close();
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | InvalidAlgorithmParameterException ex) { System.out.print(ex.getMessage());
        }
    }
}
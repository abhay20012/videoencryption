import abc.encryptvideoaes;

public class Main {
    public static void main(String[] args) throws Exception
    {
        encryptvideoaes a=new encryptvideoaes();
        String key = "uxjdNijiyJDYOJ3RuxjdNijiyJDyOJ34"; // 32 characters

        System.out.print("ENCRYPTION :");
        a.encrypt (key, "filepATH", "Encrypted.enc"); System.out.println("DONE");
        System.out.print("DECRYPTION :");
        a.decrypt (key, "Encrypted.enc", "DecrypFile.mp4"); System.out.println("DONE");
    }

}
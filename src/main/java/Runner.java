
public class Runner {
    public static void main(String[] args) {
        doDecrypt();
    }

    public static void doCrypt() {
        Encrypting encrypting = new Encrypting();
        Resourses resourses = new Resourses();
        String text1 = resourses.getTextForCrypt();
        int key = resourses.getKey();
        encrypting.crypt(text1,key);
    }

    public static void doDecrypt() {
        Decrypt decrypt = new Decrypt();
        Resourses resourses = new Resourses();
        String text2 = resourses.getTextForDecrypt();
        int key = resourses.getKey();
        decrypt.decrypt(text2,key);
    }
}

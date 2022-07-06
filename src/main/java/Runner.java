
public class Runner {
    public static void main(String[] args) {
        Encrypting encrypting = new Encrypting();
        Resourses resourses = new Resourses();
        String text = resourses.getTextForCrypt();
        int key = resourses.getKey();
        String way = resourses.getWay();
        System.out.println(encrypting.crypt(text,key,way));
    }
}

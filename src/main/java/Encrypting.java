public class Encrypting {

    public String crypt(String text, int key, String way) { //метод шифрования
        // сделать проверку на пустоту
        char[] charArray = text.toCharArray();
        for (int i = 0; i < text.length(); i++) {
            int temp = Constants.getALPHABET().indexOf(text.charAt(i)); // Получаем индекс символа в алфавите из входящего текста
            if (temp == -1) {
                i++;
                if (way.equalsIgnoreCase("R")) {
                    charArray[i] = Constants.getALPHABET().get(temp + key);
                } else if (way.equalsIgnoreCase("L")) {
                    charArray[i] = Constants.getALPHABET().get(temp - key); // бросает ошибку index - 1
                }
            }
        }
        return String.valueOf(charArray);
    }
}

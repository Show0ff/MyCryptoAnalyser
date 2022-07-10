import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Arrays;

public class Decrypt {

    public void decrypt(String text, int key) {
        char[] charArray = text.toCharArray();
        for (int i = 0; i < text.length(); i++) {
            int temp = Constants.getALPHABET().indexOf(text.charAt(i)); // Получаем индекс символа в алфавите из входящего текста
            Constants.getALPHABET().get((temp - key) % (Constants.getALPHABET().size()));
        }

        final ByteBuffer byteBuffer = StandardCharsets.UTF_8.encode(CharBuffer.wrap(charArray));
        byte[] result = Arrays.copyOf(byteBuffer.array(), byteBuffer.limit());

        try {
            Files.write(Constants.getOriginalText(), result);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

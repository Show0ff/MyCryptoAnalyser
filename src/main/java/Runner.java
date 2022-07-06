import java.io.FileReader;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Runner {

    public static void main(String[] args) {

        try {
            List<String> textString = Files.readAllLines(Path.of("C:\\JAVA\\CryptoAnaliser\\CryptoAnaliser\\src\\other\\crypt.txt"));

            System.out.println(textString);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Runner {

    public static void main(String[] args) {


        try (FileChannel channel = FileChannel.open(Path.of("C:\\JAVA\\CryptoAnaliser\\CryptoAnaliser\\src\\other\\crypt.txt"))){
            ByteBuffer buffer = ByteBuffer.allocate((int) channel.size());

            channel.read(buffer);
            List<Byte> byteBufferList = new ArrayList<>();
            buffer.flip();

            while (buffer.hasRemaining()) {
                byteBufferList.add(buffer.get());
            }
            System.out.println(byteBufferList);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

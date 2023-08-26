import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FourRyanSeaman {
    public static void main(String[] args){
        double startTime = System.nanoTime();
        byte[] bytes = getFileBytes("half_gaps.bin");
        long[] gaps = new long[bytes.length];
        for(int i = 0; i < bytes.length ; i++){
            gaps[i] = Byte.toUnsignedLong(bytes[i]);
        }
        int runningTotal = 0;
        for(int i = 0 ; i < gaps.length ; i++){
            runningTotal += gaps[i];
            gaps[i]=runningTotal;
        }
        for(int i = 0; i < gaps.length; i++){
            gaps[i] = (gaps[i] * 2) +3;
        }
        double duration = System.nanoTime() - startTime;
        duration = duration/Math.pow(10, 9);
        for(int i = 0; i < 15; i++){
            System.out.println(gaps[i]);
        }
        for(int i = gaps.length - 1; i > gaps.length - 6 ; i--){
            System.out.println(gaps[i]);
        }
        System.out.println("Seconds: " + duration);
    }

    public static byte[] getFileBytes(String path){
        byte[] bytes = null;
        try{
            bytes = Files.readAllBytes(Paths.get(path));
        }catch (IOException e){
            e.printStackTrace();
        }
        return bytes;
    }
}

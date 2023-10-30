import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProcessBuilderDemo {
    public static void main(String[] args)throws IOException, InterruptedException {
        String [] comands={
            "ls",
            "-l"
        };

        ProcessBuilder pb= new ProcessBuilder(comands);

        Process process = pb.start();

        BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String s = null;
        while ((s = stdInput.readLine()) != null) {
            System.out.println(s);
        }

    }
}

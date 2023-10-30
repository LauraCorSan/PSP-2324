import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ProcessBuilderPow {
    public static void main(String[] args)throws IOException, InterruptedException {
        String [] comands={
            "./pow"
        };

        ProcessBuilder pb = new ProcessBuilder(comands);

        Process process = pb.start();

        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));

        stdOut.write('9');
        stdOut.write("\n");
        stdOut.flush();
        stdOut.close();

        BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String s=null;
        while ((s = stdInput.readLine()) != null) {
            System.out.println(s);
        }

    }
}

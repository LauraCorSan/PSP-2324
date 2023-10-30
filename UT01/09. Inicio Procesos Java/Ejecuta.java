import java.io.IOException;

public class Ejecuta{
    public static void main(String[] args)throws IOException, InterruptedException {
        ProcessBuilder pb = new ProcessBuilder("xed");

        for(int i = 0 ; i<args.length ; i++){
            pb.start();
        }

        //p.waitFor(); espera a que acabe
        System.out.println("Se ha terminado el proceso");
    }
}

/*Investiga el comando tarde linux para crear backups de directorios.

Crea un programa que reciba por parámetro varias rutas del sistema de fichero. El programa comprimirá cada una 
de ellas con un proceso. Si se reciben 3 directorios creará 3 archivos comprimidos con el nombre de cada 
directorio y la fecha YYYY-MM-DD.*/


import java.io.IOException;

public class Compresor {
    public static final String FECHA = "_2023_10_30";
    public static void main(String[] args) throws IOException, InterruptedException{

        for(int i=0 ; i<args.length ; i++){
            String argumento=args[i];
            String nombreArchivo=argumento.replace('/', '_')+FECHA;
            String [] comands={
                "tar",
                "-czvf",
                //args[0]+".tar.gz",
                //pasarle el nombre 
                nombreArchivo,
                args[i]
            };

            //tar -czvf nombre-nuevo directorio

            ProcessBuilder pb= new ProcessBuilder(comands);

            Process process = pb.start();

            pb.inheritIO();//imrpime lo que sea tambien en nuestro proceso

            System.out.println("Proceso terminado");
        }
    }
}

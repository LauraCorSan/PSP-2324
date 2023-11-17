public class Cancion implements Runnable{
    String animal;
    String accion;
    int numMax;
    
    public Cancion(String animal, String accion, int numMax) {
        this.animal = animal;
        this.accion = accion;
        this.numMax = numMax;
    }

    private boolean esPrimo(int numero) {
        if (numero <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    } 

    @Override
    public void run() {
        Random rand = new Random();
        for (int i = 1; i <= numeroMaximo; i++) {
            int numeroAleatorio = rand.nextInt(200001) + 100000;

            // Verificar si el número aleatorio es primo
            if (esPrimo(numeroAleatorio)) {
                System.out.println(tipoAnimal + " " + accion + " sobre la tela de una araña");
                System.out.println("Número aleatorio (" + tipoAnimal + " " + i + "): " + numeroAleatorio + " es primo\n");
            } else {
                System.out.println(tipoAnimal + " " + accion + " sobre la tela de una araña");
                System.out.println("Número aleatorio (" + tipoAnimal + " " + i + "): " + numeroAleatorio + " no es primo\n");
            }
        }
    }

}

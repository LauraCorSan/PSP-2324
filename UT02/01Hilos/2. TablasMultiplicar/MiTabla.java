
public class MiTabla implements Runnable {
    int numero;

    public MiTabla(int numero) {
        this.numero = numero;
    }

    public void run(){
        for (int i = 1; i <= 10; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + numero + " x " + i + " = " + (numero * i));
        }
    }
}

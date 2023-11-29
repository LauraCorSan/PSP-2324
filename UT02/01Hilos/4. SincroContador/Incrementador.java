
public class Incrementador implements Runnable {

    Contador cont;

    public Incrementador(Contador c) {
        this.cont = c;
    }

    @Override
    public void run() {
        for (int i = 0; i < PrincipalCont.NVECES; i++) {
            cont.incrementa();
        }

    }

}

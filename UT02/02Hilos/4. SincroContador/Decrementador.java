public class Decrementador implements Runnable {

    Contador cont;

    public Decrementador(Contador c) {
        this.cont = c;
    }

    @Override
    public void run() {
        for (int i = 0; i < PrincipalCont.NVECES; i++) {
            cont.decrementa();
        }

    }

}

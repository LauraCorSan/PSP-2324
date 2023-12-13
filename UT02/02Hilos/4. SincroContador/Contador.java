public class Contador {
    private int c = 0;

    public Contador(int c) {
        this.c = c;
    }

    public synchronized void incrementa() {
        c = c + 1;
    }

    public synchronized void decrementa() {
        c = c - 1;
    }

    public String toString() {
        return String.valueOf(c);
    }

}

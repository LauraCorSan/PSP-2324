
public class Corredor implements Runnable {
    private static final long TIEMPO_DESCANSO=500;
    private static final double MAX_INTERVALO_KM=10;
    int kmRecorridos;
    int kmTotales;
    int dorsal;
    public Corredor(int kmTotales, int dorsal) {
        this.kmRecorridos = 0;
        this.kmTotales = kmTotales;
        this.dorsal = dorsal;
    }

    @Override
    public void run(){
        System.out.printf("Soy el dorsal %d inicio mi carrera\n",dorsal);
        while(kmRecorridos < kmTotales){
            try{
            Thread.sleep((long)(Math.random()*TIEMPO_DESCANSO)+TIEMPO_DESCANSO);
            System.out.printf("Soy %d | %d/%d km recorridos\n", dorsal, kmRecorridos, kmTotales);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            kmRecorridos+=Math.random()*MAX_INTERVALO_KM;
        }
       System.out.printf("Soy el dorsal %d ¡TERMINE!\n",dorsal);
    }
    
}

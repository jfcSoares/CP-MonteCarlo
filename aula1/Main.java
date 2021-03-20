package aula1;

public class Main {

    public static void main(String[] args) {
        int points = Integer.parseInt(args[0]);
        int nThreads;
        long startTime = 0;
        long stopTime = 0;

        if (args[1] == null) {
            nThreads = 1;
        } else {
            nThreads = Integer.parseInt(args[1]);
        }

        Auxiliar aux = new Auxiliar(points);
        double pi = 0;
        if (points == 0) {
            pi = 0;
        } else {
            startTime = System.currentTimeMillis();
            pi = aux.getPI(nThreads);
            stopTime = System.currentTimeMillis();
        }

        System.out.println("Executed with " + nThreads + " threads.");
        System.out.println("Duration: " + (stopTime - startTime) + "ms");
        System.out.println("Total number of points: " + points);
        System.out.println("Points within the circle: " + aux.getInteriorPoints());
        System.out.println("Pi estimation: " + pi);
    }
}

package aula1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class Auxiliar {

    AtomicInteger nAtomSuccess;
    int points;
    double value;

    class MonteCarlo implements Runnable {
        private int points;

        public MonteCarlo(int threadPoints) {
            this.points = threadPoints;
        }

        @Override
        public void run() {
            for (int i = 0; i < points; i++) {
                double x = ThreadLocalRandom.current().nextDouble();
                double y = ThreadLocalRandom.current().nextDouble();
                if (x * x + y * y <= 1)
                    nAtomSuccess.incrementAndGet();
            }

        }
    }

    public Auxiliar(int points) {
        this.nAtomSuccess = new AtomicInteger(0);
        this.points = points;
        this.value = 0;
    }

    public AtomicInteger getInteriorPoints() {
        return nAtomSuccess;
    }

    public double getPI(int nThreads) {
        ExecutorService serv = Executors.newWorkStealingPool(nThreads);
        for (int i = 0; i < nThreads; i++) {
            Runnable t = new MonteCarlo(points / nThreads);
            serv.execute(t);
        }

        serv.shutdown();
        while (!serv.isTerminated()) {
        }
        value = 4.0 * (nAtomSuccess.get() / (double) points);
        return value;
    }

}

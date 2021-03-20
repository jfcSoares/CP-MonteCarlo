public class Main {

    public static void main(String[] args) {
        int points = Integer.parseInt(args[0]);
        double pi;
        if (points == 0) {
            pi = 0;
        }

        int insideCounter = 0;

        long starTime = System.currentTimeMillis();
        for (int i = 0; i < points; i++) {
            double xCoord = Math.random();
            double yCoord = Math.random();
            double res = (xCoord * xCoord) + (yCoord * yCoord);
            if (res <= 1) {
                insideCounter++;
            }
        }

        double ro = insideCounter / (double) points;
        pi = ro * 4;
        long stopTime = System.currentTimeMillis();
        System.out.println("Duration: " + (stopTime - starTime) + "ms");
        System.out.println("Total number of points: " + points);
        System.out.println("Points within the circle: " + insideCounter);
        System.out.println("Pi estimation: " + pi);
    }
}

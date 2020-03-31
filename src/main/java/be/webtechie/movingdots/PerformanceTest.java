package be.webtechie.movingdots;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Based on
 * https://www.javacodeexamples.com/calculate-fibonacci-series-in-java-example/481
 */
public class PerformanceTest {

    private static final int MAX_NUMBER = 2 ^ 100;

    public static void main(String[] args) throws NoSuchAlgorithmException {
        long start = System.nanoTime();

        // Define first two numbers of the series
        long a = 0;
        long b = 1;

        // Variable to hold the sum
        long sum = 0;

        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");

        System.out.print(a + " " + b + " ");

        for (int i = 2; i < MAX_NUMBER; i++) {
            //sum last two numbers
            sum = a + b;

            //change the numbers, shift them one place in the series
            a = b;
            b = sum;

            System.out.print(sum + " ");
            messageDigest.update(String.valueOf(sum).getBytes());
        }

        long duration = System.nanoTime() - start;
        System.out.println("");
        System.out.println("Duration: " + (duration / 1000000F));
    }
}

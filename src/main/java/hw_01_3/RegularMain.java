package hw_01_3;

import java.util.List;

/**
 * Выводы в MultithreadingMain
 */

public class RegularMain {
    public static void main(String[] args) {
        System.out.println("*RegularMain*");
        long startTime = System.currentTimeMillis();
        List<Integer> list = new IntegerListCreator(100).getNumbersList();
        System.out.println(calculateAverage(list));
        long endTime = System.currentTimeMillis();
        System.out.println((endTime - startTime) + " ms");

        long startTime2 = System.currentTimeMillis();
        List<Integer> list2 = new IntegerListCreator(100_000_000).getNumbersList();
        System.out.println(calculateAverage(list2));
        long endTime2 = System.currentTimeMillis();
        System.out.println((endTime2 - startTime2) + " ms");
    }

    private static String calculateAverage(List<Integer> list) {
        double result = list.stream().mapToDouble(Integer::doubleValue).average().getAsDouble();
        return String.format("Среднее арифметическое - %.2f", result);
    }
}

package hw_01_3;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;

/**
 * Результаты.
 *
 * RegularMain:
 * Среднее арифметическое - 50,28
 * 40 ms
 * Среднее арифметическое - 49,50
 * 4295 ms
 *
 * MultithreadingMain:
 * Среднее арифметическое - 50,62
 * 55 ms
 * Среднее арифметическое - 49,49
 * 3694 ms
 *
 * Вывод:
 * В коллекции на 100 элементов обычный способ нахождения среднего значения эффективней, т.к.
 * результат мы находим примерно на 10 миллисекунд быстрее.
 * Это объясняется тем, что создание новых объектов и распараллеливание задачи - затратные процедуры.
 * Нахождение среднего значения коллекции на 100_000_000 элементов быстрее примерно на 1 секунду в классе MultithreadingMain.
 * Значит, для ускорения времени исполнения задачи распараллеливание нужно применять только при сложных вычислениях.
 */

public class MultithreadingMain {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("*MultithreadingMain*");
        long startTime = System.currentTimeMillis();
        List<Integer> list = new IntegerListCreator(100).getNumbersList();
        System.out.println(forkTasksAndGetResult(list));
        long endTime = System.currentTimeMillis();
        System.out.println((endTime - startTime) + " ms");

        long startTime2 = System.currentTimeMillis();
        List<Integer> list2 = new IntegerListCreator(100_000_000).getNumbersList();
        long endTime2 = System.currentTimeMillis();
        System.out.println(forkTasksAndGetResult(list2));
        System.out.println((endTime2 - startTime2) + " ms");
    }

    private static String forkTasksAndGetResult(List<Integer> list) throws ExecutionException, InterruptedException {
        ForkJoinPool pool = new ForkJoinPool();
        int middle = list.size() / 2;
        ArrayAverageTask task1 = new ArrayAverageTask(list.subList(0, middle));
        ArrayAverageTask task2 = new ArrayAverageTask(list.subList(middle, list.size()));

        List<ArrayAverageTask> taskList = List.of(task1, task2);
        List<Future<Double>> future = pool.invokeAll(taskList);
        double result = 0;
                for (Future<Double> f : future) {
                    result += f.get();
                }
        return String.format("Среднее арифметическое - %.2f", result/ future.size());
    }
}

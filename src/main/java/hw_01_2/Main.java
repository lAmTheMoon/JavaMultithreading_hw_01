package hw_01_2;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService threadPool = Executors.newFixedThreadPool(4);

        List<Callable<String>> list = List.of(
                new MyCallable("поток 1"),
                new MyCallable("поток 2"),
                new MyCallable("поток 3"),
                new MyCallable("поток 4"));

        String future = threadPool.invokeAny(list);
        System.out.println(future);
        threadPool.shutdown();
    }
}
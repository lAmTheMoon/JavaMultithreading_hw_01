package hw_01_3;

import java.util.List;
import java.util.concurrent.Callable;

public class ArrayAverageTask implements Callable<Double> {
    private List<Integer> list;

    public ArrayAverageTask(List<Integer> list) {
        this.list = list;
    }

    @Override
    public Double call() throws Exception {
        return this.list.stream().parallel().mapToDouble(Integer::doubleValue).average().getAsDouble();
    }
}

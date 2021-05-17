package hw_01_3;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class IntegerListCreator {
    private int minValue = 0;
    private int maxValue = 100;
    private List<Integer> numbersList;

    public IntegerListCreator(int listLength) {
        this.numbersList = createRandomNumberList(listLength);
    }

    private List<Integer> createRandomNumberList(int listLength) {
        return new Random().ints(listLength, this.minValue, this.maxValue)
                .boxed().collect(Collectors.toList());
    }

    public List<Integer> getNumbersList() {
        return numbersList;
    }
}

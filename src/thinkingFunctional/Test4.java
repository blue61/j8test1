package thinkingFunctional;

import java.util.*;
import static java.util.stream.Collectors.toList;

public class Test4 {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> doubled = new ArrayList<>();
        for (int value : numbers) {
            if (value % 2 == 0) {
                doubled.add(value * 2);
            }
        }

        System.out.println(doubled);

        System.out.println(
                numbers.stream()
                .filter(e -> e % 2 == 0)
                .map(e -> e * 2)
                .collect(toList()));
    }
}

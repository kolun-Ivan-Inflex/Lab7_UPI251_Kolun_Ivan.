package ua.opnu;
import java.util.function.Predicate;
import java.util.function.Function;
public class LambdaTasks {
    public static Predicate<Integer> isPrime() {
        return number -> {
            if (number < 2) {
                return false;
            }

            for (int i = 2; i < number; i++) {
                if (number % i == 0) {
                    return false;
                }
            }

            return true;
        };
    }

    public static Function<Integer, Integer> powerOfTwo() {
        return n -> (int) Math.pow(2, n);
    }

    public static String[] stringify(int[] numbers,
                                     Function<Integer, String> function) {
        String[] result = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            result[i] = function.apply(numbers[i]);
        }

        return result;
    }
}
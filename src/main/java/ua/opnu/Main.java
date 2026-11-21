package ua.opnu;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.function.Consumer;
import java.util.function.Function;
public class Main {
    public static void main(String[] args) {
        System.out.println("Завдання 1");
        Predicate<Integer> prime = LambdaTasks.isPrime();
        System.out.println(prime.test(7));
        System.out.println(prime.test(10));
        System.out.println("\nЗавдання 2");
        Student[] students = {
                new Student("Kolun", "Ivan", "UPI-251", new int[]{90, 85, 75}),
                new Student("Ivanov", "Petro", "UPI-251", new int[]{50, 80, 70}),
                new Student("Petrenko", "Oleh", "UPI-252", new int[]{75, 80, 90}),
                new Student("Shevchenko", "Andriy", "UPI-252", new int[]{40, 55, 60})
        };
        Predicate<Student> noDebts = student -> {
            for (int mark : student.getMarks()) {
                if (mark < 60) {
                    return false;
                }
            }

            return true;
        };
        Student[] passed = StudentUtils.filter(students, noDebts);
        System.out.println(Arrays.toString(passed));
        System.out.println("\nЗавдання 3");
        Predicate<Student> correctGroup =
                student -> student.getGroup().equals("UPI-251");
        Predicate<Student> goodMarks =
                student -> Arrays.stream(student.getMarks()).average().orElse(0) >= 80;
        Student[] filtered = StudentUtils.filter(
                students, correctGroup, goodMarks
        );
        System.out.println(Arrays.toString(filtered));

        System.out.println("\nЗавдання 4");

        Consumer<Student> printName = student ->
                System.out.println(student.getSurname() + " " + student.getName());
        StudentUtils.forEach(students, printName);
        System.out.println("\nЗавдання 5");
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        StudentUtils.process(
                numbers,
                n -> n % 2 == 0,
                n -> System.out.println("Парне число: " + n)
        );
        StudentUtils.process(
                numbers,
                n -> n > 5,
                n -> System.out.println("Число більше 5: " + n)
        );

        System.out.println("\nЗавдання 6");

        Function<Integer, Integer> power = LambdaTasks.powerOfTwo();

        for (int number : numbers) {
            System.out.println(number + " -> " + power.apply(number));
        }
        System.out.println("\nЗавдання 7");
        Function<Integer, String> digitToWord = number -> {
            String[] words = {
                    "нуль", "один", "два", "три", "чотири",
                    "п'ять", "шість", "сім", "вісім", "дев'ять"
            };
            return words[number];
        };
        int[] digits = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        String[] words = LambdaTasks.stringify(digits, digitToWord);
        System.out.println(Arrays.toString(words));
    }
}
package ua.opnu;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Consumer;
public class StudentUtils {
    public static Student[] filter(Student[] students, Predicate<Student> predicate) {
        List<Student> result = new ArrayList<>();

        for (Student student : students) {
            if (predicate.test(student)) {
                result.add(student);
            }
        }
        return result.toArray(new Student[0]);
    }
    public static Student[] filter(Student[] students,
                                   Predicate<Student> first,
                                   Predicate<Student> second) {
        return filter(students, first.and(second));
    }
    public static void forEach(Student[] students, Consumer<Student> action) {
        for (Student student : students) {
            action.accept(student);
        }
    }
    public static void process(int[] numbers,
                               Predicate<Integer> predicate,
                               Consumer<Integer> action) {
        for (int number : numbers) {
            if (predicate.test(number)) {
                action.accept(number);
            }
        }
    }
}
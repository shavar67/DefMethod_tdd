package solution;

import controller.FileController;
import model.Person;
import utils.SortComparator;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Comparator.comparing;

public class Solution {

    public static void main(String[] args) {
        printOutput1();
        printOutput2();
        printOutput3();
    }

    private static void processFiles(FileController controller, List<Person> people, String[][] source) {
        for (String[] strings : source) {
            Person[] person = controller.parseFile(strings[0], strings[1]);
            Collections.addAll(people, person);
        }
    }

    public static void printOutput1() {
        List<Person> people = new ArrayList<>();
        String[][] source = {
                {"src/main/java/files/comma.txt", "\\,"},
                {"src/main/java/files/pipe.txt", "\\|"},
                {"src/main/java/files/space.txt", "\\s+"}
        };
        FileController controller = new FileController();

        processFiles(controller, people, source);

        System.out.println("Output 1:");
        people.stream()
                .filter(person -> person.getSex().trim().equalsIgnoreCase("Female"))
                .sorted(comparing(Person::getLastName))
                .forEachOrdered(System.out::println);
        people.stream()
                .filter(person -> person.getSex().trim().equalsIgnoreCase("Male"))
                .sorted(comparing(Person::getLastName))
                .forEachOrdered(System.out::println);
        System.out.println();
    }

    public static void printOutput2() {
        List<Person> people = new ArrayList<>();
        String[][] source = {
                {"src/main/java/files/comma.txt", "\\,"},
                {"src/main/java/files/pipe.txt", "\\|"},
                {"src/main/java/files/space.txt", "\\s+"}
        };
        FileController controller = new FileController();

        processFiles(controller, people, source);

        System.out.println("Output 2:");
        people.sort(new SortComparator());
        people.forEach(System.out::println);
        System.out.println();
    }

    public static void printOutput3() {
        List<Person> people = new ArrayList<>();
        String[][] source = {
                {"src/main/java/files/comma.txt", "\\,"},
                {"src/main/java/files/pipe.txt", "\\|"},
                {"src/main/java/files/space.txt", "\\s+"}
        };
        FileController controller = new FileController();

        processFiles(controller, people, source);

        System.out.println("Output 3:");
        people.stream().sorted(comparing(Person::getLastName).reversed()).forEachOrdered(System.out::println);
    }
}
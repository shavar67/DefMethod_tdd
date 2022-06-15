package solution;
import controller.FileController;
import model.Person;
import utils.SortComparator;
import java.io.*;
import java.util.*;

import static java.util.Comparator.comparing;
public class Solution {
    public static void main(String[] args) throws IOException {
        List<Person> _people = new ArrayList<>();
        String[][] source = {
                {"src/main/java/files/comma.txt", "\\,"},
                {"src/main/java/files/pipe.txt", "\\|"},
                {"src/main/java/files/space.txt", "\\s+"}
        };
        FileController _controller = new FileController();
        for (String[] strings : source) {
            Person[] person = _controller.parseFile(strings[0], strings[1]);
            Collections.addAll(_people, person);
        }
        System.out.println("Output 1:");
        _people.stream()
                .filter(person -> person.getSex().trim().equalsIgnoreCase("Female"))
                .sorted(comparing(Person::getLastName))
                .forEachOrdered(System.out::println);

        _people.stream()
                .filter(person -> person.getSex().trim().equalsIgnoreCase("Male"))
                .sorted(comparing(Person::getLastName))
                .forEachOrdered(System.out::println);

        System.out.println("\nOutput 2:");
        Collections.sort(_people, new SortComparator());
        _people.forEach(person -> System.out.println(person));

        System.out.println("\nOutput 3:");
        _people.stream()
                .sorted(comparing(Person::getLastName).reversed())
                .forEach(System.out::println);

        writeFile(
                "Sample data for test; sort output #2:\n\n" + _people.toString().replaceAll(",", "\\\n"));
    }





    public static void writeFile(String data) throws IOException {
        BufferedWriter bufferedWriter = null;
        FileWriter fileWriter = null;
        File file = new File("src/main/java/output/output2.txt");
        try {
            if (!file.exists()) {
                file.createNewFile();
                System.out.println();
                System.out.println(file.getAbsoluteFile() + " is now created");
            }
            fileWriter = new FileWriter(file.getAbsoluteFile());
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(data);
            System.out.println("\n\nFor bonus points (: ->");
            System.out.print("Writing sample data [output 2] to file,\nsee path -> " + file.getPath());

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            bufferedWriter.close();
        }
    }
}
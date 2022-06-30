package solution;
import controller.FileController;
import model.Person;
import utils.SortComparator;

import java.io.*;
import java.util.*;

import static java.util.Comparator.comparing;
public class Solution {
    public static void main(String[] args) throws IOException {
           printOutPut1();
          printOutPut2();
          printOutPut3();
    }


    public static void printOutPut1(){
        List<Person> _people = new ArrayList<>();
        List<Person> _sorted = new ArrayList<>();
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
                .forEachOrdered(p1 -> _sorted.add(p1));
        _people.stream()
                .filter(person -> person.getSex().trim().equalsIgnoreCase("Male"))
                .sorted(comparing(Person::getLastName))
                .forEachOrdered(p2 -> _sorted.add(p2));
        for (Person person : _sorted) {
            System.out.println(person);
        }
        System.out.println();
    }

     public static void printOutPut2(){
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
         System.out.println("Output2:");
        Collections.sort(_people,new SortComparator());
        _people.forEach(person -> System.out.println(person));
         System.out.println();
     }

     public static  void  printOutPut3(){
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
         System.out.println("Output3:");
         _people.stream().sorted(comparing(Person::getLastName).reversed()).forEachOrdered(System.out::println);
     }
    }
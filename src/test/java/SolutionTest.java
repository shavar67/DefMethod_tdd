import controller.FileController;
import model.Person;
import org.junit.Test;
import utils.SortComparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static java.util.Comparator.comparing;
import static org.junit.Assert.*;

public class SolutionTest {

    String[] commaTestData =
            {"Abercrombie Neil Male 2/13/1943 Tan",
                    "Bishop Timothy Male 4/23/1967 Yellow",
                    "Kelly Sue Female 7/12/1959 Pink"};

    String[] pipeTestData =
            {"Smith Steve Male 3/3/1985 Red",
                    "Bonk Radek Male 6/3/1975 Green",
                    "Bouillon Francis Male 6/3/1975 Blue"};
    String[] spaceTestData =
            {"Kournikova Anna Female 6/3/1975 Red",
                    "Hingis Martina Female 4/2/1979 Green",
                    "Seles Monica Female 12/2/1973 Black"};


       String [] testOutputData = {
               "Hingis Martina Female 4/2/1979 Green",
               "Kelly Sue Female 7/12/1959 Pink",
               "Kournikova Anna Female 6/3/1975 Red",
               "Seles Monica Female 12/2/1973 Black",
               "Abercrombie Neil Male 2/13/1943 Tan",
               "Bishop Timothy Male 4/23/1967 Yellow",
               "Bonk Radek Male 6/3/1975 Green",
               "Bouillon Francis Male 6/3/1975 Blue",
               "Smith Steve Male 3/3/1985 Red"
       };
    String [] testOutputData2 = {
            "Abercrombie Neil Male 2/13/1943 Tan",
            "Kelly Sue Female 7/12/1959 Pink",
            "Bishop Timothy Male 4/23/1967 Yellow",
            "Seles Monica Female 12/2/1973 Black",
            "Bonk Radek Male 6/3/1975 Green",
            "Bouillon Francis Male 6/3/1975 Blue",
            "Kournikova Anna Female 6/3/1975 Red",
            "Hingis Martina Female 4/2/1979 Green",
            "Smith Steve Male 3/3/1985 Red"
    };

     String [] testOutPutData3 = {
             "Smith Steve Male 3/3/1985 Red",
             "Seles Monica Female 12/2/1973 Black",
             "Kournikova Anna Female 6/3/1975 Red",
             "Kelly Sue Female 7/12/1959 Pink",
             "Hingis Martina Female 4/2/1979 Green",
             "Bouillon Francis Male 6/3/1975 Blue",
             "Bonk Radek Male 6/3/1975 Green",
             "Bishop Timothy Male 4/23/1967 Yellow",
             "Abercrombie Neil Male 2/13/1943 Tan"
     };


    @Test
    public void parseCommaFile() {
        List<Person> user = new ArrayList<>();
        String[][] source = {
                {"src/main/java/files/comma.txt", "\\,"},
        };
        System.out.println("Parsing and generating users from: " + source[0][0]);
        FileController _controller = new FileController();
        for (int i = 0; i < source.length; i++) {
            String[] strings = source[i];
            Person[] person = _controller.parseFile(strings[0], strings[1]);
            Collections.addAll(user, person);
            for (Person person1 : person) {
                System.out.println(person1);
            }
            System.out.println();
            assertEquals(user.get(i).toString(), commaTestData[i]);
        }
    }

    @Test
    public void parsePipeFile() {
        List<Person> user = new ArrayList<>();
        String[][] source = {
                {"src/main/java/files/pipe.txt", "\\|"},
        };
        System.out.println("Parsing and generating users from: " + source[0][0]);
        FileController _controller = new FileController();
        for (int i = 0; i < source.length; i++) {
            String[] strings = source[i];
            Person[] person = _controller.parseFile(strings[0], strings[1]);
            Collections.addAll(user, person);
            for (Person person1 : person) {
                System.out.println(person1);
            }
            System.out.println();
            assertEquals(user.get(i).toString(), pipeTestData[i]);
        }
    }

    @Test
    public void parseSpaceFile() {
        List<Person> user = new ArrayList<>();
        String[][] source = {
                {"src/main/java/files/space.txt", "\\s+"},
        };
        System.out.println("Parsing and generating users from: " + source[0][0]);
        FileController _controller = new FileController();
        for (int i = 0; i < source.length; i++) {
            String[] strings = source[i];
            Person[] person = _controller.parseFile(strings[0], strings[1]);
            Collections.addAll(user, person);
            for (Person person1 : person) {
                System.out.println(person1);
            }
            System.out.println();
            assertEquals(user.get(i).toString(), spaceTestData[i]  );

        }
    }
    @Test
    public void testOutPut1(){
        List<Person> _people = new ArrayList<>();
        List<Person> _sorted = new ArrayList<>();
        String[][] source = {
                {"src/main/java/files/comma.txt", "\\,"},
                {"src/main/java/files/pipe.txt", "\\|"},
                {"src/main/java/files/space.txt", "\\s+"}
        };
        FileController _controller = new FileController();
        int i = 0;
        for (String[] strings : source) {
            Person[] person = _controller.parseFile(strings[0], strings[1]);
            Collections.addAll(_people, person);
            i++;
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
        assertEquals(_sorted.get(i).toString(), testOutputData[i]);
        System.out.println();
    }

    @Test
    public  void testOutPut2(){
        List<Person> _people = new ArrayList<>();
        List<Person> _sorted = new ArrayList<>();
        String[][] source = {
                {"src/main/java/files/comma.txt", "\\,"},
                {"src/main/java/files/pipe.txt", "\\|"},
                {"src/main/java/files/space.txt", "\\s+"}
        };
        FileController _controller = new FileController();
        int i =0;
        for (String[] strings : source) {
            Person[] person = _controller.parseFile(strings[0], strings[1]);
            Collections.addAll(_people, person);
            i++;
        }
        System.out.println("Output2:");
        Collections.sort(_people,new SortComparator());
        _people.forEach(person ->_sorted.add(person));
        _people.forEach(System.out::println);
        assertEquals(_sorted.get(i).toString(),testOutputData2[i]);

        System.out.println();
    }
     @Test
    public void testOutPut3(){

         List<Person> _people = new ArrayList<>();
         List<Person> _sorted = new ArrayList<>();
         String[][] source = {
                 {"src/main/java/files/comma.txt", "\\,"},
                 {"src/main/java/files/pipe.txt", "\\|"},
                 {"src/main/java/files/space.txt", "\\s+"}
         };
          int i =0;
         FileController _controller = new FileController();
         for (String[] strings : source) {
             Person[] person = _controller.parseFile(strings[0], strings[1]);
             Collections.addAll(_people, person);
             i++;
         }
         _people.stream().sorted(comparing(Person::getLastName).reversed()).forEachOrdered(person -> _sorted.add(person));
         assertEquals(_sorted.get(i).toString(),testOutPutData3[i]);
         System.out.println("Output3:");
         _sorted.forEach(System.out::println);
         System.out.println();
     }
}
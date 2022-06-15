import controller.FileController;
import model.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

  String[] commaTestData = {"Abercrombie Neil Male 2/13/1943 Tan",
          "Bishop Timothy Male 4/23/1967 Yellow",
          "Kelly Sue Female 7/12/1959 Pink"};

    @Test
    public void printFileContent(){
        List<Person> user = new ArrayList<>();
        String[][] source = {
                {"src/main/java/files/comma.txt", "\\,"},
                {"src/main/java/files/pipe.txt", "\\|"},
                {"src/main/java/files/space.txt", "\\s+"}
        };
        FileController _controller = new FileController();
        for (int i = 0; i < source.length; i++) {
            String[] strings = source[i];
            Person[] person = _controller.parseFile(strings[0], strings[1]);
            Collections.addAll(user, person);
            assertEquals(user.get(i).toString(), commaTestData[i]);
        }



    }


}

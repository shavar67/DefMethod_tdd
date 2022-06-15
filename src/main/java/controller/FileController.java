package controller;
import model.Person;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class FileController implements FileOperations {

  @Override
  public Person[] parseFile(String path, String delimiter) {
    List<String[]> _data;
    Person[] _listOfPeople;
    Person _user;
    _data = readFile(path, delimiter);
    _listOfPeople = new Person[_data.size()];
    int i = 0;
    while (i < _data.size()) {
      String[] dataFromFile = _data.get(i);
      _user = createNewUser(dataFromFile, delimiter);
      _listOfPeople[i] = _user;
      i++;
    }
    return _listOfPeople;
  }
  List<String[]> readFile(String path, String delimiter) {
    BufferedReader bufferedReader = null;
    List<String[]> _data = new ArrayList<>();
    String lineToRead;
    try {
      bufferedReader = new BufferedReader(new FileReader(path));
      while ((lineToRead = bufferedReader.readLine()) != null) {
        _data.add(lineToRead.trim().split(delimiter == "\\s+"? " " : delimiter, lineToRead.length() - 1));
      }
    } catch (FileNotFoundException e) {
      System.out.println(e.getMessage());
    } catch (IOException ex) {
      System.out.println(path + " doesn't exist");
      System.out.println(ex.getMessage());
    } finally {
      if (bufferedReader != null) {
        try {
          bufferedReader.close();
        } catch (IOException e) {
          System.out.println(e.getMessage());
        }
      }
    }
    return _data;
  }
  public Person createNewUser(String[] userData, String delimiter) {
    Person _newPerson = null;
    int i = 0;
    while (i < userData.length) {
      switch (delimiter) {
        case "\\s+" -> {
          _newPerson = new Person();
          _newPerson.setLastName(userData[0]);
          _newPerson.setFirstName(userData[1]);
          _newPerson.setSex(!("F".equals(userData[3])) ? "Male" : "Female");
          _newPerson.setBirthDate(userData[4].replaceAll("\\-","\\/"));
          _newPerson.setColor(userData[5]);
        }
        case "\\|" -> {
          _newPerson = new Person();
          _newPerson.setLastName(userData[0]);
          _newPerson.setFirstName(userData[1]);
          _newPerson.setSex(!("F".equals(userData[3])) ? "Male" : "Female");
          _newPerson.setColor(userData[4]);
          _newPerson.setBirthDate(userData[5].replaceAll("\\-","\\/"));


        }
        case "\\," -> {
          _newPerson = new Person();
          _newPerson.setLastName(userData[0]);
          _newPerson.setFirstName(userData[1]);
          _newPerson.setSex(userData[2]);
          _newPerson.setColor(userData[3]);
          String date = userData[4].replaceAll("\\-","\\/") ;
          _newPerson.setBirthDate(date);
        }
        default -> System.out.println("invalid delimiter["+delimiter+"]");
      }
      i++;
    }
    return _newPerson;
  }
}
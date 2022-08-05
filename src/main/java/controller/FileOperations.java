package controller;


import model.Person;

import java.io.FileNotFoundException;
import java.util.List;

public interface FileOperations{
    Person[] parseFile(String path, String delimiter) throws FileNotFoundException;
    List<String[]> readFile(String path, String delimiter) ;
    Person createNewUser(String[] userData, String delimiter);

}
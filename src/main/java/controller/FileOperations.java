package controller;


import model.Person;

import java.io.FileNotFoundException;
public interface FileOperations{
    Person[] parseFile(String path, String delimiter) throws FileNotFoundException;

}


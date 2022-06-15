package utils;

import model.Person;

import java.util.Comparator;

public class SortComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
       return o1.getBirthDate().substring(4).replaceAll("/","")
               .compareTo(o2.getBirthDate().substring(4)
               .replaceAll("/",""));
    }
}

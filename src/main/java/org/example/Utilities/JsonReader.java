package org.example.Utilities;

import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class JsonReader {

    public static void main(String[] args) throws FileNotFoundException {
        FileReader reader = new FileReader("D:\\Source\\Java\\FrameworkDesign\\src\\main\\resources\\TestData\\data.json");

        Gson gson = new Gson();
        Person person = gson.fromJson(reader, Person.class);

        System.out.println("First Name is " + person.getFirstName());
        System.out.println("First Name is " + person.getLastName());

        for(Address address : person.getAddress()){
            System.out.println("Street is " + address.getStreetNo());
            System.out.println("Flat Name is " + address.getFlatName());
            System.out.println("Colony Name is " + address.getColonyName());
        }


    }
}

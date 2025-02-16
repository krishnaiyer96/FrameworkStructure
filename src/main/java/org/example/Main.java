package org.example;

import org.example.Interface.Config;
import org.example.ObjectRepository.ObjectRepository;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello, World!");
        System.out.println(ObjectRepository.config.getUserName());
        System.out.println(ObjectRepository.config.getPassword());
        System.out.println(ObjectRepository.config.getUrl());
    }
}
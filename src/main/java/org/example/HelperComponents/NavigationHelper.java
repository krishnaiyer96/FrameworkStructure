package org.example.HelperComponents;

import org.example.ObjectRepository.ObjectRepository;

public class NavigationHelper {

    public static void navigateTo(String url){
        ObjectRepository.driver.get(url);
    }
}

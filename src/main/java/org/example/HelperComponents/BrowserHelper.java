package org.example.HelperComponents;

import org.example.ObjectRepository.ObjectRepository;
import org.openqa.selenium.WebDriver;

public class BrowserHelper {

    public static void goForward(){
        ObjectRepository.driver.navigate().forward();
    }

    public static void goBack(){
        ObjectRepository.driver.navigate().back();
    }
    public static void maximiseScreen(){
        ObjectRepository.driver.manage().window().maximize();
    }

    public static void minimiseScreen(){

    }
}

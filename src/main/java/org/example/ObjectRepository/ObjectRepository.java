package org.example.ObjectRepository;

import org.example.Configurations.AppConfigReader;
import org.example.Interface.Config;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class ObjectRepository {

    public static WebDriver driver;
    public static Config config = new AppConfigReader();
}




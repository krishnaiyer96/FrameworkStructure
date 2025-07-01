package org.example.ObjectRepository;

import org.example.Configurations.AppConfigReader;
import org.example.Interface.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class ObjectRepository {

    public static WebDriver driver;
    public static Config config = new AppConfigReader();

}




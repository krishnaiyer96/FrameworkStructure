package org.example.HelperComponents;

import org.example.ObjectRepository.ObjectRepository;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class AbstractComponents {


    public void waitForElementToAppear(By findBy) throws IOException {
        WebDriverWait wait = new WebDriverWait(ObjectRepository.driver, Duration.ofSeconds(Long.parseLong(ObjectRepository.config.getImplicitWaitTime())));
        wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
    }

}

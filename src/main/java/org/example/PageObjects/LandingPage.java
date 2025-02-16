package org.example.PageObjects;

import org.example.HelperComponents.AbstractComponents;
import org.example.ObjectRepository.ObjectRepository;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LandingPage extends AbstractComponents
{

    public LandingPage()
    {
        PageFactory.initElements(ObjectRepository.driver, this);
    }


    @FindBy(xpath = "//a[@href='/login']")
    WebElement logInLink;

    @FindBy(xpath = "//input[@placeholder='Email Address']")
    WebElement userNameField;

    @FindBy(xpath = "//input[@placeholder='Password']")
    WebElement passwordField;

    @FindBy(id = "login")
    WebElement logInButton;

    //ActionMethods

    public void loginIntoApplication(String userName, String password) throws InterruptedException {
        logInLink.click();
        Thread.sleep(2000);
        userNameField.sendKeys(userName);
        passwordField.sendKeys(password);
        logInButton.click();
        Thread.sleep(3000);
    }



}

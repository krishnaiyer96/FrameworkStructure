package org.example.PageObjects.ParaBankWebsite;

import org.example.HelperComponents.AbstractComponents;
import org.example.ObjectRepository.ObjectRepository;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ParaBankHomePage extends AbstractComponents {

    public ParaBankHomePage(){
        PageFactory.initElements(ObjectRepository.driver, this);
    }
    @FindBy(xpath = "//img[@title='ParaBank']")
    WebElement paraBankLogo;
    @FindBy(xpath = "//input[@name='username']")
    WebElement userNameTextBox;
    @FindBy(xpath = "//input[@name='password']")
    WebElement passwordTextBox;
    @FindBy(xpath = "//input[@value='Log In']")
    WebElement loginButton;
    @FindBy(xpath = "//a[normalize-space()='Forgot login info?']")
    WebElement forgotLogionLink;
    @FindBy(xpath = "//a[normalize-space()='Register']")
    WebElement registerLink;
    @FindBy(xpath = "//h1[@class='title']")
    WebElement errorTitle;
    @FindBy(xpath = "//h1[@class='title']")
    WebElement loginErrorWarningMsg;

    //ActionMethods

    public void loginWithNewUser(){


    }



}

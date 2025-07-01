package org.example.PageObjects;

import org.example.HelperComponents.AbstractComponents;
import org.example.ObjectRepository.ObjectRepository;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class ECommercePage extends AbstractComponents {

    WebDriver driver;

    public ECommercePage(){

        PageFactory.initElements(ObjectRepository.driver, this);
    }

    @FindBy(xpath = "//button[normalize-space()='shop now']")
    WebElement shopNowButton;

    @FindBy(xpath = "//button[@aria-label='Search']")
    WebElement searchIcon;

    @FindBy(id = "searchInput")
    WebElement searchTextField;



    //Action Methods
    By shopButton = By.xpath("//button[normalize-space()='shop now']");
    By searchField = By.id("searchInput");


    public void SearchforItem(String item) throws InterruptedException, IOException {
        waitForElementToAppear(shopButton);
        if(shopNowButton.isDisplayed()){
            System.out.println("Test Case is Successful");
        }
        else {
            System.out.println("Test Case is not successful");
        }
        searchIcon.click();
        waitForElementToAppear(searchField);
        searchTextField.sendKeys(item);
        searchTextField.sendKeys(Keys.ENTER);
        Thread.sleep(3000);




    }
}

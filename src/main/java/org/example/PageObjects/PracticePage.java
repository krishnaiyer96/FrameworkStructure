package org.example.PageObjects;

import org.example.ObjectRepository.ObjectRepository;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class PracticePage {



    public PracticePage(){
        PageFactory.initElements(ObjectRepository.driver, this);
    }

    @FindBy(xpath = "//a[@type='button']")
    WebElement practieMenu;

    @FindBy(xpath = "//a[normalize-space()='eCommerce Practice']")
    WebElement eCommerceSubMenu;

    @FindBy(id = "bmwradio")
    WebElement bmwRadioBtn;

    @FindBy(id = "benzradio")
    WebElement benzRadioBtn;

    @FindBy(id = "hondaradio")
    WebElement hondaRadioBtn;

    @FindBy(id = "bmwcheck")
    WebElement bmwCheckBox;

    @FindBy(id = "benzcheck")
    WebElement benzCheckBox;

    @FindBy(id = "hondacheck")
    WebElement hondaCheckBox;

    @FindBy(id = "carselect")
    WebElement carSelectDropDown;

    @FindBy(id = "ui-id-1")
    List<WebElement> autoSuggestList;

    @FindBy(id = "autosuggest")
    WebElement autoSuggestDropDown;


    //Action Methods

    public void NavigateToEcommerceScreen() throws InterruptedException {
        practieMenu.click();
        eCommerceSubMenu.click();
        Thread.sleep(2000);
        Set<String> windows = ObjectRepository.driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String parentWindow = it.next();
        String childWindow = it.next();
        ObjectRepository.driver.switchTo().window(childWindow);
    }

    public void checkAutoSuggestionFunctionality(String courseName) throws InterruptedException {
        autoSuggestDropDown.sendKeys("Auto");
        Thread.sleep(2000);
        for(WebElement options : autoSuggestList){
            if(options.getText().equalsIgnoreCase(courseName)){
                options.click();
                break;
            }
        }
    }
}

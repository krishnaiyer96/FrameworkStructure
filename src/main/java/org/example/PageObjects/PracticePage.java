package org.example.PageObjects;

import org.example.ObjectRepository.ObjectRepository;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

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

    @FindBy(id = "//ul[@id='ui-id-1']//a")
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
                String selectedOption = options.getText();
                System.out.println(selectedOption);
                options.click();
                break;
            }
        }
        Thread.sleep(3000);
    }

    public void checkRadioButtonSelection(String option) throws InterruptedException {
        switch (option){
            case "BMW":
                bmwRadioBtn.click();
                break;
            case "BENZ":
                benzRadioBtn.click();
                break;
            case "HONDA":
                hondaRadioBtn.click();
                break;
            default:
                System.out.println("Please enter valid option");

        }
        Thread.sleep(3000);
    }

    public void validateSelectDropDown(String car){
        Select option = new Select(carSelectDropDown);
        option.selectByValue(car);

    }
}

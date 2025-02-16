package TestCases;

import BaseFolder.BaseClass;
import org.example.HelperComponents.NavigationHelper;
import org.example.ObjectRepository.Obj;
import org.example.ObjectRepository.ObjectRepository;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class PracticeTest extends BaseClass {

 @Test
    public void checkAutoSuggesstion() throws IOException, InterruptedException {
     NavigationHelper.navigateTo(ObjectRepository.config.getUrl());
     Obj.practicePage().checkAutoSuggestionFunctionality("Cypress Automation");


 }
}

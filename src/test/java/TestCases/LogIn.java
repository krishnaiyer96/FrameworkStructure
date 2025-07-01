package TestCases;

import BaseFolder.BaseClass;
import com.sun.net.httpserver.Authenticator;
import org.example.HelperComponents.NavigationHelper;
import org.example.ObjectRepository.Obj;
import org.example.ObjectRepository.ObjectRepository;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.*;


import java.io.IOException;

public class LogIn extends BaseClass {

    @Test
    public void testLogin() throws InterruptedException, IOException {
        NavigationHelper.navigateTo(ObjectRepository.config.getUrl());
        Obj.landingPage().loginIntoApplication(ObjectRepository.config.getUserName(), ObjectRepository.config.getPassword());

    }
    @Test(dependsOnMethods = "validateECommerceScreen")
    public void validatePracticeScreen() throws InterruptedException, IOException {
        NavigationHelper.navigateTo(ObjectRepository.config.getUrl());
        Obj.landingPage().loginIntoApplication(ObjectRepository.config.getUserName(), ObjectRepository.config.getPassword());
        Obj.practicePage().NavigateToEcommerceScreen();

    }

    @Test(dependsOnMethods = "testLogin")
    public void validateECommerceScreen() throws InterruptedException, IOException {
        NavigationHelper.navigateTo(ObjectRepository.config.getUrl());
        Obj.landingPage().loginIntoApplication(ObjectRepository.config.getUserName(), ObjectRepository.config.getPassword());
        Obj.practicePage().NavigateToEcommerceScreen();
        Obj.eCommercePage().SearchforItem("Shirt");
    }
    
}

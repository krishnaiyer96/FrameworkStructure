package TestCases.ParaBankWebsite;

import BaseFolder.BaseClass;
import org.example.HelperComponents.BrowserHelper;
import org.example.HelperComponents.NavigationHelper;
import org.example.ObjectRepository.Obj;
import org.example.ObjectRepository.ObjectRepository;
import org.testng.annotations.Test;

import java.io.IOException;

public class CustomerSignIn  extends BaseClass {

    @Test
    public void checkForUserExistance() throws IOException {
        NavigationHelper.navigateTo(ObjectRepository.config.getParaBankUrl());
        System.out.println("The title of the Website is " + BrowserHelper.getTitleOfWindow());

    }
}

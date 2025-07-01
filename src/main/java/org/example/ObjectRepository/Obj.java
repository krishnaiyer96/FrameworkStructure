package org.example.ObjectRepository;

import org.example.PageObjects.ECommercePage;
import org.example.PageObjects.LandingPage;
import org.example.PageObjects.ParaBankWebsite.ParaBankHomePage;
import org.example.PageObjects.PracticePage;


import java.util.function.Supplier;

public class Obj {


    private static <T> T getPage(Supplier<? extends T> supp){
        return supp.get();

    }
    public static LandingPage landingPage(){
        return getPage(LandingPage::new);
    }
    public static PracticePage practicePage(){
        return getPage(PracticePage::new);
    }
    public static ECommercePage eCommercePage(){return getPage(ECommercePage::new);}
    public static ParaBankHomePage paraBankHomePage(){return getPage(ParaBankHomePage::new);}


}

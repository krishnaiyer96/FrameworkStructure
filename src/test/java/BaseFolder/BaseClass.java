package BaseFolder;

import io.opentelemetry.api.internal.Utils;
import org.apache.commons.io.FileUtils;
import org.example.Configurations.AppConfigReader;
import org.example.HelperComponents.BrowserHelper;
import org.example.ObjectRepository.ObjectRepository;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

public class BaseClass {


    @BeforeMethod(alwaysRun = true)
    public WebDriver initializeDriver() throws IOException {
        System.setProperty("webdriver.chrome.driver", "D:\\Source\\Java\\FrameworkDesign\\chromedriver.exe");
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("D:\\Source\\Java\\FrameworkDesign\\src\\main\\resources\\GlobalData.properties");
        prop.load(fis);
        String browserName = prop.getProperty("browser");

        if(browserName.equalsIgnoreCase("chrome")){
            ObjectRepository.driver = new ChromeDriver();
        }
        else if (browserName.equalsIgnoreCase("firefox")) {
            ObjectRepository.driver = new FirefoxDriver();
        }
        else if (browserName.equalsIgnoreCase("edge")) {
            ObjectRepository.driver = new EdgeDriver();
        }
        else {
            System.out.println("Enter Valid browser");
        }

        BrowserHelper.maximiseScreen();
        ObjectRepository.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(ObjectRepository.config.getImplicitWaitTime())));
        return ObjectRepository.driver;

    }
    public String getScreenShot(String testCaseName) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) ObjectRepository.driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File file = new File(System.getProperty("user.dir") + "\\Reports\\" + testCaseName + ".png");
        System.out.println(file);
        FileUtils.copyFile(source, file);
        return System.getProperty("user.dir") + "\\Reports\\" + testCaseName + ".png";
    }
//    public String getScreenShot() throws IOException {
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
//        String timestamp = dateFormat.format(new Date());
//        TakesScreenshot ts = (TakesScreenshot) ObjectRepository.driver;
//        File source = ts.getScreenshotAs(OutputType.FILE);
//        File file = new File(System.getProperty("user.dir") + "\\Reports\\" + timestamp + ".png");
//        System.out.println(file);
//        FileUtils.copyFile(source, file);
//        return System.getProperty("user.dir") + "\\Reports\\" + timestamp + ".png";
//
//    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        ObjectRepository.driver.close();
        ObjectRepository.driver.quit();
    }

}

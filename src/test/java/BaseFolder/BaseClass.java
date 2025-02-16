package BaseFolder;

import org.example.HelperComponents.BrowserHelper;
import org.example.ObjectRepository.ObjectRepository;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
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
        ObjectRepository.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return ObjectRepository.driver;

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        ObjectRepository.driver.close();
        ObjectRepository.driver.quit();
    }
}

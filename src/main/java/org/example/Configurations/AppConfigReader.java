package org.example.Configurations;

import org.example.Interface.Config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class AppConfigReader implements Config {

    public Properties propertiesFileReader() throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("D:\\Source\\Java\\FrameworkDesign\\src\\main\\resources\\GlobalData.properties");
        prop.load(fis);
        return prop;
    }

    @Override
    public String getUserName() throws IOException {
        return propertiesFileReader().getProperty(AppConfigKeys.userName);
    }

    @Override
    public String getPassword() throws IOException {
        return propertiesFileReader().getProperty(AppConfigKeys.password);
    }

    @Override
    public String getUrl() throws IOException {
        return propertiesFileReader().getProperty(AppConfigKeys.appUrl);
    }

    @Override
    public String getImplicitWaitTime() throws IOException {
        return propertiesFileReader().getProperty(String.valueOf(AppConfigKeys.implicitWaitTime));
    }
    @Override
    public String getParaBankUrl() throws IOException {
        return propertiesFileReader().getProperty(String.valueOf(AppConfigKeys.paraBankUrl));
    }
}

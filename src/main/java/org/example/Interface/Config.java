package org.example.Interface;

import java.io.IOException;

public interface Config {

    public String getUserName() throws IOException;
    public String getPassword() throws IOException;
    public String getUrl() throws IOException;
    public String getImplicitWaitTime() throws IOException;
    public String getParaBankUrl() throws IOException;
}

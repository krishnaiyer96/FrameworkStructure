package org.example.Interface;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface Config {

    public String getUserName() throws IOException;
    public String getPassword() throws IOException;
    public String getUrl() throws IOException;
}

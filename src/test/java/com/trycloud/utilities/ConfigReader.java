package com.trycloud.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    /** A Utility class that load the keyvalue pair inside config.properties file
     * into Properties object and provide single method called
     * read to get the value out of the properties file we created.
     */

    //declare Properties class at class level so that it is accessible in the static method
    private static Properties properties=new Properties();

    //we want to load the file once, so we can use static clock
    static {
        FileInputStream in = null;
        try {
            in = new FileInputStream("configuration.properties");
            properties.load(in);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String read (String key){
        return properties.getProperty(key);
    }


}

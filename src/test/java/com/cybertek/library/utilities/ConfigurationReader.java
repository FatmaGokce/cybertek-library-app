package com.cybertek.library.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    //#1- Create properties object
    private static Properties properties = new Properties();

    //static block
    static {

        try {
            //#2- Load the file into FileInputStream
            FileInputStream file = new FileInputStream("configuration.properties");

            //#3- load properties object with file (configuration.properties)
            properties.load(file);

            //close file
            file.close();

        } catch (IOException e) {

            System.out.println("File not found in Configuration Properties.");

        }

    }

    //USE THE ABOVE CREATED LOGIC TO CREATE A RE-USABLE STATIC METHOD
    public static String getProperty(String keyWord) {
        return properties.getProperty(keyWord);
    }

}

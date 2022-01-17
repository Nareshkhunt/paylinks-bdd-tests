package com.paylinks.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class CommonUtils {
    private static Properties prop = new Properties();
    private static FileInputStream fis;
    public static String VALID_USER;
    public static String VALID_USER_PSW;
    public static String ENV_URL;
    public static String BROWSER_INSTANCE;

    public static void loadTestDataProp(String testDataPropertyFile) {
        try {
            fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/properties/" + testDataPropertyFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }

        VALID_USER = prop.getProperty("valid.user");
        VALID_USER_PSW = prop.getProperty("valid.user.psw");
        ENV_URL = prop.getProperty("env.url");
        BROWSER_INSTANCE = prop.getProperty("browser.instance");

    }
}

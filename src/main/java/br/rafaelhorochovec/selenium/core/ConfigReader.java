package br.rafaelhorochovec.selenium.core;

public class ConfigReader {
    private static String browserType = null;

    public static void setBrowserType(String browser) {
        browserType = browser;
    }

    public static String getBrowserType() {
        if (browserType != null)
            return browserType;
        else
            throw new RuntimeException("browser not specified in the testng.xml");
    }
}

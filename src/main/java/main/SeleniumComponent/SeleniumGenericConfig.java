package main.SeleniumComponent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumGenericConfig {

    private final String operatingSystem = System.getProperty("os.name");
    private final WebDriver webDriver;

    public SeleniumGenericConfig() {
        if(getOperatingSystem().equalsIgnoreCase("Windows 10")) {
            System.setProperty("webdriver.chrome.driver", "src\\main\\java\\main\\WebDriver\\chromedriver.exe");
        } else {
            System.setProperty("webdriver.chrome.driver", "src/main/java/main/WebDriver/chromedriver");
        }

        this.webDriver = new ChromeDriver();
    }

    public String getOperatingSystem() {
        return this.operatingSystem;
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }
}

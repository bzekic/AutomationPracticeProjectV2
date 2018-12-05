package AutomationPracticeProject.Selenium_Config;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class SeleniumProperties {
    private String chromeDriverPath;
    private String geckoDriverPath;
    private String edgeDriverPath;
    private Long implicitWaitTime;
    private String user_name = System.getProperty("user.name");

    public SeleniumProperties(){
        Properties seleniumProperties = new Properties();
        try {
            seleniumProperties.load(new FileReader("C:\\Users\\"+user_name+"\\engineering18\\VersionTwoAutomationPracticeProject\\src\\test\\java\\AutomationPracticeProject\\Selenium_Config\\selenium_driver.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        chromeDriverPath = seleniumProperties.getProperty("chrome_driver_path");
        geckoDriverPath = seleniumProperties.getProperty("gecko_driver_path");
        edgeDriverPath = seleniumProperties.getProperty("edge_driver_path");
        implicitWaitTime = Long.parseLong(seleniumProperties.getProperty("implicit_wait_time"));
    }

    public String getChromeDriverPath() {
        return chromeDriverPath;
    }
    public String getGeckoDriverPath() {
        return geckoDriverPath;
    }
    public String getEdgeDriverPath(){
        return edgeDriverPath;
    }
    public Long getImplicitWaitTime() {
        return implicitWaitTime;
    }
}
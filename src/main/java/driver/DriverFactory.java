package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

import java.util.Locale;

public class DriverFactory {

  private String browser = System.getProperty("browser", "chrome").toLowerCase(Locale.ROOT);

  public WebDriver getBrowserDriver() {
    switch (browser) {
      case "chrome":
        IDriver chromeDriver = new ChromeWebDriver();
        return chromeDriver.getDriver();
      case "firefox":
        IDriver firefoxDriver = new FirefoxWebDriver();
        return firefoxDriver.getDriver();
      case "opera":
        IDriver operaDriver = new OperaWebDriver();
        return operaDriver.getDriver();
      default:
        return null;
    }
  }
}

package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverListener;

import java.util.Locale;

public class DriverFactory {

  private String browser = System.getProperty("browser").toLowerCase(Locale.ROOT);


  WebDriver getBrowser() {
   switch (browser){
     case "chrome":
       IDriver chromeDriver = new ChromeWebDriver();
       return chromeDriver.getDriver();
     case "firefox":
       IDriver firefoxDriver = new FirefoxWebDriver();
       return firefoxDriver.getDriver();
     case "opera":
       IDriver operaDriver = new OperaWebDriver();
       return operaDriver.getDriver();
   }
    return null;
  }
}

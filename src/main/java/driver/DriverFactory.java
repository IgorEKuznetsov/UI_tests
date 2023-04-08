package driver;

import exceptions.DriverTypeNotSupported;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.Locale;

public class DriverFactory {

  private String browserType = System.getProperty("browser", "chrome").toLowerCase(Locale.ROOT);

  public EventFiringWebDriver getBrowserDriver() {
    switch (this.browserType) {
      case "chrome":
        return new EventFiringWebDriver(new ChromeWebDriver().getDriver());
      case "firefox":
        return new EventFiringWebDriver(new FirefoxWebDriver().getDriver());
      case "opera":
        return new EventFiringWebDriver(new OperaWebDriver().getDriver());
      default:
        try {
          throw new DriverTypeNotSupported(this.browserType);
        } catch (DriverTypeNotSupported e) {
          e.printStackTrace();
        }
        return null;
    }
  }
}

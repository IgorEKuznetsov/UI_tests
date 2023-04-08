package driver;

import io.github.bonigarcia.wdm.WebDriverManager;

import listeners.CustomListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class ChromeWebDriver implements IDriver {
  @Override
  public WebDriver getDriver() {
    ChromeOptions chromeOptions = new ChromeOptions();
    chromeOptions.addArguments("--no-sandbox");
    chromeOptions.addArguments("--ignore-certificate-errors");

    chromeOptions.addArguments("--remote-allow-origins=*");
    chromeOptions.addArguments("--disable-notifications");

    WebDriverManager.chromedriver().setup();

    return new ChromeDriver(chromeOptions);
  }
}

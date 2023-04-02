package driver;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class ChromeWebDriver implements IDriver {
  @Override
  public WebDriver getDriver() {
    ChromeOptions chromeOptions = new ChromeOptions();
    chromeOptions.addArguments("--no-sandbox");
    chromeOptions.addArguments("--ignore-certificate-errors");
    chromeOptions.addArguments("--window-size=1920x1080");
    chromeOptions.addArguments("--remote-allow-origins=*");

    WebDriverManager.chromedriver().setup();

    return new ChromeDriver(chromeOptions);
  }
}

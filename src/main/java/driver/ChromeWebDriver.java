package driver;

import io.github.bonigarcia.wdm.WebDriverManager;

import listeners.CustomListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;
import java.util.logging.Level;


public class ChromeWebDriver implements IDriver {
  @Override
  public WebDriver getDriver() throws MalformedURLException {
    ChromeOptions chromeOptions = new ChromeOptions();
    chromeOptions.addArguments("--no-sandbox");
    chromeOptions.addArguments("--ignore-certificate-errors");
    chromeOptions.addArguments("--remote-allow-origins=*");
    chromeOptions.addArguments("--disable-notifications");
    chromeOptions.addArguments("--start-maximized");

    chromeOptions.addArguments("--enable-extensions");
    chromeOptions.addArguments("--homepage=about:blank");
    chromeOptions.addArguments("--no-first-run");


    //DesiredCapabilities capabilities = new DesiredCapabilities();

    chromeOptions.setCapability("browserName", System.getProperty("browser", "chrome"));
    chromeOptions.setCapability("browserVersion", System.getProperty("browser.version", "115.0"));
    chromeOptions.setCapability("enableVNC", true);
    chromeOptions.setCapability("sessionTimeout", "10m");
    //chromeOptions.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, "eager");
    chromeOptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

    LoggingPreferences logPrefs = new LoggingPreferences();
    logPrefs.enable(LogType.PERFORMANCE, Level.INFO);
    chromeOptions.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);

    //    WebDriverManager.chromedriver().setup();
    //
    //    return new ChromeDriver(chromeOptions);

    return new RemoteWebDriver(
        URI.create("http://192.168.56.1:24/wd/hub").toURL(),
        chromeOptions
    );
  }

}

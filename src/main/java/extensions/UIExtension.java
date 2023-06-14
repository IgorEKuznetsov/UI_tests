package extensions;

import listeners.CustomListener;
import org.junit.jupiter.api.extension.*;

import org.openqa.selenium.support.events.EventFiringWebDriver;
import java.lang.reflect.Field;

import driver.DriverFactory;
import pages.MainPage;


public class UIExtension implements BeforeEachCallback, AfterEachCallback {

  private EventFiringWebDriver driver = null;


  @Override
  public void beforeEach(ExtensionContext extensionContext) throws Exception {
    driver = new DriverFactory().getBrowserDriver();
    driver.register(new CustomListener());

    Class<?> testClass = extensionContext.getTestClass().get();
    Field field = testClass.getDeclaredField("driver");

    try {
      field.setAccessible(true);
      field.set(extensionContext.getTestInstance().get(), driver);
    } catch (IllegalAccessException e) {
      throw new Error(String.format("Could not access or set webdriver in field: %s - is this field public?", field), e);
    }

  }


  @Override
  public void afterEach(ExtensionContext extensionContext) {
    if (driver != null) {
      driver.close();
      driver.quit();
    }
  }


}

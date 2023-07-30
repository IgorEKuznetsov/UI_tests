package extensions;

import annotations.Driver;
import io.qameta.allure.Allure;
import listeners.CustomListener;
import org.junit.jupiter.api.extension.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.ByteArrayInputStream;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Arrays;
import driver.DriverFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;


public class UIExtension implements BeforeEachCallback, AfterEachCallback, AfterTestExecutionCallback {

  private EventFiringWebDriver driver = null;


  @Override
  public void beforeEach(ExtensionContext extensionContext) throws Exception {
    driver = new DriverFactory().getBrowserDriver();
    driver.register(new CustomListener());

    Class<?> testClass = extensionContext.getTestClass().get();
    Field[] fields = testClass.getDeclaredFields();
    Field field =
        Arrays.stream(fields).filter(f -> f.isAnnotationPresent(Driver.class)).findFirst().get();

    AccessController.doPrivileged((PrivilegedAction<Void>)
        () -> {
          try {
            field.setAccessible(true);
            field.set(extensionContext.getTestInstance().get(), driver);
          } catch (IllegalAccessException e) {
            throw new Error(String.format("Could not access or set webdriver in field: %s - is this field public?", field), e);
          }
          return null;
        }
    );

  }

  @Override
  public void afterTestExecution(ExtensionContext extensionContext) throws Exception {
    boolean testResult = extensionContext.getExecutionException().isPresent();
    if (testResult) {
      Allure.addAttachment("Failed screenshot", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
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

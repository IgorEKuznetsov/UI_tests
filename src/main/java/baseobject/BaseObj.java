package baseobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public abstract class BaseObj<T> {

  protected WebDriver driver;

  public BaseObj(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
    driver.manage().window().maximize();
  }
}

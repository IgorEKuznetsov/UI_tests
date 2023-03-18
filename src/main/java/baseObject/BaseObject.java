package baseObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public abstract class BaseObject<T> {

  protected WebDriver driver;
  protected Actions actions;

  public BaseObject(WebDriver driver) {
    this.driver = driver;
    this.actions = new Actions(driver);
  }
}

package pages;

import baseObject.BaseObject;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;

public abstract class BasePage<T> extends BaseObject<T> {
  public BasePage(WebDriver driver) {
    super(driver);
  }

  public T open() {
    driver.get(getBaseUrl() + getPath());
    return (T) this;
  }

  private String getPath() {
    return null;
  }

  private String getBaseUrl() {
    return StringUtils.stripEnd(System.getProperty("driver.host"), "/");
  }

}

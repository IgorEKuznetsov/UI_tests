package pages;

import annotations.Path;
import baseobject.BaseObj;
import data.CoursesData;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import java.lang.annotation.Annotation;

public abstract class BasePageAbs<T> extends BaseObj<T> {
  public BasePageAbs(WebDriver driver) {
    super(driver);
  }

  public T open() {
    driver.get(getBaseUrl() + getPath());
    return (T) this;
  }

  private String getPath() {
    Class<? extends BasePageAbs> clazz = getClass();
    Annotation annotation = clazz.getAnnotation(Path.class);
    if (annotation != null) {
      return ((Path) annotation).value();
    }
    return "";
  }

  private String getBaseUrl() {
    return StringUtils.stripEnd(System.getProperty("driver.host"), "/");
  }

  private String headerLocator = "//div[contains(text(), '%s')]";

  public T headerIsEqualTo(CoursesData coursesData) {
    String locator = String.format(headerLocator, coursesData.getName());
    Assertions.assertEquals(coursesData.getName(), driver.findElement(By.xpath(locator)).getText());
    return (T) this;
  }


}

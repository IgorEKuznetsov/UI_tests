package pages;

import annotations.Path;
import annotations.UrlTemplate;
import annotations.Urls;
import baseobject.BaseObj;
import data.CoursesData;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.lang.annotation.Annotation;

public abstract class BasePageAbs<T> extends BaseObj<T> {
  public BasePageAbs(WebDriver driver) {
    super(driver);
  }

  public T open() {
    driver.get(getBaseUrl() + getPath());
    return (T) this;
  }

  public T open(String categoryName) {
    driver.get(getBaseUrl() + getPathFromTemplate(categoryName));
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

  private String getPathFromTemplate(String categoryName) {
    Class<? extends BasePageAbs> clazz = getClass();
    Urls urls = clazz.getAnnotation(Urls.class);
    UrlTemplate urlTemplate = urls.value();
    if (urlTemplate != null) {
      String category = String.format(urlTemplate.value(), categoryName);
      log.info("Category: " + category);
      return getPath() + category;
    }
    return "";
  }

  private String getBaseUrl() {
    return StringUtils.stripEnd(System.getProperty("driver.host"), "/");
  }

  private String courseLocator = "//div[contains(text(), '%s')]";
  private String specializationLocator = "//h1[contains(text(), '%s')]";


  public T headerIsEqualTo(CoursesData coursesData, Boolean isCourseLocator) {
    String locator = "";
    if (isCourseLocator) {
      locator = String.format(courseLocator, coursesData.getName());
    } else locator = String.format(specializationLocator, coursesData.getName());
    waiter.elementShouldBeVisible(driver.findElements(By.xpath(locator)).get(0));
    Assertions.assertEquals(coursesData.getName(), driver.findElements(By.xpath(locator)).get(0).getText());
    return (T) this;
  }

  public void deleteCookiesWebElement(WebDriver driver, WebElement element) {
    if (element.getSize() != null) {
      ((JavascriptExecutor) driver).executeScript("arguments[0].style.display='none'", element);
      log.info("Cookie element was closed");
    } else log.info("Cookie element not visible");

  }


}

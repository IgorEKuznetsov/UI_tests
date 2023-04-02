package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CoursePage extends BasePageAbs<CoursePage> {
  private String date;

  public CoursePage(WebDriver driver) {
    super(driver);
  }

  public CoursePage(WebDriver driver, String date) {
    super(driver);
    this.date = date;
  }

  private String startCourseLocator = "//*[contains(text(), '%s')]";

  public void checkDate() {
    String locator = String.format(startCourseLocator, this.date);
    System.out.println("Дата старта: " + this.date);
    Assertions.assertEquals(true, driver.findElements(By.xpath(locator)).size() > 0);
  }
}

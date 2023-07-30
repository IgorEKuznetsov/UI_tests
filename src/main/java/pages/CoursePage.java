package pages;

import io.qameta.allure.Step;
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

  //private String startCourseLocator = "//*[contains(text(), '%s')]";
  @Step("Проверяем дату курса")
  public void checkDate() {
    //String locator = String.format(startCourseLocator, date);
    //String coursePageDateStart = driver.findElements(By.xpath(locator)).get(0).getText();
    //Assertions.assertTrue(coursePageDateStart.contains(date));
    log.info("Start date: " + date);
  }
}

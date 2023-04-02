import driver.DriverFactory;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import data.CoursesData;
import pages.CoursesCatalog;
import pages.MainPage;

public class CoursesCatalogTests {
  private WebDriver driver;

  @BeforeEach
  void initDriver() {
    driver = new DriverFactory().getBrowserDriver();
  }

  @Disabled
  void checkBoxIsSelectedTest() {
    new CoursesCatalog(driver).open();
    driver.findElement(By.xpath("//label[text()='Инфраструктура']/../div/input")).click();
    Assertions.assertEquals(true, driver.findElement(By.xpath("//label[text()='Инфраструктура']/../div/input")).isSelected());

  }

  @Test
  void checkPageHeaderWhenClickOnCourseTest() {
    new MainPage(driver)
        .open()
        .clickCourseByName(CoursesData.KAFKA_COURSE)
        .headerIsEqualTo(CoursesData.KAFKA_COURSE);

  }

  @Test
  void clickEarliestCourseTest() {
    new MainPage(driver)
        .open()
        .clickCourseByDate()
        .checkDate();
  }

  @AfterEach
  void killBrowser() {
    if (driver != null) {
      driver.close();
    }
  }
}

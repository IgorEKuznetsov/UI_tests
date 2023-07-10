package ui.courses.test;

import annotations.Driver;
import data.CoursesData;
import extensions.UIExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import pages.MainPage;

@ExtendWith(UIExtension.class)
public class SelectCourseByNameTests {

  @Driver
  public WebDriver driver;

  @Test
  void checkPageHeaderWhenClickOnCourseTest() {
    new MainPage(driver)
        .open()
        .clickCourseByName(CoursesData.SYSANALITIC)
        .headerIsEqualTo(CoursesData.SYSANALITIC, true);
  }
}

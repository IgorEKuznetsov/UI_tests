package ui.courses.test;

import annotations.Driver;
import data.CoursesData;
import extensions.UIExtension;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import pages.MainPage;

@ExtendWith(UIExtension.class)
public class SelectCourseByNameTests {

  @Driver
  public WebDriver driver;

  @Test
  @DisplayName("Поиск курса по имени")
  void checkPageHeaderWhenClickOnCourseTest() {
    new MainPage(driver)
        .open()
        .clickCourseByName(CoursesData.SYSANALITIC)
        .headerIsEqualTo(CoursesData.SYSANALITIC, true);
  }
}

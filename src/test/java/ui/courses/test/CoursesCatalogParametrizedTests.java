package ui.courses.test;

import annotations.Driver;
import extensions.UIExtension;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import data.CoursesData;
import org.openqa.selenium.WebDriver;
import pages.MainPage;

@ExtendWith(UIExtension.class)
public class CoursesCatalogParametrizedTests {
  @Driver
  public WebDriver driver;

  @ParameterizedTest
  @DisplayName("Проверка заголовков курсов")
  @MethodSource("data.DataProvider#courseNamesProvider")
  void checkPageHeaderWhenClickOnCourseDataTest(CoursesData coursesData) {
    new MainPage(driver)
        .open()
        .clickCourseByName(coursesData)
        .headerIsEqualTo(coursesData, false);
  }

}

package ui.courses.test;

import annotations.Driver;
import extensions.UIExtension;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import data.CoursesData;
import org.openqa.selenium.WebDriver;
import pages.CoursesCatalog;
import pages.MainPage;

@ExtendWith(UIExtension.class)
public class CoursesCatalogParametrizedTests {
  @Driver
  public WebDriver driver;

  @ParameterizedTest
  @MethodSource("data.DataProvider#courseNamesProvider")
  void checkPageHeaderWhenClickOnCourseDataTest(CoursesData coursesData) {
    new MainPage(driver)
        .open()
        .clickCourseByName(coursesData)
        .headerIsEqualTo(coursesData, false);
  }

}

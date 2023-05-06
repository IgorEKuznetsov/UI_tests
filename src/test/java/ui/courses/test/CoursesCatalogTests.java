package ui.courses.test;

import annotations.Driver;
import extensions.UIExtension;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import data.CoursesData;
import org.openqa.selenium.WebDriver;
import pages.CoursesCatalog;
import pages.MainPage;

@ExtendWith(UIExtension.class)
public class CoursesCatalogTests {
  @Driver
  public WebDriver driver;

  @Test
  void checkPageHeaderWhenClickOnCourseTest() {
    new MainPage(driver)
        .open()
        .clickCourseByName(CoursesData.KAFKA_COURSE)
        .headerIsEqualTo(CoursesData.KAFKA_COURSE, true);
  }

  @Test
  void checkDateWhenClickEarliestCourseTest() {
    new MainPage(driver)
        .open()
        .clickCourseByDate(true)
        .checkDate();
  }

  @ParameterizedTest
  @DisplayName("Сlick on three specializations")
  @MethodSource("data.DataProvider#courseNamesProvider")
  void checkPageHeaderWhenClickOnCourseDataTest(CoursesData coursesData) {
    new MainPage(driver)
        .open()
        .clickCourseByName(coursesData)
        .headerIsEqualTo(coursesData, false);
  }

  @Test
  void checkBoxIsSelectedTest() {
    new CoursesCatalog(driver).open("programming");
  }

}

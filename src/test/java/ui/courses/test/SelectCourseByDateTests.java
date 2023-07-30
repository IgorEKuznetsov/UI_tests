package ui.courses.test;

import annotations.Driver;
import extensions.UIExtension;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import pages.MainPage;

@ExtendWith(UIExtension.class)
public class SelectCourseByDateTests {

  @Driver
  public WebDriver driver;

  @Test
  @DisplayName("Поиск курса по дате старта")
  void checkDateWhenClickEarliestCourseTest() {
    new MainPage(driver)
        .open()
        .clickCourseByDate(true)
        .checkDate();
  }
}

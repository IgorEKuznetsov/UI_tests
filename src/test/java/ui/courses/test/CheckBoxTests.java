package ui.courses.test;

import annotations.Driver;
import extensions.UIExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import pages.CoursesCatalog;

@ExtendWith(UIExtension.class)
public class CheckBoxTests {

  @Driver
  public WebDriver driver;

  @Test
  void checkBoxIsSelectedTest() {
    new CoursesCatalog(driver).open("programming");
  }
}

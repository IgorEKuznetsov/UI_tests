package pages;

import annotations.Path;
import org.openqa.selenium.WebDriver;
@Path("/catalog/courses?categories=programming")
public class CoursesCatalog extends BasePageAbs<CoursesCatalog> {
  public CoursesCatalog(WebDriver driver) {
    super(driver);
  }

}

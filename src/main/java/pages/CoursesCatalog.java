package pages;

import annotations.Path;
import annotations.UrlTemplate;
import annotations.Urls;
import org.openqa.selenium.WebDriver;
@Path("/catalog/courses")
@Urls(
    @UrlTemplate(name = "categories", value = "?categories=%s")
)
public class CoursesCatalog extends BasePageAbs<CoursesCatalog> {
  public CoursesCatalog(WebDriver driver) {
    super(driver);
  }

}

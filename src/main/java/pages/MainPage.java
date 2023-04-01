package pages;

import annotations.Path;
import data.CoursesData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


@Path("/")
public class MainPage extends BasePageAbs<MainPage> {

  public MainPage(WebDriver driver) {
    super(driver);
  }

  private String courseNameLocator = "//div[contains(text(), '%s')]";

  @FindBy(css = ".lessons__new-item-start")
  private List<WebElement> startPopularAndRecommendationCourseSelector;
  //css = ".container-padding-bottom div[class=lessons__new-item-time]"
  @FindBy(css = ".lessons__new-item-bottom")
  private List<WebElement> startSpecialCourseSelector;


  public CoursePage clickCourseByName(CoursesData coursesData) {
    String locator = String.format(courseNameLocator, coursesData.getName());
    driver.findElements(By.xpath(locator)).get(0).click();
    return new CoursePage(driver);
  }

  public CoursePage clickCourseByDate() {
    SimpleDateFormat formatIn = new SimpleDateFormat("d MMMM", Locale.ROOT);
    Pattern searchMonthPattern = Pattern.compile("\\d{1,2}");

    String theEarliestCourse = startPopularAndRecommendationCourseSelector.stream()
        .map(el -> el.getText())
        .map(text -> text.replaceAll("С\\s", ""))
        .map(text -> text.replaceAll("\\D{3,10}", getMonth(text)))
        .map(text -> {
          try {
            return formatIn.parse(text);
          } catch (ParseException e) {
            throw new RuntimeException(e);
          }
        })
        .sorted()
        .map(date -> formatIn.format(date))
        .collect(Collectors.toList()).get(0);


    List<String> specialCourseDates=startSpecialCourseSelector.stream()
        .filter(el->searchMonthPattern.matcher(el.getText()).find())
        .map(x->x.getText())
        .collect(Collectors.toList());


    List<String> specialCourseDates1 = startSpecialCourseSelector.stream()
        .filter(el->searchMonthPattern.matcher(el.getText()).find())
        .map(el->el.getText().replaceAll("^(?!(марта|апреля)).$", ""))
        .collect(Collectors.toList());

    System.out.println("Самый ранний курс стартует: " + theEarliestCourse);
    System.out.println(specialCourseDates);
    System.out.println(specialCourseDates1);

    return new CoursePage(driver);
  }

  public String getMonth(String text) {
    switch (text.replaceAll("\\d{1,2}\\s", "")) {
      case "марта":
        return " March";
      case "апреля":
        return " April";
      default:
        return null;
    }
  }
}

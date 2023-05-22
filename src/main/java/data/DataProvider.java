package data;

import org.junit.jupiter.params.provider.Arguments;
import java.util.stream.Stream;

public class DataProvider {
  static Stream<Arguments> courseNamesProvider() {
    return Stream.of(
        Arguments.of(CoursesData.MACHINE_LEARNING),
        Arguments.of(CoursesData.IOS)
    );
  }
}

package data;

public enum CoursesData {

  KAFKA_COURSE("Apache Kafka"),
  BI_ANALITIC("BI-аналитика");

  private String name;

  CoursesData(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}

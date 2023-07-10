package data;



public enum CoursesData {

  KAFKA_COURSE("Apache Kafka"),
  JAVA_DEVELOPER("Специализация Java-разработчик"),
  RECOMMENDER_SYSTEMS("Рекомендательные системы"),
  DEV_REL("DevRel"),
  DEVELOPER_RELATIONS("Developer Relations"),
  MACHINE_LEARNING("Machine Learning"),
  IOS("iOS Developer"),
  SYSANALITIC("Системный аналитик. Team Lead");




  private String name;

  CoursesData(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

}

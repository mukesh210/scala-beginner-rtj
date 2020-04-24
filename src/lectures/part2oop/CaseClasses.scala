package lectures.part2oop

object CaseClasses extends App {

  case class Person(name: String, age: Int)

  // 1. Class parameters are class fields
  val mukesh = new Person("Mukesh", 25)
  println(s"${mukesh.name} - ${mukesh.age}")

  // 2. sensible toString method
  println(s"ToString: ${mukesh}")

  // 3. Equals and Hashcode are implemented by default
  val mukesh2 = new Person("Mukesh", 25)
  println(s"Equal check: ${mukesh == mukesh2}")

  // 4. Case classes have handy copy method
  val mukesh3 = mukesh.copy(age=26)
  println(s"mukesh3: ${mukesh3}")

  // 5. Case classes have companion object
  val mukesh4 = Person("Mukesh", 25)
  println(s"Companion object: ${mukesh4}")

  // 6. Case classes are Serializable
  // Akka

  // 7. Case classes have extractors pattern => Case classes can be used in PATTERN MATCHING

  // CASE objects are similar to Scala Objects. Main difference are that Case Objects are Serializable and have
  // default Hashcode and toString implementation
  case object India {
    def name: String = "INDIA"
  }

  // CASE classes parameters are IMMUTABLE
  //
}

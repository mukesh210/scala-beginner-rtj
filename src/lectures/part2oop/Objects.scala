package lectures.part2oop

object Objects extends App {
  // IN JAVA, WE HAVE STATIC KEYWORD TO DEFINE FIELDS AT CLASS LEVEL. THIS FUNCTIONALITY IS NOT AVAILABLE IN SCALA
  // SCALA DOES NOT HAVE CLASS-LEVEL FUNCTIONALITY("STATIC")

  // STATIC equivalent in SCALA is OBJECTS

  // to use class level defs in Scala, use objects
  object Person {
    // class level fields and methods
    val N_EYES = 2

    def canFly: Boolean = false

    // FACTORY METHOD
    def apply(mother: Person, father: Person) = new Person("Bobby")
  }

  class Person(name: String) {
    // instance level fields and methods
  }
  // COMPANIONS

  println(Person.N_EYES)
  println(Person.canFly)

  // Scala objects = SINGLETON instance
  val mary = new Person("Mary")
  val john = new Person("John")
  println(mary == john)

  val bobby = Person(mary, john)

}

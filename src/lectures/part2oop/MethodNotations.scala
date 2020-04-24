package lectures.part2oop

object MethodNotations extends App {
  class Person(val name: String, favouriteMovie: String, val age: Int = 20) {
    def likes(movie: String): Boolean = movie == favouriteMovie

    def +(person: Person): String = s"${this.name} hangouts with ${person.name}"

    def +(additionalName: String): Person = new Person(s"${name} (${additionalName})", favouriteMovie)

    def unary_+ : Person = new Person(name, favouriteMovie, age + 1)

    def unary_! : String = s"${name} says: What the heck"

    def isAlive: Boolean = true

    def learns(tech: String): String = s"${name} learns ${tech}"

    def leansScala(): String = learns("Scala")

    def apply(): String = s"Hi... My name is ${name} and i like ${favouriteMovie}"

    def apply(num: Int): String = s"${name} watched ${favouriteMovie} ${num} times"
  }

  val mary = new Person("Mary", "Inception")

  // Equivalent
  println(mary.likes("Inception"))
  println(mary likes "Inception") // Infix notation --- methods with single parameter
  // syntactic sugar --- natural way of expressing

  // "operators" in Scala
  val tom = new Person("Tom", "Fight club")

  println(mary + tom)

  // ALL OPERATORS ARE METHODS
  // Akka actors have ? !

  // prefix notation --- syntactic sugar
  val x = -1
  val x1 = 1.unary_-
  // unary_ works only with +, -, ~, !

  println(!tom)
  println(tom.unary_!)

  // Postfix notation - Syntactic Sugar
  println(mary.isAlive)
  println(mary isAlive)

  // apply
  println(mary.apply()) // equivalent to
  println(mary())

  val maryAdd = mary + "The Rockstar"
  println(s"MaryAdd Name: ${maryAdd.name}")

  println(s"Mary Previous Age: ${mary.age}")
  val newMary = +mary
  println(s"Mary new Age: ${newMary.age}")

  println("Learning::")
  println(mary leansScala)

  println(mary(45))
}

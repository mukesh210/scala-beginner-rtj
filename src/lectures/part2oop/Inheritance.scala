package lectures.part2oop

object Inheritance extends App {

  // Single class inheritance
  sealed class Animal {
    val creatureType: String = "Wild"
    protected def eat: Unit = println("nomnom")
    def animalSpecific: String = "Animal Class"
  }

  class Cat extends Animal {
    def crunch = {
      this.eat
      println("crunch crunch")
    }
  }

  val cat = new Cat
  cat.crunch

  // Constructor
  class Person(name: String, age: Int) {
    // Auxiliary constructor
    def this(name: String) = this(name, 0)
  }
  class Adult(name: String, age: Int, idCard: String) extends Person(name)

  // Overiding
  class Dog extends Animal {
    override val creatureType: String = "Domestic"
    override def eat: Unit = {
      super.eat
      println("Dog is Eating...")
    }
    def dogSpecific: String = "Dog Specific"
  }

  val dog = new Dog
  dog.eat
  println(dog.creatureType)

  val a1: Dog = new Dog
  println(a1.dogSpecific)

  // Preventing overrides
  // 1. make method final --- this prevents it to be overriden
  // 2. make class final --- this prevents class to be extended
  // 3. make class sealed --- class can be extended only in this file
}

package lectures.part2oop

object AbstractDataTypes extends App {

  // Abstract Class
  abstract class Animal {
    val creatureType: String
    def eat: Unit
  }

  class Dog extends Animal {
    override val creatureType: String = "Domestic"

    override def eat: Unit = println("Dog is Eating...")
  }

  trait Carnivore {
    def eat(animal: Animal): Unit
  }

  trait herbivore

  class Crocodile extends Animal with Carnivore with herbivore {
    override val creatureType: String = "croc"

    override def eat: Unit = "eating..."

    override def eat(animal: Animal): Unit = s"I am eating ${animal.creatureType}"
  }

  val dog = new Dog
  dog.eat

  // TRAITS vs ABSTRACT CLASSES
  // 1. They both can have abstract as well as non-abstract fields/methods
  // 2. traits can not have constructor parameter
  // 3. multiple traits may be inherited whereas only one abstract class can be inherited
  // 4. traits describe behaviour whereas abstract class describes Thing
}

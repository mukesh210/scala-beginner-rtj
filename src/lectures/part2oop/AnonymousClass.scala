package lectures.part2oop

object AnonymousClass extends App {

  abstract class Animal {
    def eat: Unit
  }

  val funnyAnimal = new Animal {
    override def eat: Unit = println("FunnyAnimal Eating...")
  }
/*
  is equivalent to
  class AnimalAnom extends  Animal {
    override def eat: Unit = println("FunnyAnimal Eating...")
  }
  val funnyAnimal = new AnimalAnom
*/

  funnyAnimal.eat

  class Person(name: String) {
    def getName: String = name
  }

  val person1 = new Person("Mukesh") {
    override def getName: String = "Mukesh Prajapati"
  }

  println(person1.getName)

  trait MyPredicate[T] {
    def test(num: T): Boolean
  }

  class EvenPredicate extends MyPredicate[Int] {
    override def test(num: Int): Boolean = num % 2 == 0
  }

  val intPredicate = new EvenPredicate
  println(intPredicate.test(24))

  trait MyTransformer[A, B] {
    def transformAToB(element: A): B
  }

  class StringToIntTransformer extends MyTransformer[String, Int] {
    override def transformAToB(element: String): Int = element.toInt
  }

  val stringTransformer = new StringToIntTransformer
  println(stringTransformer.transformAToB("12"))

}

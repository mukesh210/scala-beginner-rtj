package lectures.part2oop

object Generics extends App {

  // Generic class
  class MyList[+A] {
    def add[B >: A](element: B): MyList[B] = ???
  }

  val listOfInts = new MyList[Int]
  val listOfStrings = new MyList[String]

  // Generic methods
  // parameters can not be passed to objects
  object MyList {
    def empty[A]: MyList[A] = ???
  }

  val emptyListOfInts = MyList.empty[Int]

  // variance problem
  class Animal
  class Cat extends Animal
  class Dog extends Animal

  val myListOfCat: MyList[Animal] = new MyList[Cat]
  val updatedList: MyList[Animal] = myListOfCat.add(new Dog)

  // Question: If Cat extends Animal, Can List[Cat] extend List[Animal]
  // 1. YES, List[Cat] can extend List[Animal] = COVARIANCE
  class CovariantList[+A]
  val covariantList: CovariantList[Animal] = new CovariantList[Cat]
  // What to do if someone put Dog too in List ??? If we put Dog too, it will become generic(Animal type)

  // 2. NO = INVARIANCE
  class InvariantList[A]
  val invariantList: InvariantList[Animal] = new InvariantList[Animal]

  // 3. Hell, no! CONTRAVARIANCE
  class ContraVariantList[-A]
  val contraVariantList: ContraVariantList[Cat] = new ContraVariantList[Animal] // This won't make sense...

  class Trainer[-A]
  val trainer: Trainer[Cat] = new Trainer[Animal] // This makes sense

  // Bounded Types
  class Cage[A <: Animal](animal: A) // upper bound
  val dogCage = new Cage(new Dog)
}

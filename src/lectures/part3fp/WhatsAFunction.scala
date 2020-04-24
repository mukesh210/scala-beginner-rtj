package lectures.part3fp

object WhatsAFunction extends App {

  // Use Function as First class citizen

  val doubler = new MyFunction[Int, Int] {
    override def apply(x: Int): Int = x * 2
  }

  // benefit of Scala is that we can call doubler as a function
  println(doubler(23))

  // Function Types: 1,2,3,...,22
  val stringToIntConverter = new Function[String, Int] {
    override def apply(v1: String): Int = v1.toInt
  }

  println(stringToIntConverter("23"))

  val adder: (Int, Int) => Int = (v1: Int, v2: Int) => v1 + v2
  // is equivalent to
  val adder1 = new Function2[Int, Int, Int] {
    override def apply(v1: Int, v2: Int): Int = v1 + v2
  }

  println(s"Adder: ${adder(12,13)}")

  // ALL SCALA FUNCTIONS ARE OBJECTS

  // 1. a function which takes 2 params and concat them
  val concat = new Function2[String, String, String] {
    override def apply(v1: String, v2: String): String = v1 + " " + v2
  }

  println(s"concat: ${concat("Mukesh", "Prajapati")}")

  // 3.
  val threeAdder: (Int => Int => Int) = new Function1[Int, Function1[Int, Int]] {
    override def apply(v1: Int) = new Function1[Int, Int] {
      override def apply(v2: Int) = v1 + v2
    }
  }
  val threeAdder1: Int => (Int => Int) = (x: Int) => (y: Int) => (x + y) // curried function
  println(s"ThreeAdder1: ${threeAdder1(2)(3)}")

}

trait MyFunction[A, B] {
  def apply(x: A): B
}


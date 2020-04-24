package lectures.part3fp

object MapFlatMapFilterFor extends App {
  val list = List(1, 2, 3)
  println(list)
  println(list.head)
  println(list.tail)

  // map
  println(list.map(_ + 2))
  println(list.map(_ + " is a number"))

  // flatMap
  val toPair = (x: Int) => List(x, x + 1)
  println(list.flatMap(toPair))

  // filter
  println(list.filter(_ % 2 == 0))

  // printing all combinations of 2 lists
  val numbers = List(1, 2, 3, 4)
  val chars = List('a', 'b', 'c', 'd')
  val colors = List("black", "white")

  // iterations
  val combinations = numbers.flatMap(n => chars.flatMap(char => colors.map(color => ""+char+n+"-"+color)))
  println(combinations)

  // foreach
  list.foreach(println)

  // for-comprehensions
  val forCombination = for {
    n <- numbers if n % 2 == 0
    char <- chars
    color <- colors
  } yield ""+char+n+"-"+color

  println(forCombination)

  // for-comprehension for side-effects
  for {
    n <- numbers
  } println(n)

  // syntax overload
  val doubledList = numbers.map { x =>
    x*2
  }

  println(doubledList)

  val when = "AM" :: "PM" :: Nil
  println(when)

  val x: (Int, Int, Int, Int) = (1,2,3,4)
}

package lectures.part4pm

object PatternsEverywhere extends App {

  // big idea #1
  val exception = try {

  } catch {
    case e: NullPointerException =>
    case r: RuntimeException =>
    case _ =>
  }

  // CATCH block are pattern matching
  // it is similar to catching exception and then matching
  /*
  val exception = try {

  } catch (exception){
    exception match {
      case e: NullPointerException =>
      case r: RuntimeException =>
      case _ =>
    }
  }
   */

  // big idea #2
  val list = List(1, 2, 3)
  val evenOnes = for {
    x <- list if x % 2 == 0 // ??
  } yield x * 10

  // GENERATORS are also based on pattern matching
  val tuples = List((1, 2), (3, 4))
  val filterTuples = for {
    (first, second) <- tuples
  } yield first * second
  // case classes, :: operators, etc.

  // big idea #3
  val tuple = (1, 2, 3)
  val (a, b, c) = tuple
  println(b)
  // multiple value definition based on PATTERN MATCHING - NAME BINDING
  // ALL THE POWER

  val head :: tail = list
  println(head)
  println(tail)

  // big idea #4 NEW
  // PARTIAL FUNCTION is also based on PATTERN MATCHING
  val mappedList = list map {
    case v if v % 2 == 0 => s"${v} is even"
    case 1 => "ONE"
    case _ => "something else"
  }
  // is equivalent to
  val mappedList2 = list map { x => x match {
    case v if v % 2 == 0 => s"${v} is even"
    case 1 => "ONE"
    case _ => "something else"
    }
  }

  println(s"mappedList: ${mappedList}")
  println(s"mappedList2: ${mappedList2}")
}

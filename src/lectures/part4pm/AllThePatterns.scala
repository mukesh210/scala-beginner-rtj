package lectures.part4pm

import exercises.{Cons, Empty, MyList}

object AllThePatterns extends App {

  // 1. Constants --- literals
  val x: Any = "Scala"
  val constants = x match {
    case 1 => "ONE"
    case "Scala" => "The SCALA"
    case true => "TRUE"
    case AllThePatterns => "AllThePattern Single Object"
  }

  // 2. Match Anything
  // 2.1 wildcard     // use if you do not want to use captured value
  val matchAnything = x match {
    case _ =>
  }

  // 2.2 variable
  val matchAVariable = x match {
    case something => s"I have found ${something}"
  }

  // 3. Tuples
  val aTuple = (1, 2)
  val matchATuple = aTuple match {
    case (1, 1) =>
    case (something, 2) => s"I have found ${something}"
  }

  val nestedTuple = (1, (2, 3))
  val matchNestedTuple = nestedTuple match {
    case (_, (2, v)) =>
  }

  // Pattern Matching can be nested

  // 4. Case classes - Constructor Pattern
  // Pattern matching can be nested with Case classes as well
  val aList: MyList[Int] = Cons(1, Cons(2, Empty))
  val matchAList = aList match {
    case Cons(head, tail) =>
    case Cons(head, Cons(head2, tail)) =>
  }

  // 5. List Pattern
  val aStandardList = List(1, 2, 3, 4)
  val matchAStandardList = aStandardList match {
    case List(1, _, _, _) =>  // extractor pattern
    case List(1, _*) =>       // list of arbitrary length
    case 1 :: List(_) =>      // Infix notation
    case List(1, 2, 3) :+ 42 => // Infix notation
  }

  // 6. Type specifiers
  val unknown: Any = 2
  val matchUnknown = unknown match {
    case _: List[Int] =>    // explicit type specifiers
    case _ =>
  }

  // 7. Name Binding
  val matchNameBinding = aList match {
    case nonEmptyList @ Cons(_, _) => // name binding => use the name later
    case Cons(1, rest @ Cons(2, _)) => // name binding inside nested pattern
  }

  // 8. Multi-pattern
  val multiPattern = aList match {
    case Empty | Cons(1, _) =>        // multi-pattern
  }

  // 9. if guards
  val specialElementMatch = aList match {
    case Cons(_, Cons(specialElement, _)) if specialElement % 2 == 0 =>
  }

  val numbers = List(1, 2, 3)
  val numbersMatch = numbers match {
    case listOfString: List[String] => "list of string"
    case listOfInt: List[Int] => "list of Int"
  }

  println(s"numbersMatch: ${numbersMatch}")
  // JVM Trick question
  // Answer: list of string
  // Reason: TYPE ERASURE
}
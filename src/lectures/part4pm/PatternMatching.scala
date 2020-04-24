package lectures.part4pm

import java.util.Random

object PatternMatching extends App {

  // switch on steroids
  val random = new Random()
  val x = random.nextInt(10)

  val xDescription = x match {
    case 1 => "the ONE"
    case 2 => "the TWO"
    case 3 => "the THREE"
    case 4 => "the FOUR"
    case _ => "the DEFAULT"
  }

  println(s"x: ${x} xDescription: ${xDescription}")

  // 1. Decompose values in case classes
  case class Person(name: String, age: Int)

  val bob = Person("Bob", 10)

  val greeting = bob match {
      // guard - if condition
    case Person(n, a) if a < 20 => s"Hello, My name is ${n} and i can't drink"
    case Person(n, a) => s"Hello, My name is ${n} and i am ${a} years old"
    case _ => "I don't know who i am"
  }

  println(s"Greeting: ${greeting}")

  /*
  1. cases are matched in order
  2. what if no cases match? MatchError
  3. type of PM expression? unified type of all types in all cases
  4. PM work really well with case class because case class support extractor pattern. Additional code has to be
     written in normal classes for them to support extractor pattern
   */

  // PM on sealed hierachies
  sealed class Animal
  case class Dog(breed: String) extends Animal
  case class Parrot(greeting: String) extends Animal

  val animal: Animal = Dog("k9")
  animal match {
    case Dog(breed) => println(s"Matched dog with ${breed}")
  }

  trait Expr
  case class Number(n: Int) extends Expr
  case class Sum(e1: Expr, e2: Expr) extends Expr
  case class Prod(e1: Expr, e2: Expr) extends Expr

  // Exercise -> Takes Expr and return human readable form of it

  def returnHumanReadable(input: Expr): String = {
    input match {
      case number: Number => s"${number.n}"
      case Sum(e1: Expr, e2: Expr) => s"${returnHumanReadable(e1)} + ${returnHumanReadable(e2)}"
      case Prod(e1: Sum, e2: Expr) => s"(${returnHumanReadable(e1)}) * ${returnHumanReadable(e2)}"
      case Prod(e1: Expr, e2: Sum) => s"${returnHumanReadable(e1)} * (${returnHumanReadable(e2)})"
      case Prod(e1: Expr, e2: Expr) => s"${returnHumanReadable(e1)} * ${returnHumanReadable(e2)}"
      case _ => "No match"
    }
  }

  val test1 = Sum(Number(2), Number(3))
  println(s"test1: ${returnHumanReadable(test1)}")

  val test2 = Prod(Number(2), Number(3))
  println(s"test2: ${returnHumanReadable(test2)}")

  val test3 = Sum(Prod(Number(2), Number(3)), Number(4))
  println(s"test3: ${returnHumanReadable(test3)}")

  val test4 = Prod(Sum(Number(2), Number(3)), Number(4))
  println(s"test4: ${returnHumanReadable(test4)}")

  def show(e: Expr): String = e match {
    case Number(n) => s"${n}"
    case Sum(e1, e2) => s"${show(e1)} + ${show(e2)}"
    case Prod(e1, e2) => {
      def maybeShowParans(exp: Expr) = exp match {
        case Number(_) => show(exp)
        case Prod(_, _) => show(exp)
        case _ => s"( ${show(exp)} )"
      }

      maybeShowParans(e1) + " * " + maybeShowParans(e2)
    }
  }

  val test11 = Sum(Number(2), Number(3))
  println(s"test1: ${show(test1)}")

  val test21 = Prod(Number(2), Number(3))
  println(s"test2: ${show(test2)}")

  val test31 = Sum(Prod(Number(2), Number(3)), Number(4))
  println(s"test3: ${show(test3)}")

  val test41 = Prod(Sum(Number(2), Number(3)), Number(4))
  println(s"test4: ${show(test4)}")
}

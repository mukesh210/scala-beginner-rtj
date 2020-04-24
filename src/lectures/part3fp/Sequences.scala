package lectures.part3fp

import scala.util.Random

object Sequences extends App {

  // Seq
  val aSequence: Seq[Int] = Seq(1, 3, 2, 4)
  println(aSequence)
  println(aSequence.reverse)
  println(aSequence(2))         // equivalent to aSequence.apply(2)
  println(aSequence.applyOrElse(5, (x: Int) => 25))
  println(aSequence ++ Seq(5, 6, 7))
  println(aSequence.sorted)

  // Ranges
  val aRange: Seq[Int] = 1 to 10
  aRange.foreach(println)

  // List
  val aList: List[Int] = List(1, 2, 3)
  val prepended = 34 :: aList
  println(s"Prepended: ${prepended}")

  val newPre = 34 +: aList :+ 89
  println(s"newPre: ${newPre}")

  val apples5 = List.fill(5)("Apples")
  println(s"apples5: ${apples5}")
  println(s"mkString: ${aList.mkString("-|-")}")

  // Arrays
  val numbers = Array(1, 2, 3, 4)
  val threeElems = Array.ofDim[Int](3)
  println(s"threeElements: ${threeElems}")
  threeElems.foreach(println)

  // Mutations
  numbers(2) = 0                                // Syntactic sugar for numbers.update(2, 0)
  println(s"numbers: ${numbers.mkString(" - ")}")

  // Array and Seq
  val numbersSeq: Seq[Int] = numbers            // Implicit conversion from Array to WrapperArray
  println(s"numbersSeq: ${numbersSeq}")

  // Vectors
  val vectors = Vector(1, 2, 3, 4)
  println(s"Vectors: ${vectors}")

  // Vectors vs Lists
  val maxRuns = 1000
  val maxCapacity = 1000000

  def getWriteTime(collection: Seq[Int]): Double = {
    val r = new Random
    val times = for {
      it <- 1 to maxRuns
    } yield {
      val currentTime = System.nanoTime()
      collection.updated(r.nextInt(maxCapacity), r.nextInt())
      System.nanoTime() - currentTime
    }

    times.sum * 1.0 / maxRuns
  }

  // keeps reference to tail so prepend is O(1)
  // updating element in middle takes time O(n)
  val numbersList = (1 to maxCapacity).toList

  // depth of the tree is small
  // needs to replace an entire 32-element chunk
  val numbersVector = (1 to maxCapacity).toVector
  println(getWriteTime(numbersList))
  println(getWriteTime(numbersVector))
}

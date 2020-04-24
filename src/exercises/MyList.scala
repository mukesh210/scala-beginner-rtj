package exercises

import java.util.NoSuchElementException

abstract class MyList[+A] {
  def head: A
  def tail: MyList[A]
  def isEmpty: Boolean
  def add[B >: A](n: B): MyList[B]
  def printElements: String
  def filter(predicate: A => Boolean): MyList[A]
  def map[B](transformer: A => B): MyList[B]
  def flatMap[B](transformer: A => MyList[B]): MyList[B]
  def ++[B >: A](newList: MyList[B]): MyList[B]
  def forEach(func: A => Unit): Unit
  def sort(func: (A, A) => Int, count: Int = 1): MyList[A]
  def insertionSort(compare: (A, A) => Int): MyList[A]
  def zipWith[B, C](list: MyList[B], zippingFunc: (A, B) => C): MyList[C]
  def fold[B](start: B)(func: (B, A) => B): B
  def length: Int
}

case object Empty extends MyList[Nothing] {
  override def head: Nothing = throw new NoSuchElementException

  override def tail: MyList[Nothing] = throw new NoSuchElementException

  override def isEmpty: Boolean = true

  override def add[B >: Nothing](n: B): MyList[B] = new Cons(n, Empty)

  override def printElements: String = "Empty"

  override def filter(predicate: Nothing => Boolean): MyList[Nothing] = Empty

  override def map[B](transformer: Nothing => B): MyList[B] = Empty

  override def flatMap[B](transformer: Nothing => MyList[B]): MyList[B] = Empty

  override def ++[B >: Nothing](newList: MyList[B]): MyList[B] = newList

  override def forEach(func: Nothing => Unit): Unit = {}

  override def sort(func: (Nothing, Nothing) => Int, count: Int = 1): MyList[Nothing] = Empty

  override def zipWith[B, C](list: MyList[B], zippingFunc: (Nothing, B) => C): MyList[C] = {
    if(!list.isEmpty) throw new RuntimeException("Lists do not have same lengths")
    else Empty
  }

  override def fold[B](start: B)(func: (B, Nothing) => B): B = start

  override def length: Int = 0

  override def insertionSort(compare: (Nothing, Nothing) => Int): MyList[Nothing] = Empty
}

case class Cons[+A](element: A, remainingList: MyList[A]) extends MyList[A] {
  override def head: A = element

  override def tail: MyList[A] = remainingList

  override def isEmpty: Boolean = false

  override def add[B >: A](n: B): MyList[B] = new Cons(n, this)

  override def filter(predicate: A => Boolean): MyList[A] =
    if(predicate(element))
      new Cons[A](element, remainingList.filter(predicate))
    else
      remainingList.filter(predicate)


  override def map[B](transformer: A => B): MyList[B] =
    new Cons[B](transformer(element), remainingList.map(transformer))

  override def flatMap[B](transformer: A => MyList[B]): MyList[B] =
    transformer(element) ++ remainingList.flatMap(transformer)

  override def printElements: String =
    if(remainingList.isEmpty) "" + element
    else element + "  " + remainingList.printElements

  override def ++[B >: A](newList: MyList[B]): MyList[B] = new Cons[B](element, remainingList ++ newList)

  override def forEach(func: A => Unit): Unit = {
    func(element)
    remainingList.forEach(func)
  }

  def sortingHelper[B >: A](func: (B, B) => Int): MyList[B] = {
    if(remainingList != Empty) { // subArr has more than one element
      val comparedResult = func(element, remainingList.head)
      if(comparedResult > 0)
        Cons(remainingList.head, Cons(element, remainingList.tail).sortingHelper(func))
      else
        Cons(element, Cons(remainingList.head, remainingList.tail).sortingHelper(func))
    } else this
  }

  override def sort(func: (A, A) => Int, count: Int = 1): MyList[A] = {
    val x: MyList[A] = this.sortingHelper(func)
    if(count <= this.length)
      x.sort(func, count + 1)
    else
      x
  }

  override def zipWith[B, C](list: MyList[B], zippingFunc: (A, B) => C): MyList[C] = {
    if(list.isEmpty) throw new RuntimeException("Lists do not have same lengths")
    else Cons(zippingFunc(element, list.head), remainingList.zipWith(list.tail, zippingFunc))
  }

  override def fold[B](start: B)(func: (B, A) => B): B =
    remainingList.fold(func(start, element))(func)

  override def length: Int = remainingList.length + 1

  override def insertionSort(compare: (A, A) => Int): MyList[A] = {

    def insert(head: A, sortedTail: MyList[A]): MyList[A] = {
      if(sortedTail.isEmpty) Cons(head, Empty)
      else if(compare(head, sortedTail.head) <= 0) Cons(head, sortedTail)
      else Cons(sortedTail.head, insert(head, sortedTail.tail))
    }

    val sortedTail = remainingList.insertionSort(compare)
    insert(element, sortedTail)
  }
}

object ListTester extends App {
  val myList: MyList[Int] = Cons(23, Cons(24, Empty)).add(45).add(78)
  val clonedMyList: MyList[Int] = Cons(23, Cons(24, Empty)).add(45).add(78)
  println(myList == clonedMyList)
  println(myList)

  val strings = Cons("Learning", Cons("Scala", Empty))
  println(strings)

  val evenPredicate = (element: Int) => element % 2 == 0

  println(s"even test: ${evenPredicate(34)}")

  println(s"Transformer: ${myList.map(_ * 2)}")

  println(s"Filtering on even: ${myList.filter(_ % 2 == 0)}")

  val sequence = (element: Int) => new Cons[Int](element, new Cons[Int](element + 1, Empty))

  println(s"flatMap: ${myList.flatMap(sequence)}")

  println("-------------------- Printing myList element ------------------")

  myList.forEach(x => println(x))

  println("-------------------- ZIPPING ------------------")

  val newListForZipping: MyList[Int] = Empty.add(4).add(3).add(2).add(1)

  val zippedList = myList.zipWith[Int, Int](newListForZipping, (x, y) => x - y)

  zippedList.forEach(println)

  println("-------------------- FOLD LEFT ADDITION ------------------")

  println(newListForZipping.fold(0)((x, y) => x + y))

  println("-------------------- SORTING ------------------")

  val desendingList = Empty.add(12).add(10).add(14).add(67)

  println("-------------------- ORIGINAL ARRAY ------------------")
  desendingList.forEach(println)

  println("-------------------- SORTED ARRAY ------------------")
  val sortedArray = desendingList.sort((x, y) => x - y)

  sortedArray.forEach(println)

  println("-------------------- INSERTION SORT -----------------")
  desendingList.insertionSort((x, y) => x - y).forEach(println)

  println("-------------------- FOR COMPREHENSION --------------")
  val combinations = for {
    num <- myList
    str <- strings
  } yield num + " - " + str

  println(combinations)

}




package lectures.part2oop

object OOBasics extends App {
  /*val p1 = new Person("Mukesh", 25)
  println(p1.x)
  p1.greet("Ajay")
  p1.greet()
  val p2 = new Person("Ajay")
  println(p2.age)*/

  val writer = new Writer("Mukesh", "Prajapati", 1994)
  val imposter = new Writer("Mukesh", "Prajapati", 1994)
  println("Writer Full name:", writer.fullName())

  val novel = new Novel("Autobiography", 2017, writer)
  println(novel.authorAge())
  println(novel.isWrittenBy(writer))
  println(novel.isWrittenBy(imposter))

//  val counter = new Counter(24)
//  println(s"current count: ${counter.getCurrentCount()}")
//  val counter1 = counter.incrementCounter()
//  println(s"After incrementing by 1: ${counter1.getCurrentCount()}")
//  val counter2 = counter.decrementCounter()
//  println(s"After decrementing by 1: ${counter2.getCurrentCount()}")
//  val counter3 = counter.incrementCounter(4)
//  println(s"After incrementing by 4: ${counter3.getCurrentCount()}")
//  val counter4 = counter.decrementCounter(5)
//  println(s"After decrementing by 5: ${counter4.getCurrentCount()}")

}

// constructor
// CLASS PARAMETERS ARE NOT CLASS FIELDS
class Person(name: String, val age: Int) {
  // field
  val x = 2
  println("Inside class Person")

  // method
  def greet(name: String) = {
    println(s"${this.name} says Hi $name")
  }

  // overloading
  def greet() = {
    println(s"Hi, I am $name")
  }

  // multiple constructor
  def this(name: String) = this(name, 0)
}

class Writer(firstName: String, surname: String, val year: Int) {
  def fullName() = firstName + " " + surname
}

class Novel(name: String, yearOfRelease: Int, author: Writer) {
  def authorAge(): Int = yearOfRelease - author.year

  def isWrittenBy(author: Writer): Boolean = author == this.author

  def copy(newyear: Int): Novel = new Novel(this.name, newyear, author)
}

class Counter(currentValue: Int) {
  def getCurrentCount(): Int = currentValue

  def incrementCounter(): Counter = new Counter(currentValue + 1)

  def decrementCounter(): Counter = new Counter(currentValue - 1)

  def incrementCounter(value: Int): Counter = new Counter(currentValue + value)

  def decrementCounter(value: Int): Counter = new Counter(currentValue - value)
}
package lectures.part1basics

object StringOps extends App {
  val str: String = "Hello, I am learning Scala"

  println(str.charAt(2))
  println(str.codePointAt(2))
  println(str.substring(7, 11))
  println(str.split(" ").toList)
  println(str.startsWith("Hello"))
  println(str.replace(' ', '-'))
  println(str.toLowerCase())
  println(str.length)

  val anotherString = "45"
  val aNumber = anotherString.toInt
  println(s"aNumber: ${aNumber}")
  println("2" +: anotherString :+ "3")
  println(str.reverse)
  println(str.take(2))

  val name = "avcs"
  val age = 2
  // s-interpolators
  println(s"Hello my name is $name and i am $age years old")

  // f-interpolatores
  val speed = 1.2f
  val myth = f"$name can eat burgers at $speed%2.2f burgers per minutes"
  println(myth)

  //raw-interpolator
  println("This is a \n newline")
  println(raw"This is a \n newline")
}

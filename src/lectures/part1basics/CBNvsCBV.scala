package lectures.part1basics

object CBNvsCBV extends App {
  def callByValue(value: Int) = {
    println("Before in callByValue")
    println(s"callByValue: ${value}")
  }

  def callByName(value: => Int) = {
    println("Before callByName")
    println(s"callByName: ${value}")
  }

  def genericFunction(): Int = {
    println("Inside genericFunction")
    12
  }

  callByValue(genericFunction())
  callByName(genericFunction())
}

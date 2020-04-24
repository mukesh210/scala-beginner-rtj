package lectures.part1basics

object DefaultArgs extends App {
  def func1(x: Int, y: Int = 1): Unit = {
    println(x + " :: " + y);
  }

  func1(23)

  def func2(x: Int = 12, y: Int = 34,z: Int = 45) = {
    println(x + " :: " + y + " :: " + z)
  }

  func2()
  func2(12,32,34)
  func2(z = 1234, y = 5678, x = 45645)
}

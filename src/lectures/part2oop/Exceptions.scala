package lectures.part2oop

object Exceptions extends App {
  val str: String = null

  // Throws NullPointerException
  // println(str.length)

  // 1. throwing exception
  //throw new RuntimeException("Run time exception thrown")

  // 2. catching exception

  def getInt(withException: Boolean): Int = {
    if(withException) throw new RuntimeException("You won't get Int value")
    else 42
  }

  val x: AnyVal = try {
    getInt(false)
  } catch {
    case e: RuntimeException => println("Caught Run time Exception")
  } finally {
    // does not influence return type of function
    // so use for side-effects
    println("Inside finally block")
  }

  // 3. define your own exceptions
  class MyException extends Exception
  val exception1 = new MyException
  throw exception1
}

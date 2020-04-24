package lectures.part1basics

object Functions extends App {
  def aFunction(a: String, b: Int): String = a + " " + b

  println(aFunction("Mukesh", 25))

  def parameterLessFunction() = 42

  println(parameterLessFunction())
  println(parameterLessFunction)

  // WHEN YOU NEED LOOP, USE RECURSION
  // Recursive function needs return type
  def multiplyString(a: String, b: Int): String = {
    if(b == 1) a
    else
      a + multiplyString(a, b-1)
  }

  println(multiplyString("Hello", 3))

  def grettingFunction(name: String, age: Int): String = {
    s"Hi, My Name is ${name} and i am ${age} years old"
  }

  println(grettingFunction("Mukesh", 25))

  def factorial(n: Long): Long = {
    if(n == 0 || n == 1) 1
    else n * factorial(n-1)
  }

  println(factorial(6))

  def fibonacci(n: Long): Long = {
   if(n == 1 || n == 2) 1
   else fibonacci(n-1) + fibonacci(n-2)
  }

  println(fibonacci(3))

  def primeCheck(n: Int): Boolean = {
    if(n == 1)
      false
    else {
      (2.to(n-1)).forall(x => n%x != 0)
    }
  }

  println(primeCheck(11))
}

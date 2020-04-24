package lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App {
  def factorial(n: BigInt): BigInt = {
    if(n == 0 || n == 1) 1
    else n * factorial(n-1)
  }

  println(factorial(20))

  // TAIL RECURSION -> USE RECURSIVE CALL AS LAST EXPRESSION
  @tailrec
  def tailRecursiveFactorial(n: BigInt, acc: BigInt): BigInt = {
    if(n <= 1) acc
    else tailRecursiveFactorial(n - 1, n * acc)
  }

  println(tailRecursiveFactorial(20, 1))

  @tailrec
  def stringConcat(str: String, times: Int, acc: String = ""): String = {
    if(times == 0) acc
    else stringConcat(str, times - 1, str + acc)
  }

  println(stringConcat("Hello", 5))

  def isPrime(num: Int): Boolean = {
    @tailrec
    def isPrimeUntil(t: Int, acc: Boolean): Boolean = {
      if(!acc) false
      else if(t <= 1) true
      else isPrimeUntil(t-1, num % t != 0 && acc)
    }

    isPrimeUntil(num/2, true)
  }

  println(isPrime(100))
  println(isPrime(101))

  def fibonacci(n: Int): Int = {
    @tailrec
    def fiboUtil(x: Int, last: Int, nextToLast: Int): Int = {
      if(n <= x) last
      else fiboUtil(x + 1, last + nextToLast, last)
    }

    if(n <= 2) 1
    else fiboUtil(2, 1, 1)
  }

  // 1 1 2 3 5 8 13 21
  println(fibonacci(8))
}

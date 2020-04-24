package lectures.part3fp

object HOFsAndCurries extends App {

  // function that applies a function n times on x
  // nTimes(f, n, x)
  // nTimes(f, 3, x) => f(f(f(x)))

  def nTimes(func: Int => Int, n: Int, x: Int): Int = {
    if (n <= 0) x
    else nTimes(func, n - 1, func(x))
  }

  val result = nTimes((x: Int) => x + 1, 3, 2)
  println(s"Result: ${result}")

  def nTimesBetter(func: Int => Int, n: Int): (Int => Int) = {
    if (n <= 0) x => x
    else x => nTimesBetter(func, n - 1)(func(x))
  }

  val temp1: Int => Int = nTimesBetter(x => x + 1, 3)

  println(s"nTimesBetter: ${temp1(2)}")

  // curried function
  val superAdder: Int => Int => Int = x => y => x + y
  val add3 = superAdder(3)
  println(s"Adding 2 to add3: ${add3(2)}")
  println(s"Adding 3 and 4: ${superAdder(3)(4)}")

  // functions with multiple paramters
  def curriedFormatter(s: String)(d: Double): String = s.format(d)

  val standardFormat: Double => String = curriedFormatter("%4.2f")
  val preciseFormat: Double => String = curriedFormatter("%10.8f")

  println(standardFormat(Math.PI))
  println(preciseFormat(Math.PI))

  def toCurry(func: (Int, Int) => Int) = (x: Int) => (y: Int) => func(x, y)

  def fromCurry(func: Int => Int => Int) = (x: Int, y: Int) => func(x)(y)

  // FunctionX
  def compose[A, B, T](f: A => B, g: T => A) = (x: T) => f(g(x))

  def andThen[A, B, T](f: A => B, g: B => T) = (x: A) => g(f(x))

  def simpleAdder(x: Int, y: Int): Int = x + y

  val add4 = toCurry(simpleAdder)(4)
  println(s"Add 5 to add4: ${add4(5)}")

  val add5 = fromCurry(x => y => x * y)(4, 5)
  println(s"Add5: ${add5}")

  val composed = compose((x: Int) => x + 2, (y: Int) => y * 3)(3)
  println(s"Composed: ${composed}")

  val andThen1 = andThen((y: Int) => y * 3, (x: Int) => x + 2)(3)
  println(s"andThen1: ${andThen1}")
}

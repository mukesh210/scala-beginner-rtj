package lectures.part3fp

object AnonymousFunctions extends App {

  // Anonymous Function(LAMBDAS)
  val doublers: Int => Int = (x: Int) => x * 2

  // multiple parameter
  val adder: (Int, Int) => Int = (x: Int, y: Int) => x + y

  // no parameter
  val justDoSomething: () => Int = () => 3

  // CAUTION
  println(justDoSomething)
  println(justDoSomething())

  // no parens
  def str: String = "Mukesh"
  println(s"str: ${str}")

  // MORE SYNTACTIC SUGAR
  val niceIncrementer: Int => Int = _ + 1       // is equivalent to x => x + 1
  val niceAdder: (Int, Int) => Int = _ + _      // is equivalent to (x, y) => x + y
}

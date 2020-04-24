package lectures.part1basics

object ValuesVariableTypes extends App {
  val x: Int = 42 // val are immutable
  println(x) // val -> values

  val bool: Boolean = true
  val char: Char = 'c'
  val string: String = "World"
  val int: Int = 12
  val float: Float = 12.34f
  val double: Double = 12.34
  val long: Long = 123445L

  //var -> variables

  var w = 12
  w = 23
}

package lectures.part1basics

object expressions extends App {
  // If Expression
  val aCondition = 12
  val aConditionedValue = if(aCondition > 0) true else false
  println(aConditionedValue)

  // Imperative programming with side-effects
  var i = 0
  while(i< 10) {
    //println(i)
    i += 1
  }

  // Everything in scala is expression

  var varValue: Int = 12
  val aWeirdValue: Unit = (varValue = 13)
  println(aWeirdValue)

  // Side-effects: println, while, reassigning

  // code blocks
    // they are expression
    // their return type is the last statement return value
    // they have their own scope
  val aCodeBlock = {
      val x = 12
      val y = 23
      if(x > y) x else y
    }
  println(aCodeBlock)
}

package lectures.part2oop

object InheritanceDoubt extends App {
  class A {
    protected def eat: Unit = println("Eat from A")
  }

  class B extends A

  val b = new B
  //b.eat   // compiler error: Symbol eat is inaccesible from this place
}

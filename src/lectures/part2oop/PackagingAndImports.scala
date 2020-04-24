package lectures.part2oop

import playground.{PrinceCharming, ScalaPlayground => Playground}

object PackagingAndImports extends App {

  // package members(present inside part2oop) are accessible by their simple name
  val person = new Person("Mukesh", 25)


  // class outside package `part2oop` need to be imported to be used
  val scalaPlayground = Playground

  // packages are in hierarchy matching folder structure


  // package objects
  hello

  // imports
  val princeCharming = new PrinceCharming
}

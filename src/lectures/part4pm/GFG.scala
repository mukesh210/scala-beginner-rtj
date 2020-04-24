package lectures.part4pm

object GFG {

  def apply(x: Double): Double = x * 5

  def unapply(x: Double): Option[Double] =
    if(x % 5 == 0)
      Some(x / 5)
    else None

  def main(args: Array[String]): Unit = {
    val gfgObj: Double = GFG(3)
    println(s"gfgObj: ${gfgObj}")

    gfgObj match {
      case GFG(x) => println(s"GFG Match: ${x}")
      case _ => println("something else")
    }

    34 match {
      case GFG(x) => println(s"GFG Match: ${x}")
      case _ => println("something else")
    }

  }
}

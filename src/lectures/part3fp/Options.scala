package lectures.part3fp

import java.util.Random

object Options extends App {
  val myFirstOption: Option[Int] = Some(4)
  val noOption: Option[Int] = None

  println(myFirstOption)
  println(noOption)

  def unsafeMethod: String = null
  // val result = Some(unsafeMethod) // WRONG
  val result = Option(unsafeMethod) // will return Some or None
  println(result)

  // chained methods
  def backupMethod = "Mukesh"
  val chainedResult = Option(unsafeMethod).orElse(Option(backupMethod))
  println(chainedResult)

  // DESIGN unsafe api
  def betterUnsafeMethod: Option[String] = None
  def betterBackupMethod: Option[String] = Some("Mukesh")

  val betterChainedResult = betterUnsafeMethod.orElse(betterBackupMethod)

  // functions on Options
  println(myFirstOption.isEmpty)
  println(myFirstOption.get)
  println(noOption.getOrElse(5))

  // map, flatMap, filter
  println(myFirstOption.map(_ * 2))
  println(noOption.map(_ * 2))

  println(myFirstOption.flatMap(x => Some(x * 3)))
  println(noOption.flatMap(x => Some(x * 3)))

  println(myFirstOption.filter(_ % 2 == 0))
  println(myFirstOption.filter(_ % 3 == 0))

  // for comprehension

  val configs: Map[String, String] = Map(
    "host" -> "123.345.56.78",
    "port" -> "80"
  )

  val host: Option[String] = configs.get("host")
  val port: Option[String] = configs.get("port")
  val connection: Option[Connection] = host.flatMap(h => port.flatMap(p => Connection(h, p)))
  val connectionStatus: Option[String] = connection.map(x => x.connect)
  connectionStatus.foreach(println)

  // Chained call
  configs.get("host")
    .flatMap(host => configs.get("port")
      .flatMap(port => Connection(host, port)))
    .map(con => con.connect)
    .foreach(println)

  // for comprehension
  val newConnection = for {
    host <- configs.get("host")
    port <- configs.get("port")
    con <- Connection(host, port)
  } yield con.connect

  println(s"newConnection: ${newConnection}")
}

class Connection {
  def connect: String = "Connected"
}

object Connection {
  val random = new Random(System.nanoTime())
  def apply(host: String, port: String): Option[Connection] =
    if(random.nextBoolean()) Some(new Connection)
    else None
}

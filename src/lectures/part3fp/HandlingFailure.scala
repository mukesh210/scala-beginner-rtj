package lectures.part3fp

import java.util.Random

import scala.util.{Failure, Success, Try}

object HandlingFailure extends App {
  // creating success and failure
  val aSuccess = Success(3)
  val aFailure = Failure(new RuntimeException("simple failure"))

  println(aSuccess)
  println(aFailure)

  // unsafe method
  def unsafeMethod: String = throw new RuntimeException("No String for you")

  // Try object via apply method
  val unsafeResult = Try(unsafeMethod)
  println(unsafeResult)

  // Syntactic sugar
  val anotherFailure = Try {
    // code that might throw error
  }

  // utilities
  println(aFailure.isSuccess)

  // orElse
  def backupMethod = "Real String"
  val fallbackTry = Try(unsafeMethod).orElse(Try(backupMethod))
  println(s"fallbackTry: ${fallbackTry}")

  // designing API -- wrap it with Try
  def betterUnsafeMethod: Try[String] = Failure(new RuntimeException("better unsafe method"))
  def betterBackupMethod: Try[String] = Success("better backup method")
  val betterFallbackTry = betterUnsafeMethod.orElse(betterBackupMethod)
  println(s"betterFallbackTry: ${betterFallbackTry}")

  // map, flatMap, filter
  println(aSuccess.map(_ * 3))
  println(aSuccess.flatMap(x => Success(x * 10)))
  println(aSuccess.filter(_ > 10))

  // for-comprehension

  // Exercise
  val hostName = "localhost"
  val port = "8080"

  def renderHTML(page: String) = println(page)

  class Connection {
    def get(url: String): String = {
      val random = new Random(System.nanoTime())

      if(random.nextBoolean()) "<html>...</html>"
      else throw new RuntimeException("Connection interrupted")
    }
  }

  object HttpService {
    val random = new Random(System.nanoTime())

    def getConnection(host: String, port: String): Connection = {
      if(random.nextBoolean()) new Connection
      else throw new RuntimeException("Someone else took the port")
    }
  }

  val data: Try[String] = Try(HttpService.getConnection(hostName, port))
              .flatMap(connection => Try(connection.get("google.com")))

  data.foreach(x => renderHTML(x))

  val data1: Try[String] = for {
    connection <- Try(HttpService.getConnection(hostName, port))
    renderingData <- Try(connection.get("google.com"))
  } yield {
    renderingData
  }

  data1.foreach(x => renderHTML(x))

}

package lectures.part3fp

object TuplesAndMaps extends App {

  // Tuples = Finite ordered Lists
  val aTuples = new Tuple2[Int, String](2 , "Hello Scala")
  val aTuples1 = (2, "Hello Scala")

  println(aTuples1._1)
  println(aTuples1.copy(_2 = "Goodbye Java"))
  println(aTuples1.swap)

  // Maps
  val aMap: Map[String, Int] = Map()

  val phoneBook = Map(("Mukesh", 123), "Ajay" -> 789).withDefaultValue(-1)
  println(phoneBook)

  // map ops
  println(phoneBook.contains("Mukesh"))
  println(phoneBook("Mukesh"))
  println(phoneBook("Mary"))

  // adding key-value to map
  val pair = ("mukesh", 765)
  val newPhoneBook = phoneBook + pair
  println(newPhoneBook)

  // functional on Map
  // map, flatMap, filter
  println(newPhoneBook.map(pair => pair._1.toLowerCase -> pair._2))

  // filterKeys
  println(newPhoneBook.filterKeys(_.startsWith("M")))

  // mapValues
  println(newPhoneBook.mapValues(x => x * 10))

  // conversions to other collections
  println(newPhoneBook.toList)
  println(List(("Daniel", 543)).toMap)
  val names = List("Ram", "Shyam", "Mohan", "Ramesh", "Suresh")

  println(names.groupBy(x => x.charAt(0)))

  val socialNetwork: Map[String, List[String]] = Map()

}

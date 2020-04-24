package exercises


object SocialNetworkTester extends App {

  type socialType = Map[String, Set[String]]

  def add(socialMap: socialType, person: String): socialType = socialMap + ((person, Set[String]()))

  def remove(socialMap: socialType, person: String): socialType = {
    def removeAux(friends: Set[String], acc: socialType): socialType = {
      if(friends.isEmpty) acc
      else removeAux(friends.tail, unfriend(acc, person, friends.head))
    }

    val unfriended = removeAux(socialMap(person), socialMap)
    unfriended - person
  }

  def addFriend(socialMap: socialType, a: String, b: String): socialType = {
    val aFriends = socialMap(a)
    val bFriends = socialMap(b)

    socialMap + (a -> (aFriends + b)) + (b -> (bFriends + a))
  }

  def unfriend(socialMap: socialType, a: String, b: String) = {
    val aFriend = socialMap(a)
    val bFriend = socialMap(b)

    socialMap + (a -> (aFriend - b)) + (b -> (bFriend - a))
  }

  def numFriends(socialMap: socialType, key: String) =
    if(!socialMap.contains(key)) 0
    else socialMap(key).size

  def personWithMostFriends(socialMap: socialType) = {
    socialMap.maxBy(pair => pair._2.size)._1
  }

  def personWithNoFriends(socialMap: socialType) = {
    socialMap.count(x => x._2.isEmpty)
  }

  def socialConnectionExists(socialMap: socialType, a: String, b: String): Boolean = {
    def bfs(target: String, consideredPeople: Set[String], discoveredPeople: Set[String]): Boolean = {
      if(discoveredPeople.isEmpty) false
      else {
        val head = discoveredPeople.head
        if(target == head) true
        else if(consideredPeople.contains(head)) bfs(target, consideredPeople, discoveredPeople.tail)
        else bfs(target, consideredPeople + head, discoveredPeople.tail ++ socialMap(head))
      }
    }

    bfs(b, Set(), socialMap(b))
  }

  val empty: socialType = Map()
  val network = add(add(empty, "Bob"), "Mary")
  println(network)
  println(addFriend(network, "Mary", "Bob"))
  println(unfriend(addFriend(network, "Mary", "Bob"), "Mary", "Bob"))
  println(remove(addFriend(network, "Bob", "Mary"), "Bob"))

  val people = add(add(add(empty, "Bob"), "Mary"), "Jim")
  val jimBob = addFriend(people, "Bob", "Jim")
  val testNet = addFriend(jimBob, "Bob", "Mary")
  println(testNet)
  println(numFriends(testNet, "Bob"))
  println(personWithMostFriends(testNet))
  println(personWithNoFriends(testNet))
  println(socialConnectionExists(testNet, "Mary", "Jim"))
  println(socialConnectionExists(network, "Mary", "Bob"))
}
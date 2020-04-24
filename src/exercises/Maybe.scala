package exercises

trait Maybe[+A] {
  def map[B](func: A => B): Maybe[B]
  def flatMap[T >: A](func: T => Maybe[T]): Maybe[T]
  def filter(func: A => Boolean): Maybe[A]
}

case object MaybeNot extends Maybe[Nothing] {
  override def map[B](func: Nothing => B): Maybe[B] = MaybeNot

  override def flatMap[T >: Nothing](func: T => Maybe[T]): Maybe[T] = MaybeNot

  override def filter(func: Nothing => Boolean): Maybe[Nothing] = MaybeNot
}

case class Just[+A](value: A) extends Maybe[A] {
  override def map[B](func: A => B): Maybe[B] = Just(func(value))

  override def flatMap[T >: A](func: T => Maybe[T]): Maybe[T] = func(value)

  override def filter(func: A => Boolean): Maybe[A] =
    if(func(value)) this
    else MaybeNot
}

object MaybeTested extends App {
  val just12: Maybe[Int] = Just(12)
  println(just12.map(_ + 2))

  println(just12.flatMap(x => Just(x + 2)))

  println(just12.filter(_ % 2 == 0))

  println(just12.filter(_ % 7 == 0))
}
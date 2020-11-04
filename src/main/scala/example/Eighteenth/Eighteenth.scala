package example.Eighteenth

object Eighteenth {
  class Pair[T, S](val first: T, val second: S)
  val p = new Pair(42, "String") // Это - Pair[Int, String]
  val p2 = new Pair[Any, Any](42, "String")
  def getMiddle[T](a: Array[T]) = a(a.length / 2)

  getMiddle(Array("Mary", "had", "a", "little", "lamb"))// Вызовет getMiddle[String]

  class Pair2[T](val first: T, val second: T)
                                 (implicit ev: T => Comparable[T]) {
    def smaller = if (first.compareTo(second) < 0) first else second
    def replaceFirst[R >: T](newFirst: R)(implicit ev: R => Comparable[R]) = new Pair2[R](newFirst, second)
  }

  val p3 = new Pair2("Fred", "Brooks")
  println(p3.smaller) // Выведет Brooks

  class Pair3[T](val first: T, val second: T)(implicit ev: T <:< Comparable[T])

  class Pair4[T](val first: T, val second: T) {
    def smaller(implicit ev: T <:< Ordered[T]) =
      if (first < second) first else second
  }

  val friends = Map("Fred" -> "Barney")
  val friendOpt = friends.get("Wilma") // Экземпляр Option[String]
  val friendOrNull = friendOpt.orNull // Строка или null

  trait Friend[-T] {
    def befriend(someone: T): Unit = {
    }
  }

  class Person extends Friend[Person]
  class Student extends Person

  val susan = new Student
  val fred = new Person

  class Pair5[+T](val first: T, val second: T)
  val newPair = new Pair5(new Student, new Student)

  def makeFriends(p: Pair5[Person]){}
  makeFriends(newPair)


  def makeFriendWith(s: Student, f: Friend[Student]) { f.befriend(s) }
  makeFriendWith(susan, fred)

  val names = Array(new Student, new Student, new Student)
  val names2: Array[Person] = for(i <- names) yield i
  println(names2)
}

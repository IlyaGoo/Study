package example.Thirteenth

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

object Thirteenth {
  def digits(n: Int): Set[Int] = //На каждом шаге создается новый set
    if (n < 0) digits(-n)
    else if (n < 10) Set(n)
    else digits(n / 10) + (n % 10)

  // Vector – неизменяемый аналог ArrayBuffer

  def sum(lst: List[Int]): Int =
    if (lst == Nil) 0 else lst.head + sum(lst.tail)

  Set(2, 0, 1) + 1//Ничего не изменит
  val digitsSet = Set(1, 7, 2, 9)
  digitsSet contains 0 // false
  Set(1, 2) subsetOf digitsSet // true

  Vector(1, 2, 3) :+ 5 // Вернет новый Vector(1, 2, 3, 5)
  1 +: Vector(1, 2, 3) // Вернет новый Vector(1, 1, 2, 3)

  val names = List("Peter", "Paul", "Mary")
  names.map(_.toUpperCase) // List("PETER", "PAUL", "MARY")
  for (n <- names) yield n.toUpperCase //То же самое

  def ulcase(s: String): Vector[String] = Vector(s.toUpperCase(), s.toLowerCase())

  names.map(ulcase) //List(Vector("PETER","peter"), Vector("PAUL","paul"), Vector("MARY","mary"))
  names.flatMap(ulcase)  //List("PETER", "peter", "PAUL", "paul", "MARY", "mary")

  val buffer = ArrayBuffer("Peter", "Paul", "Mary")
  buffer.transform(_.toUpperCase)//то же самое что map, но изменяем на месте

  names.foreach(println)

  List(5.0, 20.0, 9.95).zipAll(List(10, 2), 0.0, 1)//List((5.0, 10), (20.0, 2), (9.95, 1))
  "Scala".zipWithIndex//Vector(('S', 0), ('c', 1), ('a', 2), ('l', 3), ('a', 4))
  "Scala".zipWithIndex.max._2//Индекс символа с наибольшим кодом

  val iter = names.iterator.buffered
  while (iter.hasNext && iter.head == "Paul") iter.next //Теперь итер указывает на Paul
  def numsFrom(n: BigInt): Stream[BigInt] = n #:: numsFrom(n + 1)
  val tenOrMore = numsFrom(10)
  println(tenOrMore)
  println(tenOrMore.tail.tail.tail)

  val palindromicSquares = (1 to 1000000).view
    .map(x => x * x)
    .filter(x => x.toString == x.toString.reverse)

  println(palindromicSquares.take(10).mkString(","))

  /*val coll = (1 to 1000).toList
  println(coll.par.sum)*/

}

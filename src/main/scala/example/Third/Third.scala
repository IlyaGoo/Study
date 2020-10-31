package example.Third
import scala.collection.mutable.ArrayBuffer

object Third {
  val a = new Array[String](10)
  val b = Array("dsf", "tyu")//При такой инициализации не трубется new

  val c = ArrayBuffer[Int]()//Эквивалентно new ArrayBuffer[Int]
  c += 1
  c += (2, 3, 4)
  c ++= Array[Int](5, 6)
  c.trimEnd(1)
  //println(c)

  val cDouble = for(e <- c if e % 2 == 0) yield e * 2
  println(cDouble)
  val cDouble2 = c.filter(_ % 2 == 0).map(_ * 2)
  println(cDouble2)

  val d = ArrayBuffer[Int](-1, 0, 5, -3, 6)
  println(d.filter(_ >= 0))

  println(d.sum)
  println(d.max)
  println(d.sortWith(_ < _))

  val matrix = Array.ofDim[Double](3, 4) // Три строки, четыре столбца
  matrix(1)(2) = 4

  val triangle = new Array[Array[Int]](10)
  for (i <- triangle.indices)
    triangle(i) = new Array[Int](i + 1) //Массивы могут иметь разную длинну строк

  //Упражнение
  var one = for(i <- 0 until 5) yield  i
  println(one)

  var two = Array(1, 2, 3, 4, 5)
  var twoRes = for(i <- 0 until two.length if (i % 2 == 0) && i != two.length - 1 ) yield two(i + 1)
  println(twoRes)


}

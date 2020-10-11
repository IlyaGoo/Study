package example.First
import scala.math._
import scala.util.Random
import scala.BigInt._

object First {
  println("First topic")
  //val == константа, var - нет
  val answer: Int = 123 + 2 * 7
  println(answer)
  var counter = 0
  counter = 1

  // ; используется, если несколько инструкций в одной строчке

  val x, y = 2 //Можно объявлять сразу несколько переменных

  // Byte, Char, Short, Int, Long, Float и Double + Bool - все классы
  println(10.to(14)) //to - метод класса RichInt
  println("Ghj".toSeq.intersect("hj"))
  //RichInt, RichDouble, RichChar - расширение обычных классов
  1 + 2 == 1.+(2) //операторы - есть методы

  //a НазваниеМетода b - непривычная запись, нужно привыкнуть
  //Оператора ++ нет
  println("Ilya".toSeq.sorted) //Если у метода нет параметров,Ю можно писать без скобок
  println(sqrt(4)); println(scala.math.sqrt(4)) //Второй случай, если не импортировали библиотеку

  probablePrime(100, scala.util.Random) //Тут BigInt - объект компаньон класса BigInt, его методы играют роль статических методов

  val str = "Qwerty"
  println(str(2)) //равносильно str.apply(2)
  println(Array.apply(1 to 2))

  //Упражение 2
  var res : Double = 3
  res = sqrt(res)
  res = res * res
  println(res)

  //Упражнение 4
  println("crazy" * 3)

  //Упражение 5
  println(10 max 12)

  //val resInt : BigInt = pow(2, 1024) //Разобраться как это сделать без циклов
  //println(resInt)

  //Упражнение 7
  println(probablePrime(100, Random))

  //Упражение 8
  val randomInt : Int = Random.nextInt()
  println(randomInt.toString(36))

  //Упражение 9
  println(str(0))
  println(str(str.length - 1))
}

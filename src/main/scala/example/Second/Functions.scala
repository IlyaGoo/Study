package example.Second
import java.time.LocalDate

import scala.math._

object Functions {
  def printWithNum(s: String, num : Int = 1) = println(num + s) //функция
  printWithNum(" - is One")

  def multiplication(args: Int*) ={
    var res = 1 : Int
    for(arg <- args)
      res *= arg
    res
  }

  println(multiplication(1, 2, 3))

  val t = multiplication(1 to 4: _*) //Мы говорим интерпритатору, чтобы он рассматривал параметр как последовательность аргументов
  //head - начальный аргемент последовательности, tail - все остальное

  for (i <- 1 to 3; from = 4 - i; j <- from to 3) print(f"${10 * i + j}%3d")

  for (i <- 1 to 10) yield i % 3 // Вернет Vector(1, 2, 0, 1, 2, 0, 1, 2, 0, 1)

  def proc(i: Int): Unit ={ //Процедура
    println(i)
  }

  proc(10);

  lazy val words = scala.io.Source.fromFile("/dfg/rwt/ert/sdfg").mkString //Из-за того, что значение lazy при запуске не выйдет ошибки

  val x = 1
  if (x >= 0) { sqrt(x)
  } else throw new IllegalArgumentException("x should not be negative")

  //Упражнения
  def signum(i: Int) = {if(i > 0) 1 else if(i < 0) -1 else 0}
  println(signum(-5))
  println(signum(5))
  println(signum(0))

  var e : Unit = ()
  var y : Int = 0
  e = y = 1

  for(i <- 10 to 0 by -1)
    println(i)

  val str = "Ilya"
  var res : Long = 1
  for (i <- str)
    res = res * i
  println(res)

  var test : Long = str.product
  println(test)

  def product(s: String): Long = {
    var res : Long = 1
    for (i <- s)
      res = res * i
    res
  }

  println(product(str))

  def productRec(s: String): Long = {
    if(s.length == 0) return  1
    productRec(s.substring(0, s.length - 1)) * s(s.length - 1)
  }

  println(productRec(str))

  def ten(x: Int, n: Int): Double ={
    if (n == 0)  1
    else if (n < 0) 1 / ten(x, -n)
    else {
      if (n % 2 == 0){
        val yy = ten(x, n/2)
        yy * yy
      }
      else
        x * ten(x, n-1)
    }
  }

  println(ten(4, -1))

}

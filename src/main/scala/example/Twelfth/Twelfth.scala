package example.Twelfth
import scala.math._

object Twelfth {
  val num = 3.14
  val fun = ceil _ //Присваеваем функцию, _ означает что мы имеем ввиду присвоить функцию
  println(fun(num))
  Array(2.43, 56.3, 3.56).map(fun)

  (x: Double) => x * 3 //Анонимная функция
  def valueAtOneQuarter(f: (Double) => Double) = f(0.25)//Функция высшего порядка - они принимает в качестве аргумента другую функцию

  def mulBy(factor: Double) = (x: Double) => factor * x
  val x5 = mulBy(5)
  println(x5(2))

  (1 to 9).map("*" * _).foreach(println(_))
  (1 to 9).filter(_ % 2 == 0) // 2, 4, 6, 8
  (1 to 9).reduceLeft(_ * _) //1 * 2 * 3 * 4 * 5 * 6 * 7 * 8 * 9
  "Mary had a little lamb".split(" ").sortWith(_.length < _.length) //Array("a", "had", "Mary", "lamb", "little")

  def mul(x: Int, y: Int) = x * y
  def mulOneAtATime(x: Int) = (y: Int) => (z: Int) => z * x * y
  println(mulOneAtATime(2)(3)(4))
  def mulOneAtATime2(x: Int)(y: Int)(z: Int) = x * y * z
  println(mulOneAtATime2(2)(3)(4))

}

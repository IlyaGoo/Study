package example.Fourteenth

object Fourteenth {
  var sign = 0
  val ch: Char = '9'

  ch match {
    case '+' | 'p' => sign = 1
    case '-' => sign = -1
    case _ => sign = 0 //Без _ будет MatchError
  }

  sign = ch match {//Равносильно верхнему
    case '+' | 'p' => 1 //Несколько альтернатив
    case '-' => -1
    case _ if Character.isDigit(ch) => Character.digit(ch, 10)
    case _ => 0
  }
  println(sign)

  var digit = 0
  '8' match {
    case '+' => sign = 1
    case '-' => sign = -1
    case chT => digit = Character.digit(chT, 10)
  }

  sealed trait Colour

  trait Red extends Colour
  trait Green extends Colour
  class RedClass extends Red
  class GreenClass extends Green

  def matchMethod(check: Colour) = {
    check match {
      case _: Red => println("hello this is red")
      case _: Green => println("hello this is green")
    }
  }

  val x: Any = 5
  println(x.getClass())
  def f[T](v: T) = v match {
    case _: Int    => "Int"
    case _: String => "String"
    case _         => "Unknown"
    //cas _: map[int, int] => //Нельзя, потмоу что в jvm затираются дженерики
  }
  println(f(x))

  val arr = Array(0)
  arr match {
    case Array(0) => "0"
    case Array(x, y) => s"$x $y"
    case Array(0, _*) => "0 ..."
    case _ => "something else"
  }

  val (q, r) = BigInt(10) /% 3
  println(q)
  println(r)

  val names = Array("Ilya", "Misha", "Danya")
  val Array(first, second, rest @ _*) = names
  println(first)
}

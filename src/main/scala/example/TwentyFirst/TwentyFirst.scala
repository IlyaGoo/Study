package example.TwentyFirst

object TwentyFirst {
  class Fraction(var num: Int, var den: Int) {
    def *(other: Fraction) = new Fraction(num * other.num, den * other.den)
  }

  object Fraction {
    def apply(n: Int, d: Int) = new Fraction(n, d)

    implicit def int2Fraction(n: Int) = Fraction(n, 1)
    implicit def fraction2Double(f: Fraction) = f.num * 1.0 / f.den
  }

  val result = 3 * Fraction(4, 5) // Вызовет int2Fraction(3)

  case class Delimiters(left: String, right: String)
  def quote(what: String)(implicit delims: Delimiters) =
    delims.left + what + delims.right

  implicit val del = Delimiters("<", ">")
  println(quote("Bonjour le monde")(Delimiters("\"", "\"")))
  println(quote("Bonjour le monde"))

  def smaller[T](a: T, b: T)(implicit order: T => Ordered[T]) = if (a < b) a else b


  implicit def or(another: Fraction) = new Ordered[Fraction]{
    override def compare(that: Fraction): Int = {if(that.den + that.num > another.den + another.num) 1 else -1}
  }

  println(smaller(Fraction(1, 7), Fraction(2, 9)).den)

  class Pair[T : Ordering](val first: T, val second: T) {
    def smaller(implicit ord: Ordering[T]) =
      if (ord.compare(first, second) < 0) first else second
  }

  val p = new Pair(40, 2)
  println(p.smaller)
}

package example.Fourteenth

object CaseClasses {

  sealed abstract class Amount//все наследники должны быть объявлены в том же файле
  case class Dollar(value: Double) extends Amount
  case class Currency(value: Double, unit: String) extends Amount
  case object Nothing extends Amount

  val amt = Currency(29.95, "EUR")
  def check(am: Amount): String = {
    val res = am match {
      case Dollar(v) => s"$$$v"
      case Currency(_, u) => s"Oh noes, I got $u"
      case a Currency u => s"Oh noes, I got $u" // То же, что и case Currency(a, u)
    }
    res
  }
  println(check(amt))

  val price = amt.copy()

  abstract class Item
  case class Article(description: String, price: Double) extends Item
  case class Bundle(description: String, discount: Double, items: Item*) extends Item

  val bundle = Bundle("Father's day special", 20.0,
    Article("Scala for the Impatient", 39.95),
    Bundle("Anchor Distillery Sampler", 10.0,
      Article("Old Potrero Straight Rye Whiskey", 79.95),
      Article("Junípero Gin", 32.95)))

  def checkItem(am: Item): String = {
    val res = am match {
      case Bundle(_, _, Article(descr, _), _*) => descr
    }
    res
  }
  println(checkItem(bundle))

  sealed abstract class TrafficLightColor
  case object Red extends TrafficLightColor
  case object Yellow extends TrafficLightColor
  case object Green extends TrafficLightColor
  def checkColor(col: TrafficLightColor): String = {
    val res = col match {
      case Red => "stop"
      case Yellow => "hurry up"
      case Green => "go"
    }
    res
  }

  println(checkColor(Red))
  
  val n = Some(None)

  val scores = Map("Alice" -> 10, "Bob" -> 3, "Cindy" -> 8)
  val alicesScore = scores.get("Alice")
  alicesScore match {
    case Some(score) => println(score)
    case None => println("No score")
  }

  println(Option(null))

  println(alicesScore.getOrElse("No score"))
  for (score <- alicesScore) println(score)
}

package example.Fourth

object Fourth {
  var scores = Map("Alice" -> 10, "Bob" -> 3, "Cindy" -> 8) //Неизменяемый ассоциативный массив
  val scores2 = scala.collection.mutable.Map("Alice" -> 10, "Bob" -> 3, "Cindy" -> 8)//Изменяемый
  scores = Map(("Allice", 10), ("Bob", 3))

  println(scores("Bob"))
  println(scores.getOrElse("Bob", 0))
  println(scores.getOrElse("Bobb", 0))

  val scores3 = scores.withDefault(_.length)
  val zeldasScore3 = scores2.get("Zelda")

  scores -= "Bob"
  println(scores.getOrElse("Bob", 0))

  for((k, v) <- scores) println(k)

  scores = scala.collection.immutable.SortedMap("Alice" -> 10,
    "Fred" -> 7, "Bob" -> 3, "Cindy" -> 8) //Реализация ассоциативного массива в виде дерева
  println(scores)

  val t = (1, 3.14, "Fred")
  println(t._2)

  val invertScores = for((x, y) <- scores) yield (y, x) //Довольно просто инвертировать ассоциативный массив

  val names = Array("I", "L", "K")
  val numbers = Array(254, 231, 234)
  val pairs = names.zip(numbers)

  for(pair <- pairs)
    println(pair)

  //Упражнения
  val prices = Array(134, 563223, 12341, 1243)
  val pricesWithSales = for(price <- prices) yield price * 0.9
  for(price <- pricesWithSales) println(price)

  def minmax(values: Array[Int]): (Int, Int) = {
    var min, max = values(0)
    for(v <- values) {
      if(v < min)
        min = v
      else if (v > max)
        max = v
      }
    return (min, max)
  }

  println(minmax(Array(0, 2354, 3421, 999999)))

  val test = "Hello".zip("World")
  for (t <- test) println(t)
}

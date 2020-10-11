package example.First

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
}

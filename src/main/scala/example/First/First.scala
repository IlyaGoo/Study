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
}

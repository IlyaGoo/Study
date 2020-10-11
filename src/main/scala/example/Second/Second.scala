package example.Second

object Second {
  val n : Int = if (true) 1 else -1
  println(n)

  val index : Int = { val i1 = 1; val i2 = 2; i1 + i2}//Результатам скобок является значение последнего выражения
  println(index)
}

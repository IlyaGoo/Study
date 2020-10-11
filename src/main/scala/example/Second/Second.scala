package example.Second

object Second {
  val n : Int = if (true) 1 else -1
  println(n)

  val index : Int = { val i1 = 1; val i2 = 2; i1 + i2}//Результатам скобок является значение последнего выражения
  println(index)

  val index2 : Unit = {val t = -1} //операция присвивание это Unit, имеющий единственное значние (пустое)

  for(i <- 1 to 3)
    print(f"n${i} ")
  println()
}

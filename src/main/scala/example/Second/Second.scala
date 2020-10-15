package example.Second
import  scala.io.StdIn._

object Second {
  val n : Int = if (true) 1 else -1
  println(n)

  val index : Int = { val i1 = 1; val i2 = 2; i1 + i2}//Результатам скобок является значение последнего выражения
  println(index)

  val index2 : Unit = {val t = -1} //операция присвивание это Unit, имеющий единственное значние (пустое)

  println(raw"/nsdf$${n}")
  val number = readLine("Любое число: ")

  for(i <- 1 to 3)
    print(f"n${i} ")
  println()

  for(i <- 2 to 3; j <- Range(0, 3, 1) if i != j)
    println(i + " : " + j)

  for (i <- 1 to 10) yield i % 3 // Вернет Vector(1, 2, 0, 1, 2, 0, 1, 2, 0, 1)
}

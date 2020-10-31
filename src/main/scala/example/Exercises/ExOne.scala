package example.Exercises

object ExOne {
  val test = Array.ofDim[Boolean](35, 55)
  val multi : Double = 55/35.0

  /*
  for (i <- test.indices){
    println()
    for(j <- test(i).indices){
      if(i == 0 || j == 0 || i == test.indices.length - 1 || j == test(i).indices.length - 1 ||
        (i - j.toDouble * test.indices.length / test(i).indices.length).abs < s
      || (i - (j.toDouble - 55).abs * test.indices.length / test(i).indices.length).abs < s ) test(i)(j) = true
      if(test(i)(j)) print("1") else print("0")
    }
  }
*/

  for (i <- 0 to 54){
    val x = math.min((i / multi).toInt, 34)
    test(x)(i) = true
    test(x)(54 - i) = true
    test(0)(i) = true
    test(34)(i) = true
  }
  for (i <- 0 to 34){
    test(i)(0) = true
    test(i)(54) = true
  }

  for (i <- test.indices){
    println()
    for (j <- test(0).indices)
      if(test(i)(j)) print("1") else print("0")
  }
}

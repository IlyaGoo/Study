package example.Fifteenth

import scala.beans.BeanProperty

object Fifteenth {

  @BeanProperty //Автоматическое создание методов чтения и записи
  var a = 0
    //@Test(timeout = 100, expected = classOf[IOException]) //Аннотации могут иметь аргументы

  @deprecated def justPrint(s: String): Unit ={
    println(s)
  }

  justPrint("Qwer")
}

package example.Fifth

object Fifth {
  class Counter {
    private var value = 0 // Поля должны инициализироваться, поле приватное но доступно методами из всех экземпляров
    private[this] var privateValue = 0 // Поле приватное и доступно только внутри одного экземпляра
    def increment() { if(value != Int.MaxValue) value += 1 } // Методы по умолчанию общедоступные
    def current = value //Без скобок вынуждены вызывать без скобок

    def this(startCount: Int){ //Конструкторы именнуются this
      this() //Конструктор начинается с вызова конструктора выше или главного конструктора
      this.value = startCount
    }
  }

  val myCounter = new Counter
  myCounter.increment()
  println(myCounter.current)


  class Person private(val name: String, val age: Int, surname: String) { //Главный конструктор сразу сделает это полями
    //surname не обозначено как val или var и если оно не будет использовано в методах, оно останется обычным полем, доступным только внутри главного кнструктора
    class Health{ //Для разных Person Health - разные классы

    }
  }

  //Упражнения
  class BankAccount{
    private[this] var current: Int = 0
    def balance = current

    def deposit(count: Int): Unit ={
      current += count;
    }

    def withdraw(count: Int): Unit ={
      current -= count;
    }
  }
}

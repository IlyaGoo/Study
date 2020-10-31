package example.Sixth

object Sixth {
  object Accounts { //Синглтон
    private var lastNumber = 0
    def newUniqueNumber() = { lastNumber += 1; lastNumber }
  }

  class BankAccount{
    private[this] var current: Int = 0
    def balance = current
    val id = BankAccount.newUId

    def this(startBalance: Int){
      this()
      this.current = startBalance
    }

    def deposit(count: Int): Unit = { current += count }

    def withdraw(count: Int): Unit = { current -= count }

    def apply(startBalance: Int): BankAccount = new BankAccount(startBalance)//Теперь можно создать банковыский счет так: BankAccount(45)

  }

  object BankAccount{ //Объект-компаньон, находится за пределами области видимости класса
    private  var lastNumber = 0
    private def newUId = {lastNumber += 1; lastNumber}
  }

  object ColorEnumeration extends Enumeration{
    val Red, Green, Blue = Value
  }
}

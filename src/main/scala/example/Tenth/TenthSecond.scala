package example.Tenth

object TenthSecond {

  trait LoggerSecond {
    def log(msg: String) // Это - абстрактный метод
    def info(msg: String) { log(s"INFO: $msg") }
    def warn(msg: String) { log(s"WARN: $msg") }
    def severe(msg: String) { log(s"SEVERE: $msg") }
  }

  trait TimestampLogger extends LoggerSecond {
    abstract override def log(msg: String) { // Переопределяет абстрактный метод
      super.log(s"${java.time.Instant.now()} $msg") // super.log определен?
    }
  }

  trait ShortLoggerSecond extends LoggerSecond {
    val maxLength = 15 // Конкретное поле
    val abstractLength: Int //Абстрактное поле
    abstract override def log(msg: String) {
      super.log(
        if (msg.length <= maxLength) msg
        else s"${msg.substring(0, maxLength - 3)}...")
    }
  }

  class AccountSecond{
    var balance = 0
  }

  class SavingsAccountSecond extends AccountSecond with LoggerSecond {
    def withdraw(amount: Int) {
      if (amount > balance) severe("Insufficient funds")
      else balance -= amount
    }

    override def log(msg: String): Unit = ???
  }

  val acct = new SavingsAccountSecond with ShortLoggerSecond {
    val abstractLength: Int = 20
  }

}

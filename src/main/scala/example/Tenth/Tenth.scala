package example.Tenth

object Tenth {
  trait Logger {//Может работать как обычный интерфейс java
    def log(msg: String) // Абстрактный метод
    def logRealised(msg: String) { println(msg) } //Можем реализовать
  }

  trait ConsoleLogger extends Logger with Cloneable { // extends, не implements
    def log(msg: String) { println(msg) } // override не нужно
  }

/*  val myLogger = new ConsoleLogger
  myLogger.logRealised("Lol it works")*/

  class Account{
    var balance = 0
  }

  abstract class SavingsAccount extends Account with Logger {
    def withdraw(amount: Int) {
      if (amount > balance) log("Insufficient funds")
      else balance -= amount
    }
  }

  val acct = new SavingsAccount with ConsoleLogger
  acct.log("Lol it works")

  trait TimestampLogger extends ConsoleLogger {
    override def log(msg: String) {
      super.log(s"${java.time.Instant.now()} $msg")
    }
  }

  trait ShortLogger extends ConsoleLogger {
    override def log(msg: String) {
      super.log(
        if (msg.length <= 15) msg else s"${msg.substring(0, 12)}..."
      )
    }
  }

  val acct1 = new SavingsAccount with TimestampLogger with ShortLogger
  val acct2 = new SavingsAccount with ShortLogger with TimestampLogger

  acct1.log("Qwertyuiopasdfghjkl")
  acct2.log("Qwertyuiopasdfghjkl")
}

package example.Tenth

import javafx.scene.media.MediaException.Type
import javax.swing.JFrame
import org.omg.CORBA.Any

import scala.collection.mutable

object TenthSecond {

  trait Logger {
    def log(msg: String) // Это - абстрактный метод
    def info(msg: String) { log(s"INFO: $msg") }
    def warn(msg: String) { log(s"WARN: $msg") }
    def severe(msg: String) { log(s"SEVERE: $msg") }
  }

  trait TimestampLogger extends Logger {
    abstract override def log(msg: String) { // Переопределяет абстрактный метод
      super.log(s"${java.time.Instant.now()} $msg") // super.log определен?
    }
  }

  trait ShortLoggerSecond extends Logger {
    val maxLength = 15 // Конкретное поле
    val abstractLength: Int //Абстрактное поле
    abstract override def log(msg: String) {
      super.log(
        if (msg.length <= maxLength) msg
        else s"${msg.substring(0, maxLength - 3)}...")
    }
  }

  trait ShortLoggerExtended extends  ShortLoggerSecond{
    val abstractLength = 2
  }

  trait ConsoleLogger extends Logger {
    def log(msg: String) { println(msg) }
  }

  abstract class Account{
    var balance = 0
  }

  abstract class SavingsAccount extends Account with Logger {
    def withdraw(amount: Int) {
      if (amount > balance) severe("Insufficient funds")
      else balance -= amount
    }
  }

  val acct = new SavingsAccount with ConsoleLogger {
    val abstractLength: Int = 20
  }

  trait LoggedException extends Logger {
    this: Exception => //Собственный тип
    def log() { log(getMessage()) }
  }

  class UnhappyException extends Exception with LoggedException { // Наследует трейт
    override def getMessage() = "arggh!"
    override def log(msg: String): Unit = ???
  }

  class UnhappyException2 extends IndexOutOfBoundsException with LoggedException{//Имеем одинаковый суперкласс
    override def log(msg: String): Unit = ???
  }

/*  class UnhappyFrame3 extends Account with LoggedException{ //Так делать нельзя, потому что имеет два суперкласса
    override def log(msg: String): Unit = ???
  }*/


}

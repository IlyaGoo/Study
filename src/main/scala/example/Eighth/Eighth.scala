package example.Eighth

import scala.util.Random

object Eighth {

  abstract class Humanoid{
    val id: Int
  }

  class Person(val name: String) extends Humanoid {
    val id = 3//Random.nextInt() //При переопределении абстрактного метода можно не писать override
    protected var age: Int = 0
    override def toString = s"${getClass.getName}[name=$name]"

    final override def equals(obj: Any): Boolean = {
      obj.isInstanceOf[Person] && {
        val objAsPerson = obj.asInstanceOf[Person]
        objAsPerson.id == id && objAsPerson.name == name && objAsPerson.age == age
      }
    }

    final override def hashCode(): Int = (id, age, name).##
  }

  class Employee(name: String, val nickname: String) extends Person(name) {
    override def toString: String = super.toString + s"[name=$nickname]"
  }

  class SecretAgent(codename: String) extends Person(codename) {
    override val name = "secret" // Скрыть имя ...
    override val toString = "secret" // ... и имя класса
  }

  val alien = new Person("Fred") {
    def greeting = "Greetings, Earthling! My name is Fred."
  }

  val Ilya = new Person("Илья")
  println(Ilya.toString)
  val IlyaUser = new Employee("Илья","IlyaGo")
  println(IlyaUser.toString)

  println(IlyaUser.isInstanceOf[Employee])
  println(IlyaUser.isInstanceOf[Person])
  println(Ilya.isInstanceOf[Employee])
  println(Ilya.isInstanceOf[Person])
  println(IlyaUser.getClass == classOf[Person])

  val IlyaUserToPerson = Ilya.asInstanceOf[Person]
  println(IlyaUserToPerson.toString)

  println(alien.greeting)
  println(Ilya.equals(new Person("Илья")))

  class MilTime(val time: Int) extends AnyVal {
    def minutes = time % 100
    def hours = time / 100
    override def toString = f"$time"
  }

  object MilTime{
    def apply(t: Int): MilTime =
      if (0 <= t && t < 2400 && t % 100 < 60) new MilTime(t)
      else throw new IllegalArgumentException
  }

  var lunch = new MilTime(1230)
  println(lunch.hours)
}

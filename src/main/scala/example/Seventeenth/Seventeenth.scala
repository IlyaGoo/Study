package example.Seventeenth

import scala.concurrent.duration._
import java.time._

import scala.concurrent._
import ExecutionContext.Implicits.global
import scala.util._

object Seventeenth {

  val f = Future {
    println(s"This is the future at ${LocalTime.now}")
  }
  f
  println(f.isCompleted)
  //val result = Await.result(f, 10.seconds)
  println(s"This is the present at ${LocalTime.now}")

  val result = Try("123".toInt)

  def tryMatch(t: Try[Int]): Unit ={
    t match {
      case Success(v) => println(s"The answer is $v")
      case Failure(ex) => println(ex.getMessage)
    }
  }

  def tryMatch2(t: Try[Int]): Unit ={
    if (t.isSuccess) println(s"The answer is ${t.get}")
    if (t.isFailure) println(t.failed.get.getMessage)
  }

  tryMatch(result)
}

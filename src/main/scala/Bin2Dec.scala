import scala.annotation.tailrec

object Bin2Dec extends App {

  inputLoop()

  @tailrec
  def inputLoop(): Unit = {
    try {
      val userNum = scala.io.StdIn.readLine("Enter a binary number (up to 8 digits): ")
      val binaryNum: BinaryNum = BinaryNum(userNum)
      println(s"The decimal version of $userNum is ${binaryNum.toDecimal()}")
    } catch {
      case e: IllegalArgumentException => {
        println(s"Sorry, that is not a valid entry. (${e.getMessage})")
        inputLoop()
      }
    }
  }
}

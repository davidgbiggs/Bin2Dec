import scala.annotation.tailrec

object BinaryInput {
  @tailrec
  def inputLoop(): Unit = {
    try {
      val userNum = scala.io.StdIn.readLine("Enter a binary number (up to 64 digits): ")
      val binaryNum: BinaryNumber = BinaryNumber(userNum)
      println(s"The decimal version of $userNum is ${binaryNum.toDecimal()}")
    } catch {
      case e: IllegalArgumentException => {
        println(s"Sorry, that is not a valid entry. (${e.getMessage})")
        inputLoop()
      }
    }
  }
}

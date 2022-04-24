import BinaryNum.testInvalid
import scala.annotation.tailrec

case class BinaryNum(private val numString: String) {
  testInvalid(numString) match {
    case Some(TooLong) => throw new IllegalArgumentException("Too Long")
    case Some(BadCharacter) => throw new IllegalArgumentException("Bad Character")
    case _ =>
  }

  @tailrec
  final def toDecimal(num: String = numString.reverse, total: Int = 0, place: Int = 1): Int = {
    if (num.nonEmpty) {
      num.head match {
        case '0' => toDecimal(num.tail, total, place*2)
        case '1' => toDecimal(num.tail, place + total, place*2)
      }
    } else {
      total
    }
  }
}

object BinaryNum {
  private def testInvalid(num: String): Option[InvalidMessage] = {
    val invalidPattern = "[^01]".r
    val foundInvalidChar = invalidPattern.findFirstMatchIn(num) match {
      case Some(_) => true
      case None => false
    }

    if (foundInvalidChar) {
      Some(BadCharacter)
    } else if (num.length > 8) {
      Some(TooLong)
    } else {
      None
    }
  }
}
import org.scalatest._
import flatspec._
import matchers._

class BinaryNumberSpec extends AnyFlatSpec with should.Matchers {
  "Binary Number" should "return the correct decimal value" in {
    val testNumber = BinaryNumber("10101010")
    assertResult(170)(testNumber.toDecimal())
  }

  it should "throw an IllegalArgumentException when instantiated with greater than 64 characters" in {
    val longString = "10" * 32
    an [IllegalArgumentException] should be thrownBy {
      BinaryNumber(longString)
    }
  }

  it should "throw an IllegalArgumentException when constructed with invalid characters" in {
    an [IllegalArgumentException] should be thrownBy {
      BinaryNumber("10401010")
    }
  }
}

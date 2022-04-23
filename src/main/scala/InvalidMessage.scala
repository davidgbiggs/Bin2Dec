sealed trait InvalidMessage
case object BadCharacter extends InvalidMessage
case object TooLong extends InvalidMessage

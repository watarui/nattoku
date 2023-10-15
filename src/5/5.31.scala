case class Event(name: String, start: Int, end: Int)

// def parse(name: String, start: Int, end: Int): Option[Event] =
//   if (name.size > 0 && end < 3000 && start <= end)
//     Some(Event(name, start, end))
//   else None

def validateName(name: String): Option[String] =
  if (name.size > 0) Some(name)
  else None

def validateEnd(end: Int): Option[Int] =
  if (end < 3000) Some(end)
  else None

def validateStart(start: Int, end: Int): Option[Int] =
  if (start >= end) Some(start)
  else None

def parse(name: String, start: Int, end: Int): Option[Event] =
  for {
    validName <- validateName(name)
    validEnd <- validateEnd(end)
    validStart <- validateStart(start, validEnd)
  } yield Event(validName, validStart, validEnd)

def validateLength(start: Int, end: Int, minLength: Int): Option[Int] =
  val length = end - start
  if (length >= minLength) Some(length)
  else None

def parseLongEvent(
    name: String,
    start: Int,
    end: Int,
    minLength: Int
): Option[Event] =
  for {
    validEvent <- parse(name, start, end)
    validLength <- validateLength(start, end, minLength)
  } yield validEvent

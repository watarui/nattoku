def firstTwo(ss: List[String]): List[String] =
  ss.slice(0, 2)

def lastTwo(ss: List[String]): List[String] =
  ss.slice(ss.size - 2, ss.size)

def moveFirstTwoToTheEnd(ss: List[String]): List[String] =
  val ft = firstTwo(ss)
  val rest = ss.slice(2, ss.size)
  rest.appendedAll(ft)

def insertedBeforeLast(ss: List[String], s: String): List[String] =
  ss
    .slice(0, ss.size - 1)
    .appended(s)
    .appended(lastTwo(ss)(1))

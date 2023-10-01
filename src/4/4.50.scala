def largerThan(n: Int)(i: Int): Boolean = i > n

val a1 = List(1, 2, 3, 4, 5).filter(largerThan(2))

def divisibleBy(n: Int)(i: Int): Boolean = i % n == 0

val a2 = List(1, 2, 3, 4, 5).filter(divisibleBy(2))

def smallerThan(n: Int)(s: String): Boolean = s.length < n

val a3 = List("a", "ab", "abc", "abcd").filter(smallerThan(3))

def containsS(n: Int)(s: String): Boolean =
  s.length - s.replaceAll("s", "").length > n

val a4 = List("a", "ab", "abc", "abcd").filter(containsS(1))

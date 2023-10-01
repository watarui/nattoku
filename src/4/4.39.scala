def score(word: String) = word.replaceAll("a", "").length

def bonus(word: String) = if (word.contains("c")) 5 else 0

def penalty(word: String) = if (word.contains("s")) 7 else 0

val words = List("haskell", "rust", "scala", "java", "ada")

def highScoringWords(
    wordScore: String => Int,
    words: List[String]
): Int => List[String] =
  higherThan => words.filter(word => wordScore(word) > higherThan)

val wordsWithScoreHigherThan =
  highScoringWords(w => score(w) + bonus(w) - penalty(w), words)

def largerThan(n: Int): Int => Boolean = i => i > n

def divisibleBy(n: Int): Int => Boolean = i => i % n == 0

def shorterThan(n: Int): String => Boolean = s => s.length < n

def numberOfS(s: String): Int = s.length - s.replaceAll("s", "").length

def containsS(moreThan: Int): String => Boolean = s => numberOfS(s) > moreThan

def highScoringWords2(
    wordScore: String => Int
): Int => List[String] => List[String] =
  higherThan => words => words.filter(word => wordScore(word) > higherThan)

val wordsWithScoreHigherThan2 =
  highScoringWords2(w => score(w) + bonus(w) - penalty(w))

val a1 = wordsWithScoreHigherThan2(20)(words)

def highScoringWords3(wordScore: String => Int)(higherThan: Int)(
    words: List[String]
): List[String] =
  words.filter(word => wordScore(word) > higherThan)

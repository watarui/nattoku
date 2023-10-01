def rankedWords(wordScore: String => Int, words: List[String]) =
  words.sortBy(wordScore).reverse

def score(word: String) = word.replaceAll("a", "").length

val words = List("haskell", "rust", "scala", "java", "ada")

def scoreWithBonus(word: String) =
  val base = score(word)
  if (word.contains("c")) base + 5
  else base

def bonus(word: String) = if (word.contains("c")) 5 else 0

def penalty(word: String) = if (word.contains("s")) 7 else 0

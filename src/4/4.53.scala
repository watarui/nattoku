def cumulativeScore(wordScore: String => Int, words: List[String]): Int =
  words.foldLeft(0)((total, word) => total + wordScore(word))

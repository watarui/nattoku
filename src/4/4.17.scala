def len(s: String) = s.length

val langs = List("scala", "rust", "ada")

def numberOfS(s: String) = s.length - s.replaceAll("s", "").length

def negative(i: Int) = -i

def negativeNumberOfS(s: String) = -numberOfS(s)

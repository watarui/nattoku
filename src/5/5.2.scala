case class Book(title: String, authors: List[String])

val books = List(
  Book("FP in Scala", List("Chiusano", "Bjarnason")),
  Book("The Hobbit", List("Tolkien"))
)

def recommendationFeed(books: List[Book]) = ???

def recommendedBooks(friend: String): List[Book] = {

  val scala = List(
    Book("FP in Scala", List("Chiusano", "Bjarnason")),
    Book("Scala for the Impatient", List("Horstmann")),
    Book("Scala in Depth", List("Suereth"))
  )
  val fiction = List(
    Book("The Hobbit", List("Tolkien")),
    Book("The Lord of the Rings", List("Tolkien")),
    Book("The Silmarillion", List("Tolkien"))
  )

  if (friend == "Alice") scala
  else if (friend == "Bob") fiction
  else List.empty
}

val friends = List("Alice", "Bob", "Charlie")

val recommendations = friends.flatMap(recommendedBooks)

val authors = recommendations.flatMap(_.authors)

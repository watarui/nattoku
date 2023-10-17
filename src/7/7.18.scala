case class User(
    name: String,
    city: Option[String],
    favoriteArtists: List[String]
)

val users = List(
  User("Alice", Some("Melbourne"), List("Bee Gees")),
  User("Bob", Some("Lagos"), List("Bee Gees")),
  User("Eve", Some("Tokyo"), List.empty),
  User("Mallory", None, List("Metallica", "Bee Gees")),
  User("Trent", Some("Buenos Aires"), List("Led Zeppelin"))
)

def f1(users: List[User]): List[User] =
  users.filter(_.city.forall(_ == "Melbourne"))

def f2(users: List[User]): List[User] =
  users.filter(_.city.contains("Lagos"))

def f3(users: List[User]): List[User] =
  users.filter(_.favoriteArtists.contains("Bee Gees"))

def f4(users: List[User]): List[User] =
  users.filter(_.city.exists(_.startsWith("T")))

def f5(users: List[User]): List[User] =
  users.filter(_.favoriteArtists.forall(_.length > 8))

def f6(users: List[User]): List[User] =
  users.filter(_.favoriteArtists.exists(_.startsWith("M")))

opaque type Location = String

object Location {
  def apply(s: String): Location = s
  extension (l: Location) def name: String = l
}

// case class PeriodInYears(start: Int, end: Option[Int])

enum MusicGenre {
  case HeavyMetal
  case Pop
  case HardRock
}

enum YearsActive {
  case StillActive(since: Int)
  case ActiveBetween(start: Int, end: Int)
}

case class Artist(
    name: String,
    genre: MusicGenre,
    origin: Location,
    yearActive: YearsActive
)

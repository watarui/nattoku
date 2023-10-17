case class Artist(
    name: String,
    genre: String,
    origin: String,
    yearsActiveStart: Int,
    isActive: Boolean,
    yearsActiveEnd: Int
)

// def searchArtists(
//     artists: List[Artist],
//     genres: List[String],
//     locations: List[String],
//     searchByActiveYears: Boolean,
//     activeAfter: Int,
//     activeBefore: Int
// ): List[Artist] =
//   artists
//     .filter(artist => genres.contains(artist.genre))
//     .filter(artist => locations.contains(artist.origin))
//     .filter(artist => !searchByActiveYears || artist.isActive)
//     .filter(artist =>
//       !searchByActiveYears || artist.yearsActiveStart >= activeAfter
//     )
//     .filter(artist =>
//       !searchByActiveYears || artist.yearsActiveEnd <= activeBefore
//     )

val artists = List(
  Artist("Metallica", "Heavy Metal", "U.S.", 1981, true, 0),
  Artist("Led Zeppelin", "Hard Rock", "England", 1968, false, 1980),
  Artist("Bee Gees", "Pop", "England", 1958, false, 2003)
)

// val res = searchArtists(
//   artists,
//   List("Heavy Metal", "Pop"),
//   List("England"),
//   true,
//   1970,
//   2000
// )

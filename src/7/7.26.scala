def searchArtists(
    artists: List[Artist],
    genres: List[MusicGenre],
    locations: List[Location],
    searchByActiveYears: Boolean,
    activeAfter: Int,
    activeBefore: Int
): List[Artist] = artists.filter(artist =>
  (genres.isEmpty || genres.contains(
    artist.genre
  )) && (locations.isEmpty || locations.contains(
    artist.origin
  )) && (!searchByActiveYears || wasArtistActive(
    artist,
    activeAfter,
    activeBefore
  ))
)

def wasArtistActive(artist: Artist, yearStart: Int, yearEnd: Int): Boolean =
  artist.yearActive match
    case YearsActive.StillActive(since) => since <= yearEnd
    case YearsActive.ActiveBetween(start, end) =>
      start <= yearEnd && end >= yearStart

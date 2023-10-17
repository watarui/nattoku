def activeLength(artist: Artist, year: Int): Int = artist.yearActive match
  case YearsActive.StillActive(since)        => year - since
  case YearsActive.ActiveBetween(start, end) => end - start

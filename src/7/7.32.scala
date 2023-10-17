object model:
  opaque type User = String
  object User:
    def apply(s: String): User = s

  opaque type Artist = String
  object Artist:
    def apply(s: String): Artist = s

  case class Song(artist: Artist, title: String)

  enum MusicGenre:
    case House
    case Funk
    case HipHop

  case class Playlist(name: String, kind: PlaylistKind, songs: List[Song])

  enum PlaylistKind:
    case CuratedByUser(name: User)
    case BasedOnArtist(name: Artist)
    case BasedOnGenres(genres: Set[MusicGenre])

  val fooFighters = Artist("Foo Fighters")
  val playlist1 = Playlist(
    "This is Foo Fighters",
    BasedOnArtist(fooFighters),
    List(Song(fooFighters, "Breakout"), Song(fooFighters, "Learn To Fly"))
  )

  val playlist2 = Playlist(
    "Deep Focus",
    BasedOnGenres(Set(House, Funk)),
    List(
      Song(Artist("Daft Punk"), "One More Time"),
      Song(Artist("The Chemical Brothers"), "Hey Boy Hey Girl")
    )
  )
  val playlist3 = Playlist(
    "My Playlist",
    CuratedByUser(User("Michał Płachta")),
    List(
      Song(fooFighters, "My Hero"),
      Song(Artist("Iron Maiden"), "The Trooper")
    )
  )

  def gatherSongs(
      playlists: List[Playlist],
      artist: Artist,
      genre: MusicGenre
  ): List[Song] =
    playlists.foldLeft(List.empty[Song])((acc, playlist) =>
      val matchingSongs = playlist.kind match
        case PlaylistKind.CuratedByUser(name) =>
          playlist.songs.filter(_.artist == artist)
        case PlaylistKind.BasedOnArtist(name) =>
          if name == artist then playlist.songs else List.empty
        case PlaylistKind.BasedOnGenres(genres) =>
          if genres.contains(genre) then playlist.songs else List.empty
      acc ++ matchingSongs
    )

case class TvShow(name: String, start: Int, end: Int)

def parseShow(rawShow: String): Either[String, TvShow] =
  for {
    name <- extractName(rawShow)
    yearStart <- extractYearStart(rawShow)
    yearEnd <- extractYearEnd(rawShow)
  } yield TvShow(name, yearStart, yearEnd)

def extractName(rawShow: String): Either[String, String] =
  val bracketOpen = rawShow.indexOf('(')
  if (bracketOpen > 0) Right(rawShow.substring(0, bracketOpen).trim)
  else Left(s"Can't extract name from $rawShow")

def extractYearStart(rawShow: String): Either[String, Int] =
  val bracketOpen = rawShow.indexOf('(')
  val dash = rawShow.indexOf('-')

  for {
    yearStr <-
      if (bracketOpen != -1 && dash > bracketOpen + 1)
        Right(rawShow.substring(bracketOpen + 1, dash))
      else Left(s"Can't extract year start from $rawShow")
    year <- yearStr.toIntOption.toRight(s"Can't parse $yearStr")
  } yield year

def extractYearEnd(rawShow: String): Either[String, Int] =
  val bracketClose = rawShow.indexOf(')')
  val dash = rawShow.indexOf('-')

  for {
    yearStr <-
      if (dash != -1 && bracketClose > dash + 1)
        Right(rawShow.substring(dash + 1, bracketClose))
      else Left(s"Can't extract year end from $rawShow")
    year <- yearStr.toIntOption.toRight(s"Can't parse $yearStr")
  } yield year

def parseShows(rawShows: List[String]): Either[String, List[TvShow]] =
  val initialResult: Either[String, List[TvShow]] = Right(List.empty)
  rawShows.map(parseShow).foldLeft(initialResult) { (result, parsedShow) =>
    for {
      shows <- result
      show <- parsedShow
    } yield show :: shows
  }

def sortShows(shows: List[TvShow]): List[TvShow] =
  shows.sortBy(tvShow => tvShow.end - tvShow.start).reverse

def sortRawShows(rawShows: List[String]): List[TvShow] =
  sortShows(parseShows(rawShows))

def extractSingleYear(rawShow: String): Either[String, Int] =
  val dash = rawShow.indexOf('-')
  val bracketOpen = rawShow.indexOf('(')
  val bracketClose = rawShow.indexOf(')')

  for {
    yearStr <-
      if (dash == -1 && bracketOpen != -1 && bracketClose > bracketOpen + 1)
        Right(rawShow.substring(bracketOpen + 1, bracketClose))
      else Left(s"Can't extract single year from $rawShow")
    year <- yearStr.toIntOption.toRight(s"Can't parse $yearStr")
  } yield year

def extractSingleYearOrYearEnd(rawShow: String): Option[Int] =
  extractSingleYear(rawShow).orElse(extractYearEnd(rawShow))

def extractAnyYear(rawShow: String): Option[Int] =
  extractYearStart(rawShow)
    .orElse(extractYearEnd(rawShow))
    .orElse(extractSingleYear(rawShow))

def extractSingleYearIfNameExists(rawShow: String): Option[Int] =
  extractName(rawShow).flatMap(_ => extractSingleYear(rawShow))

def extractAnyYearIfNameExists(rawShow: String): Option[Int] =
  extractName(rawShow).flatMap(_ => extractAnyYear(rawShow))

def addOrResign(
    parsedShows: Option[TvShow],
    newParsedShows: Option[TvShow]
): Option[TvShow] =
  parsedShows.map(tvShow =>
    if (tvShow.name.endsWith(" (US)"))
      tvShow.copy(name = tvShow.name.dropRight(5))
    else tvShow.copy(name = tvShow.name + " (US)")
  )

case class ProgrammingLanguage(name: String, year: Int)

val javalang = ProgrammingLanguage("Java", 1995)
val scalaLang = ProgrammingLanguage("Scala", 2003)

val languages = List(javalang, scalaLang)

val l1 = languages.map(_.name)

val l2 = languages.filter(_.year > 2000)

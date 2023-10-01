val x = List(
  "scala",
  "rust",
  "ada"
).map(x => x.length - x.replaceAll("s", "").length)
// ).map(x => x.length - x.replaceAll("s", "").length)

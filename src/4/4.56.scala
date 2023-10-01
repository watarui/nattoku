val a1 = List(5, 1, 2, 4, 100).foldLeft(0)(_ + _)

val a2 = List("scala", "rust", "ada").foldLeft(0)((acc, x) => x.length + acc)

val a3 = List("scala", "haskell", "rust", "ada").foldLeft(0)((acc, cur) =>
  cur.length - cur.replaceAll("s", "").length + acc
)

val a4 = List(1, 2, 3, 4, 5).foldRight(Int.MinValue)(_ max _)

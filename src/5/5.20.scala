case class Point(x: Int, y: Int)

val points = List(Point(5, 2), Point(1, 1))

val radiuses = List(2, 1)
val riskyRadiuses = List(-10, 0, 2)

def isInside(point: Point, radius: Int): Boolean = {
  radius * radius >= point.x * point.x + point.y * point.y
}

def insideFilter(point: Point, radius: Int): List[Point] = {
  if (isInside(point, radius)) List(point)
  else List.empty
}

def validateRadius(radius: Int): List[Int] = {
  if (radius > 0) List(radius)
  else List.empty
}

val s = for {
  radius <- riskyRadiuses
  validRadius <- validateRadius(radius)
  point <- points
  inPoint <- insideFilter(point, validRadius)
} yield s"$inPoint is within a radius of $radius"

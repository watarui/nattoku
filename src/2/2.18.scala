object ShoppingCart {

  def getDiscountPercentage(items: List[String]): Int =
    if (items.contains("Book")) 5
    else 0

}

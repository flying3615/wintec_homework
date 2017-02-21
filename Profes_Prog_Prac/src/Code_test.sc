sealed abstract class Item

case class Article(description:String,price:Double) extends Item
case class Bundle(description:String,discount:Double,item:Item*) extends Item

val composedBundle = Bundle("Father's day special",20.0,
  Article("Scala for the Impatient",39.95),
  Bundle("Another Distillery Sample",10.0,
    Article("Old Potrero Straight Rye Whisky",79.95),
    Article("Junipero Gin",32.95)
  )
)

def price(it:Item):Double = it match {
  case Article(_,p) => p
  case Bundle(_,disc,its @ _*) => its.map(price _).sum - disc
}

println(price(composedBundle))
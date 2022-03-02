abstract class IntSet {
  def contains(x: Int): Boolean

  def incl(x: Int): IntSet

  def union(other: IntSet): IntSet

}

object Empty extends IntSet {
  override def contains(x: Int): Boolean = false

  override def incl(x: Int): IntSet =
    new NonEmpty(x, Empty, Empty)

  override def toString: String = "."

  override def union(other: IntSet) = other
}


class NonEmpty(e: Int, l: IntSet, r: IntSet) extends IntSet {
  override def contains(x: Int): Boolean = {
    if (x < e) l.contains(x)
    else if (x > e) r.contains(x)
    else true
  }

  override def incl(x: Int): IntSet = {
    if (x < e) new NonEmpty(e, l.incl(x), r)
    else if (x > e) new NonEmpty(e, l, r.incl(x))
    else this
  }

  override def toString: String = s"{ $l / $e \\ $r }"

  override def union(other: IntSet) =
    l.union(r).union(other).incl(e)

}

println("Welcome to the intsets Scala wroksheet")
val t1 = new NonEmpty(3, Empty, Empty)
val t2 = t1.incl(5)
val t3 = new NonEmpty(10, new NonEmpty(2, Empty, Empty), new NonEmpty(6, Empty, Empty))

println(t1)
println(t2)
println(t1.union(t3))
println(t3.union(t1))

import java.util.NoSuchElementException
import scala.annotation.tailrec

trait List[T] {
  def isEmpty: Boolean

  def head: T

  def tail: List[T]

  def nth(n: Int): T
}

class Cons[T](val head: T, val tail: List[T]) extends List[T] {
  override def isEmpty = false

  override def nth(n: Int): T = {
    @tailrec
    def nthRec(l: List[T], n: Int): T =
      if (n == 0) l.head
      else nthRec(l.tail, n - 1)

    nthRec(this, n)
  }
}

class Nil[T] extends List[T] {
  override def isEmpty = true

  override def head =
    throw new NoSuchElementException("Nil.head")

  override def tail =
    throw new NoSuchElementException("Nil.tail")

  override def nth(n: Int): T =
    throw new IndexOutOfBoundsException(s"Nil.nth($n)")
}

println("Welcome to the intsets Scala wroksheet")
val list = new Cons(1, new Cons(2, new Cons(3, new Nil())))
println(list.nth(5))

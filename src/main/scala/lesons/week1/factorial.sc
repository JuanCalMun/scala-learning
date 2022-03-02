import scala.annotation.tailrec

def factorialTailRec(n: Double): Double = {
  @tailrec
  def loop(acc: Double, n: Double): Double =
    if (n == 0) acc
    else loop(n * acc, n - 1)

  loop(1, n)
}

factorialTailRec(4)
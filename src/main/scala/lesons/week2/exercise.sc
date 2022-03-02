object exercise {

  def product(f: Double => Double)(a: Double, b: Double): Double =
    if (a > b) 1
    else f(a) * product(f)(a + 1, b)

  def factorial(n: Double) = product(x => x)(1, n)

  def mapReduce(f: Double => Double, combine: (Double, Double) => Double, zero: Double)(a: Double, b: Double): Double =
    if (a > b) zero
    else combine(f(a), mapReduce(f, combine, zero)(a + 1, b))

  def productImproved(f: Double => Double)(a: Double, b: Double): Double =
    mapReduce(f, _ * _, 1)(a, b)

  def factorialImproved(n: Double) =
    mapReduce(x => x, _ * _, 1)(1, n)


  product(x => x * x)(3, 4)
  productImproved(x => x * x)(3, 4)

  factorial(155)
  factorialImproved(155)
}
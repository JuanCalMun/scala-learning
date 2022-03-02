object testingObjects {

  val u = new Rational(60, 6)
  val v = new Rational(30, 3)
  val w = new Rational(1, 3)
  val x = new Rational(1, 3)
  val y = new Rational(5, 7)
  val z = new Rational(3, 2)

  x + x
  x + y
  x - y
  -y

  x - y - z
  y + y

  x > v // false
  y > x // true
  w == x // true


  z > x
  z.max(x)
  x.max(z)

  v == u //true

  new Rational(2, 0)


  class Rational(x: Int, y: Int = 1) {

    require(y != 0, "denominator must be non zero")

    private val g = gcd(x, y)
    private val numer = x / g
    private val denom = y / g

    def unary_- : Rational = new Rational(-numer, denom)

    def +(that: Rational): Rational =
      new Rational(
        numer * that.denom + that.numer * denom,
        denom * that.denom
      ).gdc


    def -(that: Rational): Rational = this + -that

    def gdc: Rational =
      new Rational(numer, denom)

    def <(that: Rational): Boolean = this.numer * that.denom - that.numer * this.denom < 0

    def >(that: Rational): Boolean = !(this < that)

    def ==(that: Rational): Boolean =
      this.gdc.numer == that.gdc.numer &&
        this.gdc.denom == that.gdc.denom

    def max(that: Rational): Rational =
      if (this > that) this
      else that

    override def toString: String = s"$x/$y"

    private def gcd(a: Int, b: Int): Int =
      if (b == 0) a
      else gcd(b, a % b)

  }
}


package exercises.week1.recfun

import scala.annotation.tailrec

object RecFun extends RecFunInterface {

  def main(args: Array[String]): Unit = {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      print("\t".repeat(10 - row))
      for (col <- 0 to row)
        print(s"\t${pascal(col, row)}\t")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int =
    if (c == 0 || c == r) 1
    else pascal(c - 1, r - 1) + pascal(c, r - 1)

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    @tailrec
    def balanceRec(acc: Int, chars: List[Char]): Boolean = {
      if (acc < 0) false
      else if (chars.isEmpty) acc == 0
      else if (chars.head == '(') balanceRec(acc + 1, chars.tail)
      else if (chars.head == ')') balanceRec(acc - 1, chars.tail)
      else balanceRec(acc, chars.tail)
    }

    balanceRec(0, chars)
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    if(money == 0) 1
    else if(money < 0 || coins.isEmpty) 0
    else countChange(money - coins.head, coins) + countChange(money, coins.tail)
  }
}

package exercises.week2.funsets

object Main extends App {

  import FunSets._

  println(contains(singletonSet(1), 1))
  private val firstSet: FunSet = singletonSet(1)
  private val secondSet: FunSet = singletonSet(2)
  private val result: FunSet = FunSets.union(firstSet, secondSet)
  FunSets.printSet(result)
}

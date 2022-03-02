List(1, 5, 10, 20, 50, 100, 1, 200, 500)
  .distinct
  .filter(300 / _ > 0)
  .sorted


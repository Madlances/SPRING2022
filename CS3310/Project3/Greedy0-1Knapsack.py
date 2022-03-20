import timeit

class Solution:
   def solve(self, weights, values, capacity):
      res = 0
      for pair in sorted(zip(weights, values), key=lambda x: - x[1]/x[0]):
         if not bool(capacity):
            break
         if pair[0] > capacity:
            res += int(pair[1] / (pair[0] / capacity))
            capacity = 0
         elif pair[0] <= capacity:
            res += pair[1]
            capacity -= pair[0]
      return int(res)

start = timeit.default_timer()
ob = Solution()
weights = [6, 7, 3, 5]
values = [110, 120, 2, 1]
capacity = 10

optimalSolution = ob.solve(weights, values, capacity)
end = timeit.default_timer();

print("Running Time for Greedy Knapsack (larger size): %f ms" %(1000 * (end - start)))
print("Optimal solution (larger size): ", optimalSolution)

start = timeit.default_timer()
ob = Solution()
weights = [6, 7, 3]
values = [110, 120, 2]
capacity = 10

optSolution = ob.solve(weights, values, capacity)
end = timeit.default_timer();

print("Running Time for Greedy Knapsack (smaller size): %f ms" %(1000 * (end - start)))
print("Optimal solution (smaller size): ", optSolution)
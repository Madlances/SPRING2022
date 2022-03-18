# we can further improve the above Knapsack function's space
# complexity
def knapSack(W, wt, val, n):

	K = [[0 for x in range(W+1)] for y in range(2)]
	
	# We know we are always using the the current row or
	# the previous row of the array/vector . Thereby we can
	# improve it further by using a 2D array but with only
	# 2 rows i%2 will be giving the index inside the bounds
	# of 2d array K
	for i in range(n + 1):
		for w in range(W + 1):
			if (i == 0 or w == 0):
				K[i % 2][w] = 0
			elif (wt[i - 1] <= w):
				K[i % 2][w] = max(
					val[i - 1]
					+ K[(i - 1) % 2][w - wt[i - 1]],
					K[(i - 1) % 2][w])

			else:
				K[i % 2][w] = K[(i - 1) % 2][w]

	return K[n % 2][W]

# Driver Code
if __name__ == "__main__":

	val = [60, 100, 120]
	wt = [10, 20, 30]
	W = 50
	n = len(val)

	print(knapSack(W, wt, val, n))

	# This code is contributed by ukasp.


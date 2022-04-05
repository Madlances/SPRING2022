#  Backtracking - M Coloring Problem  
#  http://stephanie-w.github.io/brainscribble/m-coloring-problem.html
from logging.handlers import RotatingFileHandler
from pickletools import read_unicodestring1
import numpy as np
from random import randint
from matplotlib import pyplot as plt
import timeit

counter = [0]
def is_safe(n, graph, colors, c): 
    # Iterate trough adjacent vertices 
    # and check if the vertex color is different from c 
    for i in range(n): 
       if graph[n][i] and c == colors[i]: return False 
    return True 


# n = vertex nb 
def graphColoringUtil(graph, color_nb, colors, n):
    global counter
    # Check if all vertices are assigned a color 
    if color_nb+1 == n: 
       return True
 
    # Trying different colors for the vertex n 
    for c in range(1, color_nb+1): 
        # Check if assignment of color c to n is possible 
       if is_safe(n, graph, colors, c): 
          # Assign color c to n 
          colors[n] = c
          counter[0] += 1
          # Recursively assign colors to the rest of the vertices 
          if graphColoringUtil(graph, color_nb, colors, n+1): return True 
          # If there is no solution, remove color (BACKTRACK) 
          colors[n] = 0

# Monte Carlo estimator for an m-coloring backtracking problem 
# This estimator is not recursive. No backtracking is involved.
 
def promising(n, graph, colors, c): 
    # Go through adjacent vertices 
    # and check if the vertex color is different from c 
    for i in range(n): 
        if graph[n][i] and c == colors[i]: return False 
    return True 
 
def monteCarlo(graph, color_nb, colors): 
    complexity = 1 
    m = 1 
    t = color_nb 
    mprod = 1  
     
    for i in range(1, vertex_nb): 
        promiseArray = [0] * color_nb *2 
        for c in range(1,color_nb+1): promiseArray[c] = promising(i, 
graph, colors, c) 
        m = sum(promiseArray) 
        while( m != 0): 
            arr = np.nonzero(promiseArray) 
            colors[i] = arr[0][randint(0,m-1)] # Randomly selected promising color  
            mprod *= m 
            complexity = complexity + mprod * t 
            break 
        else: 
            return complexity 
    return complexity      
      
# Driver Code
start = timeit.default_timer()
# size = randint(0, 20)
#nb of vertices 
# vertex_nb = size
# nb of colors 
color_nb = 3 
# Initiate vertex colors 
# colors = [0] * vertex_nb
# graph = [ 
#     [0, 1, 1, 1], 
#     [1, 0, 1, 0], 
#     [1, 1, 0, 1], 
#     [1, 0, 1, 0], 
# ]

def graph(size):
    g = [[None for _ in range(size)] for _ in range(size)]
    for x in range(size):
        for y in range(size):
            if x == y:
                g[x][y] = 0
            else:
                g[x][y] = randint(0, 1)
                g[y][x] = g[x][y]
    return g

#beginning with vertex 0

for i in range(20):
    size = randint(4, 20)
    vertex_nb = size
    colors = [0] * vertex_nb
    if graphColoringUtil(graph(size), color_nb, colors, 0): 
        print("Solution: ", colors)
        print("Number of Nodes Checked: %2d" %counter[0])
        print("Size of the graph: ", graph(size).__len__())
    else: 
        print("No solutions") 
    complexity = monteCarlo(graph(size), color_nb, colors) 
    print("Monte Carlo Estimate = %2d" %complexity)
    end = timeit.default_timer()
    print("Running time: %f ms\n" %(1000 * (end - start)))
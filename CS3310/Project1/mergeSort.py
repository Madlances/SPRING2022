# Merge Sort
import numpy as np
from random import randint
from matplotlib import pyplot as plt
from tabulate import tabulate


def merge(arr, l, m, r):  
 global counter 
 n1 = int(m - l + 1) 
 n2 = int(r- m)  
 
 # create temp arrays  
 L = [0] * (n1)  
 R = [0] * (n2)  
 
 # Copy data to temp arrays L[] and R[]  
 for i in range(0 , n1):  
  L[i] = arr[int(l + i)]  
 
 for j in range(0 , n2):  
  R[j] = arr[int(m + 1 + j)]  
 
 # Merge the temp arrays back into arr[l..r]  
 i = 0   # Initial index of first subarray  
 j = 0   # Initial index of second subarray  
 k = int(l)  # Initial index of merged subarray
 while i < n1 and j < n2 :  
  if L[i] <= R[j]:  
   arr[k] = L[i]  
   i += 1 
  else:  
   arr[k] = R[j]  
   j += 1 
  k += 1 
  counter[0] += 1 
         
 # Copy the remaining elements of L[], if there  
 # are any  
 while i < n1:  
  arr[k] = L[i]  
  i += 1 
  k += 1 
 
 # Copy the remaining elements of R[], if there  
 # are any  
 while j < n2:  
  arr[k] = R[j]  
  j += 1 
  k += 1 
 
# l is for left index and r is right index of the  
# sub-array of arr to be sorted  
def mergeSort(arr,l,r):  
 if l < r:  

  # Same as (l+r)/2, but avoids overflow for  
  # large l and h  
  m = (l+(r-1))/2 
 
  # Sort first and second halves  
  mergeSort(arr, l, m)  
  mergeSort(arr, m+1, r)  
  merge(arr, l, m, r)  
 
counter = [0]

data = []

arr = [randint(0, 256) for _ in range(256)]
arr2 = [randint(0, 512) for _ in range(512)]
arr3 = [randint(0, 1024) for _ in range(1024)]
plt.title("Array of Size 256") 
plt.xlabel("x axis") 
plt.ylabel("y axis") 
plt.plot(np.arange(0, 256), arr) 
plt.show()

plt.title("Array of Size 512") 
plt.xlabel("x axis") 
plt.ylabel("y axis") 
plt.plot(np.arange(0, 512), arr2) 
plt.show()

plt.title("Array of Size 1024") 
plt.xlabel("x axis") 
plt.ylabel("y axis") 
plt.plot(np.arange(0, 1024), arr3) 
plt.show()

n = len(arr)
n2 = len(arr2)
n3 = len(arr3)

mergeSort(arr, 0, n-1)
plt.title("Array of Size 256 Merge Sorted") 
plt.xlabel("x axis") 
plt.ylabel("y axis") 
plt.plot(np.arange(0, 256), arr) 
plt.show()
print("# of times the basic operation, for Merge Sort, is performed of array 1 of size 256: %d" %counter[0])
data.append(['256', counter[0]])

mergeSort(arr2, 0, n2-1)
plt.title("Array of Size 512 Merge Sorted") 
plt.xlabel("x axis") 
plt.ylabel("y axis") 
plt.plot(np.arange(0, 512), arr2) 
plt.show()
print("# of times the basic operation, for Merge Sort, is performed of array 2 of size 512: %d" %counter[0])
data.append(['512', counter[0]])

mergeSort(arr3, 0, n3-1)
plt.title("Array of Size 1024 Merge Sorted") 
plt.xlabel("x axis") 
plt.ylabel("y axis") 
plt.plot(np.arange(0, 1024), arr3) 
plt.show()
print("# of times the basic operation, for Merge Sort, is performed of array 3 of size 1024: %d\n" %counter[0])
data.append(['1024', counter[0]])

print("Merge Sort Table:")
print(tabulate(data, headers=["Size of Array", "# of times the basic operation"]))
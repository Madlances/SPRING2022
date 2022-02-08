# Quick Sort
import numpy as np
from random import randint
from matplotlib import pyplot as plt
from tabulate import tabulate
 
def partition(arr,low,high):  
    global counter 
    i = ( low-1 )         # index of smaller element  
    pivot = arr[high]     # pivot  
   
    for j in range(low , high):  
        counter[0]+=1
        
        # If current element is smaller than or  
        # equal to pivot  
        if   arr[j] <= pivot:  
             
            # increment index of smaller element  
            i = i+1  
            arr[i],arr[j] = arr[j],arr[i]
   
    arr[i+1],arr[high] = arr[high],arr[i+1]
    return ( i+1 )  
   
# The main function that implements QuickSort  
# arr[] --> Array to be sorted,  
# low  --> Starting index,  
# high  --> Ending index  
   
# Function to do Quick sort  
def quickSort(arr,low,high):  
    if low < high:  
   
        # pi is partitioning index, arr[p] is now  
        # at right place  
        pi = partition(arr,low,high)  
   
        # Separately sort elements before  
        # partition and after partition  
        quickSort(arr, low, pi-1)  
        quickSort(arr, pi+1, high)  
         
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

quickSort(arr, 0, n-1)
plt.title("Array of Size 256 Quick Sorted") 
plt.xlabel("x axis") 
plt.ylabel("y axis") 
plt.plot(np.arange(0, 256), arr) 
plt.show()
print("# of times the basic operation, for Quick Sort, is performed of array 1 of size 256: %d" %counter[0])
data.append(['256', counter[0]])

quickSort(arr2, 0, n2-1)
plt.title("Array of Size 512 Quick Sorted") 
plt.xlabel("x axis") 
plt.ylabel("y axis") 
plt.plot(np.arange(0, 512), arr2) 
plt.show()
print("# of times the basic operation, for Quick Sort, is performed of array 2 of size 512: %d" %counter[0])
data.append(['512', counter[0]])

quickSort(arr3, 0, n3-1)
plt.title("Array of Size 1024 Quick Sorted") 
plt.xlabel("x axis") 
plt.ylabel("y axis") 
plt.plot(np.arange(0, 1024), arr3) 
plt.show()
print("# of times the basic operation, for Quick Sort, is performed of array 3 of size 1024: %d" %counter[0])
data.append(['1024', counter[0]])

print("Quick Sort Table:")
print(tabulate(data, headers=["Size of Array", "# of times the basic operation"]))
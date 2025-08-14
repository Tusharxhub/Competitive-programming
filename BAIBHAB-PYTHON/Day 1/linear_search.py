# linear search :
# algorithm :
# 1. start from the beginning of the array
# 2.      if current element == desired element
# 3.           return index of the element
# 4. otherwise move to the next element in the array
# 5. repeat from 2 to 4 until end of the array
# 6. If no desired element found, then return -1

# Time: O(N)
# Space: O(1)

def linear_search(key, arr: list, size: int) -> int:

    for i in range(size):
        if arr[i] == key:
            return i
    return -1


def main():

    arr: list = []
    size: int = int(input("Enter the size of the array: "))
    print("Enter the elements of the array: ")
    for i in range(size):
        a = int(input())
        arr.append(a)

    key = int(input("Enter the element to search: "))
    result = linear_search(key, arr, size)
    if result != -1:
        print(f"Element found at index {result}")
    else:
        print("Element not found!")


if __name__ == "__main__":
    main()

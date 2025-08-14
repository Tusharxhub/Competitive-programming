# binary search algorithm: (ARRAY HAS TO BE SORTED!)
# 1. divide the array into two halves by finding the middle index
# 2. compare mid elememt with the key
# 3. if key == mid element
# 4.      return index
# 5. else if key < mid element
# 6.      search from arr[0] to arr[mid - 1] -> left half
# 7. else if key > mid element
# 8.      search from arr[mid + 1] to arr[n-1] -> right half
# 9. else
# 10.     return -1 -> element not found

# Time: O(logN)
# Space: O(1)

def binary_search(arr: list[int], key: int) -> int:
    low, high = 0, len(arr) - 1

    while low <= high:
        # mid = (low+high) // 2  # use floor division to get the mid index
        # prevents integer overflow for huge array inputs
        mid = low + ((high - low) // 2)

        if arr[mid] > key:
            high = mid - 1
        elif arr[mid] < key:
            low = mid + 1
        else:
            return mid  # element found at that index
    return -1  # element not found


def main():
    arr = [2, 3, 4, 10, 40]
    key = 10

    # function call
    result = binary_search(arr, key)
    # print result
    if result != -1:
        print(f"Element found at index {result}")
    else:
        print("Element not found!")


if __name__ == "__main__":
    main()

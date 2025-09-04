def longest_palindromic_substring(s: str) -> str:
    longest: str = ""
    n: int = len(s)

    for i in range(n):
        l, r = i, i
        while l >= 0 and r < n and s[l] == s[r]:
            l -= 1
            r += 1
        current_str = s[l+1: r]
        if len(current_str) > len(longest):
            longest = current_str

        l, r = i, i+1
        while l >= 0 and r < n and s[l] == s[r]:
            l -= 1
            r += 1
        current_str = s[l+1: r]
        if len(current_str) > len(longest):
            longest = current_str

    return longest


def main() -> None:
    s1 = "babad"
    s2 = "cbbd"
    print(
        f"Longest palindromic substring in '{s1}': {longest_palindromic_substring(s1)}")
    print(
        f"Longest palindromic substring in '{s2}': {longest_palindromic_substring(s2)}")


if __name__ == "__main__":
    main()

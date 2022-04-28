
class Solution:
    def checkPalUsingStack(self, s):
        stack = []
        for i in s:
            stack.append(i)
        for i in s:
            if stack.pop() != i:
                return False
        return True

    def isPalindrome(self, x: int) -> bool:
        x=str(x)
        return self.checkPalUsingStack(x)


s=Solution()
print(s.isPalindrome(121))

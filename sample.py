import math
class Solution:
    def is_perfect_square(number: int) -> bool:
        return math.isqrt(number)**2 == number

    def numSquares(self, n: int) -> int:
        l=[]
        for i in range(1,n+1):
            if self.is_perfect_square(i):
                l.append(i)
        dp=[0]*(n+1)
        for i in range(1,n+1):
            dp[i]=i
            for j in l:
                if i-j>=0:
                    dp[i]=min(dp[i],dp[i-j]+1)
        return dp[n]
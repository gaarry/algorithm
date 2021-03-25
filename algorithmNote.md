## 2.10 697数组的度
* 定义一个Map，Key为数组中的值，Value为一个数组，
* 数组的第一个元素为Key出现的次数，第二个元素为Key第一次出现的位置，第三个元素为Key最后一次出现的位置。
然后遍历数组，找到频数最高的数字第一次和最后一次出现的地方。

## 2.11 1438绝对差不超过限制的最长连续子数组

滑动窗口问题模版

https://leetcode-cn.com/problems/max-consecutive-ones-iii/solution/fen-xiang-hua-dong-chuang-kou-mo-ban-mia-f76z/
``` c++
def findSubArray(nums):
    N = len(nums) # 数组/字符串长度
    left, right = 0, 0 # 双指针，表示当前遍历的区间[left, right]，闭区间
    sums = 0 # 用于统计 子数组/子区间 是否有效，根据题目可能会改成求和/计数
    res = 0 # 保存最大的满足题目要求的 子数组/子串 长度
    while right < N: # 当右边的指针没有搜索到 数组/字符串 的结尾
        sums += nums[right] # 增加当前右边指针的数字/字符的求和/计数
        while 区间[left, right]不符合题意：# 此时需要一直移动左指针，直至找到一个符合题意的区间
            sums -= nums[left] # 移动左指针前需要从counter中减少left位置字符的求和/计数
            left += 1 # 真正的移动左指针，注意不能跟上面一行代码写反
        # 到 while 结束时，我们找到了一个符合题意要求的 子数组/子串
        res = max(res, right - left + 1) # 需要更新结果
        right += 1 # 移动右指针，去探索新的区间
    return res

```

第一种解法：这题的重点是怎么快速获取窗口内最大值和最小值的差。这里可以用到Treemap。

第二种解法：使用两个优先队列。`PriorityQueue<>(Comparator.naturalOrder());`

# 2.12 1052爱生气的书店老板

固定窗口问题

``` java
        while(right < len){
            res += (1 - grumpy[right]) * customers[right];
            tmp += grumpy[right] * custome[right++]; //右边界移动
            extra = Math.max(extra, tmp);
            if(right - left == X){ //达到窗口大小， 再去移动左边界
                tmp -= grumpy[left] * customers[left++]; //左边界移动
            }
        }
```
														
# 1178.猜字谜
通过 puzzle 反推 word
        
### 一个二进制状态数字k的子集：
方法就是针对中的二进制为1的位开始进行减法，
判断数字k的二进制子集, 像枚举(2^k-1) ~ 0一样枚举其子集
```` java
function get_subset(bitmask)
    subset = bitmask
    answer = [bitmask] //先将自身放入答案数组
    while subset != 0
        subset = (subset - 1) & bitmask
        put subset into the answer list
    end while
    return answer
end function

````

```` java
int subSet = set;
do{
    subset = (subset - 1) & set;
}while(subSet != set);//若是判断为subset != 0，会漏掉bit本身的情况,应该为5：{4,1,0,5}

````

## 3.4 俄罗斯套娃信封问题

两个重点：
1.Arrays.sort排序, 选择怎么排序最好？
    第一维递增，第二维递减的排序
### 2.最长严格递增子序列
两次for循环，第一次遍历数组（i=0；i-n）
第二次遍历从j到i（j=0；j-i）

状态转移方程：
dp[i]=max(dp[i], dp[j])+1),   其中0≤j<i且num[j]<num[i]

https://leetcode-cn.com/problems/longest-increasing-subsequence/


## 3.6

### 单调递减栈

* 如果栈为空，则把当前元素放入栈内；
* 如果栈不为空，则需要判断当前元素和栈顶元素的大小：
  1.如果当前元素比栈顶元素大：说明当前元素是前面一些元素的「下一个更大元素」，则逐个弹出栈顶元素，直到当前元素比栈顶元素小为止。

  2.如果当前元素比栈顶元素小：说明当前元素的「下一个更大元素」与栈顶元素相同，则把当前元素入栈。


## 3.6
### 回溯算法
典型的是求全排列类型题
https://leetcode-cn.com/problems/permutations/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liweiw/


## 3.24 132模式
典型的求一个数左右最大的树
1.首先考虑到红黑树，nlogn复杂度
2.考虑单调栈，n度复杂度
3.保存左边值得状态，遍历右边子数组，n2复杂度
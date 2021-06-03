#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the isBalanced function below.
def isBalanced(s):
    close = ["}",")","]"]
    new_list = []
    count_one = -1
    for i in s:
        if i == "}":
            if count_one == -1 or new_list[count_one] != "{":
                return "NO"
            else:
                new_list.pop(count_one)
                count_one -= 1
        elif i == "]":
            if count_one == -1 or new_list[count_one] != "[":
                return "NO"
            else:
                new_list.pop(count_one)
                count_one -= 1
        elif i == ")":
            if count_one == -1 or new_list[count_one] != "(":
                return "NO"
            else:
                new_list.pop(count_one)
                count_one -= 1
        else:
            new_list.append(i)
            count_one += 1

    if count_one < 0:
        return "YES"
    else:
        return "NO"


if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    t = int(input())

    for t_itr in range(t):
        s = input()

        result = isBalanced(s)

        fptr.write(result + '\n')

    fptr.close()

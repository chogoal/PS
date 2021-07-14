# 구글링
import sys
input = sys.stdin.readline


def pieces(sticks):
    stack = []
    total = 0
    for i in range(len(sticks)):
        if sticks[i] == "(":
            stack.append(sticks[i])
        elif sticks[i] == ")":
            if sticks[i-1] == "(":
                stack.pop()
                total += len(stack)
            else:
                stack.pop()
                total += 1

    return total


if __name__ == '__main__':
    sticks = input()
    print(pieces(sticks))

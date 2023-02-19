import sys
from collections import deque
input = sys.stdin.readline


def queue(command, dq):
    if command[0] == "push_front":
        dq.appendleft(command[1])
    elif command[0] == "push_back":
        dq.append(command[1])
    elif command[0] == "pop_front":
        if len(dq) == 0:
            print(-1)
        else:
            print(dq.popleft())
    elif command[0] == "pop_back":
        if len(dq) == 0:
            print(-1)
        else:
            print(dq.pop())
    elif command[0] == "size":
        print(len(dq))
    elif command[0] == "empty":
        if len(dq) == 0:
            print(1)
        else:
            print(0)
    elif command[0] == "front":
        if len(dq) == 0:
            print(-1)
        else:
            print(dq[0])
    elif command[0] == "back":
        if len(dq) == 0:
            print(-1)
        else:
            print(dq[-1])


if __name__ == "__main__":
    n = int(input())
    dq = deque(maxlen=n)
    for _ in range(n):
        command = input().split()
        queue(command, dq)

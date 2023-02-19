date = int(input())
cars = map(int, input().split())
ans = 0
for car in cars:
    if car == date:
        ans += 1

print(ans)
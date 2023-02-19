words = []
ans = ''
max_len = 0

for _ in range(5):
    word = list(input()) # 문자열 한 글자씩 끊기
    if len(word) > max_len:
        max_len = len(word)
    words.append(word)

for j in range(max_len):
    for i in range(len(words)):
        if len(words[i]) < j + 1:
            pass
        else:
            ans += words[i][j]

print(ans)

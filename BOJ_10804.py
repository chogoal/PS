import sys
input = sys.stdin.readline


def reverse(a, b, cards):
    card_reverse = cards[a-1:b]
    card_reverse.reverse()
    cards[a-1:b] = card_reverse
    return cards


if __name__ == '__main__':
    cards = list(range(1, 21))
    for _ in range(10):
        a, b = map(int, input().split())
        cards = reverse(a, b, cards)
    for i in cards:
        print(i, end=' ')

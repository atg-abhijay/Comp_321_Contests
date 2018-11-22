def main():
    distinct_set = set()
    for i in range(10):
        num = int(input())
        value = num % 42
        if value not in distinct_set:
            distinct_set.add(value)

    print(len(distinct_set))

main()

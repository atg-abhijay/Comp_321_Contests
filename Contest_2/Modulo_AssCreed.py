def main():
    # set stores distinct
    # elements only
    distinct_set = set()
    for i in range(10):
        num = int(input())
        # take the modulo of the
        # number with 42. if the mod
        # value is not in the set,
        # we add it to the set
        value = num % 42
        if value not in distinct_set:
            distinct_set.add(value)

    print(len(distinct_set))

main()

package io.vdubovsky.groovytraining.syntax

class ListRunner {

    static void main(String[] args) {
        def arr = [1, 1, 2, 3, 5, 8]
        assert arr.getClass() == ArrayList

        assert arr[1] == arr.get(1)
        assert arr[arr.size()] == null
        assert arr[-1] == arr.get(arr.size() - 1)

        assert arr[2..4] == [2, 3, 5]
        assert arr[2..4] * 3 == [2, 3, 5, 2, 3, 5, 2, 3, 5]
        assert arr[-2] in [5, 6]

        arr += 7
        println arr
        arr -= 1
        println arr
        arr << 11 << 12 << 13
        println arr

        arr.push(155)
        println arr

        assert arr.head() == 155
        assert arr.head() == 155
        assert arr.head() == 155
        assert arr.head() == 155
        assert arr.head() == 155

        assert arr.pop() == 155
        assert arr.pop() === 2

        println arr.tail()

        assert arr.last() == 13
        assert arr.last() == 13
        assert arr.last() == 13
        assert arr.last() == 13
    }
}

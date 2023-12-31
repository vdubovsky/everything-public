package io.vdubovsky.groovytraining.syntax

class NewListMethods {

    static void main(String[] args) {
        // flatten
        // disjoint
        // reverse
        // intersect

        assert [1, 2, [3, 4], 5].flatten() == [1, 2, 3, 4, 5]
        assert [1, 2, 3].reverse() == [3, 2, 1]
        assert ![1, 2, 3, 5].disjoint([5, 6, 7])
        assert [1, 2, 3].disjoint([5, 6, 7])
        assert [1, 2, 3].intersect([2, 3, 4]) == [2, 3]

        // multiple assignment
        def (a, b, c) = [1, 2, 3, 4, 5]
        assert a == 1
        assert b == 2
        assert c == 3

        assert someBiFunc(*[1, 6]) == 7


    }

    static def someBiFunc(def a, def b) {
        a + b
    }
}

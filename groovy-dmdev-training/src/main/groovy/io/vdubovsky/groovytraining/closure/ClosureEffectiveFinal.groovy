package io.vdubovsky.groovytraining.closure

class ClosureEffectiveFinal {

    static void main(String[] args) {
        def x = 10
        def closure = { x = x + 100}
        closure(x)
        assert x == 10
    }
}

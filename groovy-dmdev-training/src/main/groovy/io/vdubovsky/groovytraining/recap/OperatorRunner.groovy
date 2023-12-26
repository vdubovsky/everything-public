package io.vdubovsky.groovytraining.recap

class OperatorRunner {

    static void main(String[] args) {
        assert 5 / 2 == 2.5
        assert 5.intdiv(2) == 2
        assert 5 % 2 == 1

        println 5 / 2 as Integer // def asType(clazz)

        def a = 65
        def b = 65
        println ''
        println 'assert integer'
        println 130 === a + b
        println 130 == a + b
        println 130 <=> 130 // 0
        println 130 <=> 131 // -1
        println 130 <=> 129 // +1
    }
}

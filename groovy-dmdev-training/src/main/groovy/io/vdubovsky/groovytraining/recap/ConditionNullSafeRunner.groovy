package io.vdubovsky.groovytraining.recap

class ConditionNullSafeRunner {

    static void main(String[] args) {
        def p = new Person()
        p = Math.random() > 0.5 ? p : null
        println p?.getX()
        println "get class"
        println p?.getClass()
        p?.doX()
    }

    static class Person {
        Integer x = 5

        def doX() {
            println "doX"
            return x
        }
    }
}

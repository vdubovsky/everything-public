package io.vdubovsky.groovytraining.condition

class ConditionNullSafeRunner {

    static void main(String[] args) {
        def p = new Person()
        p = Math.random() > 0.5 ? p : null
        println p?.getX()
    }

    static class Person {
        Integer x = 5
    }
}

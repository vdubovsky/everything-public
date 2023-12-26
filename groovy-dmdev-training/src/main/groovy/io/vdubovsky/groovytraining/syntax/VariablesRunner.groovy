package io.vdubovsky.groovytraining.syntax

class VariablesRunner {

    // There is no primitives in Groovy
    static void main(String[] args) {
        int a = 5
        assert a.getClass() == Integer

        def internet = 5G
        assert internet.getClass() == BigInteger

        def b = 5.1G
        assert b.getClass() == BigDecimal
    }
}

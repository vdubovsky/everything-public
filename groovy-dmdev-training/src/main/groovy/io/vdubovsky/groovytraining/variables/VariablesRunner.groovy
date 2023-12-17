package io.vdubovsky.groovytraining.variables

class VariablesRunner {

    static void main(String[] args) {
        int a = 5
        assert a.getClass() == Integer

        def internet = 5G
        assert internet.getClass() == BigInteger

        def b = 5.1G
        assert b.getClass() == BigDecimal
    }
}

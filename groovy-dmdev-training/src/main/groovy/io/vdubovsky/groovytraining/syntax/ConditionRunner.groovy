package io.vdubovsky.groovytraining.syntax

class ConditionRunner {

    /**
     * boolean is true
     * Collection/Map is not empty
     * Matcher match
     * String GString
     * Number/Char !=0
     * reference is not null
     *
     * asBoolean() method
     */
    static void main(String[] args) {
        def x = 10
        def y
        def res = x ?: 1
        def res2 = y ?: 42
        println res
        println res2
    }
}

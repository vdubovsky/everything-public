package io.vdubovsky.groovytraining.syntax

class ClosureIfLikeSyntax {

    static void main(String[] args) {
        def name = $/Vova/$
        check(true) {
            -> println "What's Up, $name?"
        }
    }

    static def check(def condition, def closure) {
        if (condition) {
            closure()
        }
    }
}
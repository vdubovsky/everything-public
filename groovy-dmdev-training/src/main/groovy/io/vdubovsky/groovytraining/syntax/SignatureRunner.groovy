package io.vdubovsky.groovytraining.syntax

class SignatureRunner {

    static void main(String[] args) {
        try {
            println "null get class"
            nullGetClass()
        } catch (def e) {
            System.err.println e
        }

        try {
            println "arg get class - null arg"
            argGetClass(null)
        } catch (def e) {
            System.err.println e
        }

        try {
            println "arg get class - no arg"
            argGetClass()
        } catch (def e) {
            System.err.println e
        }

        try {
            println "arg get class - null arg no brackets"
            argGetClass null
        } catch (def e) {
            System.err.println e
        }
    }

    static def argGetClass(def arg) {
        println "arg - ${arg.getClass()}"
    }

    static def nullGetClass() {
        def nulll = null
        println "nulll - $nulll.getClass()}"
    }
}

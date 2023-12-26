package io.vdubovsky.groovytraining.recap

class StringGStringRunner {

     static void main(String[] args) {
        def string1 = "hello 'Vova'"
        def string2 = 'hello "Vova"'
        def string3 = 'hello \'Vova\''
        def string4 = "hello \"Vova\""

        println string1[0]
        println string1[-1]
        println string1[1..3]

        println((string2 * 3) - 'll')

         // see Hello World app
    }
}

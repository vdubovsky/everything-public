package io.vdubovsky.groovytraining

class HelloWorldClass {
    static void main(String[] args) {
        println 'Hello "World"'
        println "Hello \"World\""

        println 'Hello \'World\''
        println "Hello 'World'"

        def world = 'World'
        println 'Hello ' + world
        println "Hello $world" // GStringImpl -> String interpolation

        def greetingMessage = """Hello "Wlodek" 'Waldemarek' 
and Hello $world""" //GStringImpl -> String interpolation

        println greetingMessage

        println '''Hello World'''
        println(/Hello World/)
        println($/Hello World/$)
    }
}

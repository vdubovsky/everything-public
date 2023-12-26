package io.vdubovsky.groovytraining.recap

import groovy.transform.builder.Builder

class SwitchRunner {

    static void main(String[] args) {
        def p = Math.random() > 0.5 ? null :
                Person.builder()
                        .name("Vova")
                        .age(34)
                        .build()

        switch (p) {
            case String:
                println "String"
                break
            case Person.builder().build():
                println "instance case"
                break
            case Person:
                println "Person"
                break
            case [3, 5, 7, 9]:
                println "in"
                break
            case { it?.getAge() === 34 }:
                println "34"
                break
            case ~/\d+/:
                println "regular"
                break
            default:
                println "Default"
                break
        }
    }

    @Builder
    static class Person {
        def name
        def age

        def isCase(def switchValue) {
            println 'is case ?'
            false
        }
    }
}

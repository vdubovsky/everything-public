package io.vdubovsky.groovytraining.syntax

class OopRunner {

    static void main(String[] args) {
        def p1 = new Person("age": 5)
        def p2 = new Person(age: 5)
        def p3 = new Person('age': 5)
        def p4 = new Person(/age/: 5)
        def p5 = new Person($/age/$: 5)
        def p6 = new Person("""age""": 5)
        def p7 = new Person(age: '5' as Integer)
        def p8 = new Person(age: '5')
        println p8.age

        Character a = '5'
        println a as Integer

        println()
        println 'getting'
        println()

        println p1.age
        println p1.'age'
        println p1."age"
        println p1./age/
        //println p1.$/age$/
        println p1."""age"""
        println p1['age']
        println p1[$/age/$]

        println "field"

        println p1.@age

        println 'properties'
        p1.properties.each { println it }
    }
}


class Person {
    int age
    String firstname

    int getAge() {
        println "getting age"
        age
    }

    void setAge(int age) {
        println "setting age"
        this.age = age
    }
}
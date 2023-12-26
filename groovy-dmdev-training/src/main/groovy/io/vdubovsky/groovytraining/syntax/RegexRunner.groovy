package io.vdubovsky.groovytraining.syntax

import java.util.regex.Pattern

class RegexRunner {

    static void main(String[] args) {
        def val = "one 1 two 22 three 333"
        def reg1 = "(\\w+) (\\d)"
        def reg2 = /\w+ \d+ \w+ \d+ \w+ \d+/

        def pattern = Pattern.compile(reg2)
        def matcher = pattern.matcher(val)

        def result = matcher.matches()
        def result2 = val ==~ reg1

        println result
        println result2

        //pattern = ~reg1
        matcher = val =~ reg1

        /*while (matcher.find()) {
            println '------'
            println matcher.group(0)
            println matcher.group()
            println matcher.group(1)
            println matcher.group(2)
            println '------'
        }*/

        println matcher[0]
        println matcher[1]
        println matcher[2]
    }
}

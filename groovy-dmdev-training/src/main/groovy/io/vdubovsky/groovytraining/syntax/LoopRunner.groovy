package io.vdubovsky.groovytraining.syntax

class LoopRunner {

    static void main(String[] args) {
        def arr = [1, 1, 2, 3, 5, 8]

        for (i in 0..<arr.size()) {
            print arr[i]
        }
        println()
        println "---"

        for (i in 0..arr.size() - 1) {
            print arr[i]
        }
        println()
        println "---"

        for (x in arr) {
            print x
        }
        println()
        println "---"

        0.upto(arr.size() - 1) {
            print arr[it]
        }
        println()
        println "---"

        0.step(arr.size(), 1) {
            print arr[it]
        }
        println()
        println "---"

        arr.size().times {
            print arr[it]
        }
        println()
        println "---"
    }
}

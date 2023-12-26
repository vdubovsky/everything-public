package io.vdubovsky.groovytraining.syntax

import java.util.function.Function
import java.util.stream.Stream

class ClosureRunner {

    static void main(String[] args) {

        Closure closure = a -> a + a

        Closure noArgsClosure = { -> 5 }

        Closure oneArgsClosure = {
            println it
            it * 2
        }

        Closure defaultValueClosure = { it = 42 ->
            println it
            it
        }
        defaultValueClosure()
        defaultValueClosure(5)

        Stream.of(1, 2, 3, 4)
        //.map(sumAnonymous())
        //.map(sumClosure())
        //.map(lambda -> lambda + lambda) // inline lambda
                .map(oneArgsClosure)
                .map(String.&valueOf)
                .forEach(System.out::println)
    }

    private static Function<Integer, Integer> sumAnonymous() {
        new Function<Integer, Integer>() {
            @Override
            Integer apply(Integer a) {
                return a + a
            }
        }
    }

    private static Closure<Integer> sumClosure() {
        { x -> x + x }
    }

    private static Closure<Integer> sumClosureManyArgs() {
        { x1, x2 -> x1 + x2 }
    }
}

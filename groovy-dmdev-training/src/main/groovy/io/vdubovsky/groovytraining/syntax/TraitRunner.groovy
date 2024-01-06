package io.vdubovsky.groovytraining.syntax

import groovy.transform.ToString
import groovy.transform.TupleConstructor

@TupleConstructor
@ToString
class TraitRunner implements WithId {


    static void main(String[] args) {
        assert new TraitRunner(id: 8).validateId()
    }
}


trait WithId {
    int id

    boolean validateId() {
        id > 5
    }
}
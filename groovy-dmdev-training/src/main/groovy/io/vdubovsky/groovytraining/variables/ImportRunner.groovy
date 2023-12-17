package io.vdubovsky.groovytraining.variables

import groovy.transform.CompileStatic

import java.sql.Date as SqlDate

class ImportRunner {
    // Default import
    // java.lang.*
    // java.util.*
    // java.io.*
    // java.net.*
    // groovy.lang.*
    // groovy.util.*
    // java.math.BigInteger
    // java.math.BigDecimal

    static def unknownTypeField

    @CompileStatic
    static void main(String[] args) {
        def date = new SqlDate(2023 - 1900, 11, 31)
        assert date instanceof java.sql.Date
        assert date instanceof SqlDate
        println "time is ${date.getTime()}"
        unknownSignature("a")
        unknownSignature(unknownTypeField)
    }

    static def unknownSignature(def arg){
        println "arg - ${arg.getClass()}"
    }
}

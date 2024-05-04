package io.vdubovsky.groovytraining.syntax

class IORunner {

    static void main(String[] args) {
        def file = new File("HELP.md")
        //println file.text

        //file.each { println it }
        file.withInputStream {
            def allText = new String(it.readAllBytes())
            println allText
        }

        def newFile = new File("newFile.txt")
        newFile.text = "some text "
        newFile << "...another part of text" << System.lineSeparator() << "one more..."
    }
}
package com.ff

import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class ToSell {

    static constraints = {

    }

    String name
    int price
    int quantity
    Seller seller
    String about
    Boolean slaughteredWithHands


    String toString() {
        return name
    }
}

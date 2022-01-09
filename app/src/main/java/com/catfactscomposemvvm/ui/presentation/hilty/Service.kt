package com.catfactscomposemvvm.ui.presentation.hilty

class Service(var name : String ="service", var number : Int = 11) {

    override fun toString() : String
    {
        return "$name & ${number.toString()}"
    }
}
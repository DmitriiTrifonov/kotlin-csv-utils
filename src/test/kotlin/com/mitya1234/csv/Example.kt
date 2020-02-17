package com.mitya1234.csv


import com.mitya1234.csv.util.getCSVLines
import com.mitya1234.csv.util.makeDataClass

import java.nio.file.Paths

fun main(){
        println("Hello")
        val path = Paths.get("").toAbsolutePath()
        println(path.toString())

        getCSVLines("./resources/Book.csv")?.forEach { println(it) }

        makeDataClass("./resources/Book.csv")

        println("end")
}

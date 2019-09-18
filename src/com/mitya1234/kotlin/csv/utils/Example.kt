package com.mitya1234.kotlin.csv.utils


import com.mitya1234.kotlin.csv.utils.tools.CSVUtil.Companion.getCSVLines

import java.nio.file.Paths

fun main(args: Array<String>){
        println("Hello")
        val path = Paths.get("").toAbsolutePath()
        println(path.toString())

        getCSVLines("./resources/Book.csv")?.forEach { println(it) }

        println("end")
}
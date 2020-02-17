package com.mitya1234.csv.util

import java.io.File

private fun readFile(pathToFile: String): String? {
    return File(pathToFile).readText()
}

private fun getFileName(pathToFile: String): String? {
    return  File(pathToFile).name
}

private fun removeFEFF(inputStr: String?): String? {
return inputStr?.replace("\uFEFF", "")
}

private fun removeLastNewLine(inputStr: String?): String? {
    return if (inputStr?.get(inputStr.length - 1)  == '\n') {
                inputStr.substring(0, inputStr.length - 1)
           } else inputStr
}

fun getCsvText(pathToCsv: String): String? {
    return removeLastNewLine(removeFEFF(readFile(pathToCsv)))
}

fun getCSVLines(pathToCsv: String): List<String>? {
    return getCsvText(pathToCsv)?.split("\n")
}

fun makeDataClass(pathToFile: String) {
    val filename = getFileName(pathToFile)?.replace(".csv", ".kt")
    val file: File
    if (filename == null) {
        println("No file")
        return
    } else {
        file = File(filename)
    }
    val lines = getCSVLines(pathToFile)
    val linesMap = lines?.map { "val ${it.split(";")[0]}: ${it.split(";")[2].replace("\n", "")}"}
    val stringFromLines = linesMap?.joinToString(",")
    val dataClass = "data class ${filename.replace(".kt", "")}(" +
            "$stringFromLines\n){}"
    file.writeText(dataClass)
}


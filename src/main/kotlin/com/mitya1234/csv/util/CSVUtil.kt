package com.mitya1234.kotlin.csv.utils.tools

import java.io.File

private fun readFile(pathToFile: String): String? {
    return File(pathToFile).readText()
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


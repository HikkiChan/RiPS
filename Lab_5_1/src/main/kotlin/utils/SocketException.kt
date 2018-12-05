package utils

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.Socket

fun Socket.initInput() = try {
    BufferedReader(InputStreamReader(getInputStream()))
} catch (e: IOException) {
    throw ClientCreationException("Error while initializing input", e)
}

fun Socket.initOutput() = try {
    PrintWriter(getOutputStream(), true)
} catch (e: IOException) {
    throw ClientCreationException("Error while initializing output", e)
}
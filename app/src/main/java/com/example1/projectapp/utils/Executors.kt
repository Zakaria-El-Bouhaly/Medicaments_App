package com.example1.projectapp.utils

import java.util.concurrent.Executors

private val IO_EXECUTOR = Executors.newSingleThreadExecutor()

fun ioThread(f: () -> Unit) {
    IO_EXECUTOR.execute(f)
}
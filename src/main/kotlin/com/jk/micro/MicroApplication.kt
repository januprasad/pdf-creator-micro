package com.jk.micro

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MicroApplication

fun main(args: Array<String>) {
	runApplication<MicroApplication>(*args)
}

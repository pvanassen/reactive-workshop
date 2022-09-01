package nl.pvanassen.reactive.workshop

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ReactiveWorkshopApplication

fun main(args: Array<String>) {
	runApplication<ReactiveWorkshopApplication>(*args)
}

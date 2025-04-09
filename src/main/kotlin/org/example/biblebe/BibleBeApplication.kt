package org.example.biblebe

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@SpringBootApplication
@ConfigurationPropertiesScan
class BibleBeApplication

fun main(args: Array<String>) {
    runApplication<BibleBeApplication>(*args)
}

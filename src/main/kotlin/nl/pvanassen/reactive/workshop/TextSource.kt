package nl.pvanassen.reactive.workshop

import reactor.core.publisher.Flux

interface TextSource {
    fun `get all items`(): Flux<String>
}
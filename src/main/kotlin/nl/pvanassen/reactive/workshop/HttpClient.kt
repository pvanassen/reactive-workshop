package nl.pvanassen.reactive.workshop

import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Component
class HttpClient: TextSource {

    // TODO: http://localhost:8008/hello

    override fun `get all items`() = Flux.just("hello world!")

}
package nl.pvanassen.reactive.workshop

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
class Endpoint(val dbClient: DbClient,
               val httpClient: HttpClient) {

    @GetMapping("/getFromDatabase")
    fun `get all items from database`(): Mono<ResponseEntity<List<String>>> =
        dbClient.`get all items`()
            .collectList()
            .map { ResponseEntity.ok(it) }


    @GetMapping("/getFromWebservice")
    fun `get all items from webservice`(): Mono<ResponseEntity<List<String>>> =
        httpClient.`get all items`()
            .collectList()
            .map { ResponseEntity.ok(it) }

    @PutMapping("/saveToDatabase")
    fun `save to database`(@RequestBody body: String): Mono<ResponseEntity<Void>> =
        dbClient.save(body)
            .map { ResponseEntity.noContent().build() }
}
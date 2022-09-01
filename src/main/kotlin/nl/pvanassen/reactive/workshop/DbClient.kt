package nl.pvanassen.reactive.workshop

import org.springframework.stereotype.Component
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import software.amazon.awssdk.services.dynamodb.DynamoDbAsyncClient
import software.amazon.awssdk.services.dynamodb.model.AttributeValue
import software.amazon.awssdk.services.dynamodb.model.PutItemRequest

@Component
class DbClient(val dynamoDBAsyncClient: DynamoDbAsyncClient): TextSource {

    // TODO: implement
    fun save(text: String): Mono<Void> = Mono.empty()

    override fun `get all items`(): Flux<String> {
        return Flux.from(dynamoDBAsyncClient.scanPaginator {
            it.attributesToGet("key")
                .tableName("testtable")
        })
            .flatMapIterable { it.items() }
            .map { it["key"]!!.s() }
    }

}
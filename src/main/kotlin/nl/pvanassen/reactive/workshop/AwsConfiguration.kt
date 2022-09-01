package nl.pvanassen.reactive.workshop

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider
import software.amazon.awssdk.regions.Region
import software.amazon.awssdk.services.dynamodb.DynamoDbAsyncClient
import software.amazon.awssdk.services.dynamodb.DynamoDbClient
import java.net.URI


@Configuration
class AwsConfiguration(
    @Value("\${amazon.dynamodb.endpoint}") val endpoint: String) {

    @Bean
    fun amazonDynamoDB(): DynamoDbClient =
        DynamoDbClient.builder()
            .region(Region.EU_WEST_1)
            .endpointOverride(URI.create(endpoint))
            .build()

    @Bean
    fun amazonDynamoDBAsyncClient():DynamoDbAsyncClient = DynamoDbAsyncClient.builder()
        .region(Region.EU_WEST_1)
        .endpointOverride(URI.create(endpoint))
        .build()

}
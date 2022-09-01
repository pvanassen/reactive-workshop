package nl.pvanassen.reactive.workshop

import org.springframework.beans.factory.InitializingBean
import org.springframework.stereotype.Component
import software.amazon.awssdk.services.dynamodb.DynamoDbClient
import software.amazon.awssdk.services.dynamodb.model.*

@Component
class DynamoDbInit(val dynamoDbClient: DynamoDbClient): InitializingBean {
    override fun afterPropertiesSet() {
        val waiter = dynamoDbClient.waiter()
        if (dynamoDbClient.listTables().tableNames().contains("testtable")) {
            return
        }

        val createTableRequest = CreateTableRequest.builder()
            .attributeDefinitions(AttributeDefinition.builder()
                .attributeName("key")
                .attributeType(ScalarAttributeType.S)
                .build())
            .keySchema(KeySchemaElement.builder()
                .attributeName("key")
                .keyType(KeyType.HASH)
                .build())
            .tableName("testtable")
            .provisionedThroughput(ProvisionedThroughput.builder()
                .readCapacityUnits(1)
                .writeCapacityUnits(1)
                .build())
            .build()
        dynamoDbClient.createTable(createTableRequest)

        val describeTableRequest = DescribeTableRequest.builder()
            .tableName("testtable")
            .build()

        waiter.waitUntilTableExists(describeTableRequest)
    }
}
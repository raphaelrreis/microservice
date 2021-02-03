package microservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.relational.core.mapping.Table
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class MicroserviceApplication

fun main(args: Array<String>) {
    runApplication<MicroserviceApplication>(*args)
}

@RestController
class MessageResource(val sevice: MessageService) {
    @GetMapping
    fun index(): List<Message> = listOf(
            Message("1", "hello"),
            Message("2", "holla")
    )

}

@Service
class MessageService {

    fun findMessage(): List<Message> {
        TODO()
    }

    fun post(message: Message) {
        TODO()
    }
}

interface MessageRepository : CrudRepository<Message, String> {
    @Query("select * from messages")
    fun findMessages(): List<Message>
}

@Table("MESSAGES")
data class Message(val id: String?, val text: String)


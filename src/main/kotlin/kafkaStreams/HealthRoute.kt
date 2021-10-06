package kafkaStreams

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HealthRoute {

    @GetMapping("/health")
    fun response() = run { "health works on port" }
    // TODO request stream health
}
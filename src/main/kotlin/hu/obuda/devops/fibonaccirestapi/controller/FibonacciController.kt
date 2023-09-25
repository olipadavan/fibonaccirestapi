package hu.obuda.devops.fibonaccirestapi.controller

import hu.obuda.devops.fibonaccirestapi.service.FibonacciService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.reactive.function.client.WebClientResponseException.BadRequest
import org.springframework.web.server.ResponseStatusException
import reactor.netty.http.server.HttpServerState

@RestController
@RequestMapping("/")
class FibonacciController {

    @Autowired
    var fibonacciService: FibonacciService? = null

    @GetMapping(value = ["fibonacci"])
    open fun fibonacci(@RequestParam n: Int): Int? {
        // TODO - If n is greater than 46 then return BAD REQUEST use HttpStatus
        return if(n<46) fibonacciService?.fibonacci(n) else throw ResponseStatusException(HttpStatus.BAD_REQUEST)
    }
}
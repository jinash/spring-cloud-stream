//package com.scl.web.config;
//
//import lombok.Data;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.stream.function.StreamBridge;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.reactive.config.EnableWebFlux;
//import org.springframework.web.reactive.config.WebFluxConfigurer;
//import org.springframework.web.reactive.function.server.RouterFunction;
//import org.springframework.web.reactive.function.server.RouterFunctions;
//import org.springframework.web.reactive.function.server.ServerResponse;
//import reactor.core.publisher.Mono;
//
//import static org.springframework.http.MediaType.APPLICATION_JSON;
//import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
//import static org.springframework.web.reactive.function.server.ServerResponse.ok;
//
//
//@Configuration
//@EnableWebFlux
//public class WebConfig implements WebFluxConfigurer {
//
//    /*@Autowired
//    private StreamBridge streamBridge;*/
//
//    @Bean
//    public RouterFunction<ServerResponse> helloRouter() {
//        return RouterFunctions.route()
//                .GET("/person/{message}", accept(APPLICATION_JSON), request -> {
////                    streamBridge.send("process-out-0", request.pathVariable("message"));
//                    Mono<Person> person = Mono.just(new Person("Jinash", 30));
//                    return ok().contentType(APPLICATION_JSON).body(person, Person.class);
//                })
//                .build();
//    }
//
//    @Data
//    @RequiredArgsConstructor
//    static class Person {
//        final String name;
//        final int age;
//    }
//}

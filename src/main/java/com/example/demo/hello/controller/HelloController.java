package com.example.demo.hello.controller;

import com.example.demo.hello.service.HelloService;
import com.example.demo.hello.dto.HelloRequestDto;
import com.example.demo.hello.dto.HelloResponseDto;
import com.example.demo.hello.entity.Hello;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/hello")
public class HelloController {

    @Autowired
    private final HelloService helloService;

    // C
    @PostMapping
    public ResponseEntity<HelloResponseDto> createHello(@RequestBody HelloRequestDto requestDto) {
        HelloResponseDto responseDto = helloService.createHello(requestDto);

        return ResponseEntity.ok()
                .body(responseDto);
    }

    // R
    @GetMapping
    public ResponseEntity<List<Hello>> getAllHello() {
        List<Hello> helloList = helloService.getAllHello();

        return ResponseEntity.ok()
                .body(helloList);
    }

    // U
    @PatchMapping("/{id}")
    public ResponseEntity<Optional<Hello>> updateHello(@PathVariable int id, @RequestBody HelloRequestDto requestDto) {
        Optional<Hello> helloOptional = helloService.updateHello(id, requestDto);

        return ResponseEntity.ok()
                .body(helloOptional);
    }

    // D
    @DeleteMapping("/{id}")
    public ResponseEntity<String> DeleteHello(@PathVariable int id) {
        String result = helloService.deleteHello(id);

        return ResponseEntity.ok()
                .body(result);
    }
}

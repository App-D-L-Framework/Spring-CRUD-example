package com.example.demo.hello.service;

import com.example.demo.hello.dto.HelloRequestDto;
import com.example.demo.hello.dto.HelloResponseDto;
import com.example.demo.hello.entity.Hello;

import java.util.List;
import java.util.Optional;

public interface HelloService {
    HelloResponseDto createHello(HelloRequestDto requestDto);
    List<Hello> getAllHello();
    Optional<Hello> updateHello(int id, HelloRequestDto requestDto);
    String deleteHello(int id);

    // request를 통해서 entity에 저장
    default Hello DtoToEntity (HelloRequestDto requestDto) {
        Hello hello = Hello.builder()
                .content(requestDto.getContent())
                .build();

        return hello;
    }

    // entity에서 받은 내용을 responseDto에 실어주는 역할
    default HelloResponseDto EntityToDto(Hello hello) {

        HelloResponseDto responseDto = HelloResponseDto.builder()
                .id(hello.getId())
                .content(hello.getContent())
                .build();

        return responseDto;
    }


}

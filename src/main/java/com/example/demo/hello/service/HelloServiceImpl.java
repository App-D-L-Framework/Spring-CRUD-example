package com.example.demo.hello.service;

import com.example.demo.hello.dto.HelloRequestDto;
import com.example.demo.hello.dto.HelloResponseDto;
import com.example.demo.hello.entity.Hello;
import com.example.demo.hello.repository.HelloRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HelloServiceImpl implements HelloService{

    @Autowired // 자동생성자 주입 어노테이션
    private final HelloRepository helloRepository;

    @Override
    public HelloResponseDto createHello(HelloRequestDto requestDto) {

        Hello entity = DtoToEntity(requestDto);

        helloRepository.save(entity);

        HelloResponseDto responseDto = EntityToDto(entity);

        return responseDto;
    }

    @Override
    public List<Hello> getAllHello() {

        return helloRepository.findAll();
    }

    @Override
    public Optional<Hello> updateHello(int id, HelloRequestDto requestDto) {
        Optional<Hello> hello = helloRepository.findById(id);

        if (hello.isPresent()) {
            Hello entity = hello.get();
            entity.modifyUser(
                    requestDto.getContent()
            );
            helloRepository.save(entity);
        }

        return hello;
    }

    @Override
    public String deleteHello(int id) {
       helloRepository.deleteById(id);

        return "유저 정보가 삭제되었습니다.";
    }
}

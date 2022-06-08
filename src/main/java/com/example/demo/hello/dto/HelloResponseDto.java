package com.example.demo.hello.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HelloResponseDto {

    private int id;
    private String content;

}

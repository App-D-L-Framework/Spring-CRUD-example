package com.example.demo.hello.repository;

import com.example.demo.hello.entity.Hello;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HelloRepository extends JpaRepository<Hello,Integer> {


}

package com.hbn.study.mongodblearning.controller;

import com.hbn.study.mongodblearning.pojo.Book;
import com.hbn.study.mongodblearning.service.DeviceStatusRepository;
import com.hbn.study.mongodblearning.service.MongoDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TestMongodbController {

    @Autowired
    private MongoDbService mongoDbService;
    @Autowired
    private DeviceStatusRepository deviceStatusRepository;

    @PostMapping("/mongo/save")
    public String saveObj(@RequestBody Book book) {return mongoDbService.saveObj(book);}

    @PostMapping("/mongo/test")
    public String test(@RequestBody Book book) {
        deviceStatusRepository.limitQuery();
        return "test";}
    @GetMapping("/mongo/findAll")
    public List<Book> findAll() {return mongoDbService.findAll();}

    @GetMapping("/mongo/findOne")
    public Book findOne(@RequestParam String id) {return mongoDbService.getBookById(id);}

    @GetMapping("/mongo/findOneByName")
    public Book findOneByName(@RequestParam String name) {return mongoDbService.getBookByName(name);}

    @PostMapping("/mongo/update")
    public String update(@RequestBody Book book) {return mongoDbService.updateBook(book);}

    @PostMapping("/mongo/delOne")
    public String delOne(@RequestBody Book book) {return mongoDbService.deleteBook(book);}

    @GetMapping("/mongo/delById")
    public String delById(@RequestParam String id) {return mongoDbService.deleteBookById(id);}



}

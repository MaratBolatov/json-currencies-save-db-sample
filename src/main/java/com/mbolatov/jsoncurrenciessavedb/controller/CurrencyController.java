package com.mbolatov.jsoncurrenciessavedb.controller;

import com.mbolatov.jsoncurrenciessavedb.model.Currency;
import com.mbolatov.jsoncurrenciessavedb.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/currencies")
public class CurrencyController {

    @Autowired
    CurrencyService currencyService;

    @PostMapping
    public ResponseEntity<String> add(@RequestBody Currency currency)
    {
        currencyService.add(currency);
        ResponseEntity<String> responseEntity = new ResponseEntity("Success add!", HttpStatus.CREATED);
        return responseEntity;
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody Currency currency)
    {
        currencyService.update(currency);
        ResponseEntity<String> responseEntity = new ResponseEntity("Success update!", HttpStatus.NO_CONTENT);
        return responseEntity;
    }

    @DeleteMapping
    public ResponseEntity<String> delete(@PathVariable(value = "id")int currencyId)
    {
        currencyService.delete(currencyId);
        return new ResponseEntity("Success delete!", HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Currency> get(@PathVariable(value = "id")int currencyId)
    {
        return new ResponseEntity(currencyService.get(currencyId), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Currency>> getAll()
    {
        return new ResponseEntity(currencyService.getAll(),HttpStatus.OK);
    }

}
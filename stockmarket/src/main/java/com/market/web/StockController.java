package com.market.web;

import com.market.domain.Stock;
import com.market.service.stock.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stocks")
public class StockController {

    @Autowired
    private StockService service;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Resource<Stock> create(@RequestBody Stock stock) {
        return service.save(stock);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Resource<Stock>> selectAll() {
        return service.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Resource<Stock> select(@PathVariable Long id) {
        return service.fetch(id);
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Resource<Stock> update(@RequestBody Stock stock) {
        return service.save(stock);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void delete(@RequestBody Stock stock) {
        service.delete(stock);
    }
}

package com.market.service.stock;

import com.market.domain.Stock;
import com.market.domain.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StockService {

    @Autowired
    private StockRepository repository;

    @Autowired
    private StockResourceAssembler resourceAssembler;

    public List<Resource<Stock>> getAll() {
        List<Stock> stocks = fetchStocks();
        List<Resource<Stock>> resourceList = new ArrayList<>();
        for (Stock stock : stocks) {
            resourceList.add(resourceAssembler.toResource(stock));
        }
        return resourceList;
    }

    public List<Stock> fetchStocks() {
        List<Stock> stocks = new ArrayList<>();
        for (Stock stock : repository.findAll()) {
            stocks.add(stock);
        }
        return stocks;
    }

    public Resource<Stock> save(Stock stock){
        stock = repository.save(stock);
        return resourceAssembler.toResource(stock);
    }

    public Resource<Stock> fetch(Long id){
        Stock stock = repository.findOne(id);
        return resourceAssembler.toResource(stock);
    }

    public void delete(Stock stock){
        repository.delete(stock);
    }
}

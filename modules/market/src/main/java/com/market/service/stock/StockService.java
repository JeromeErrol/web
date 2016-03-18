package com.market.service.stock;

import com.market.domain.Image;
import com.market.domain.Stock;
import com.market.domain.StockRepository;
import com.market.service.image.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.hateoas.Resource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StockService {

    @Autowired
    private StockRepository repository;

    @Autowired
    private ImageService imageService;

    @Autowired
    private StockResourceAssembler resourceAssembler;

    public List<Resource<Stock>> getAll() {
        return resourceAssembler.toResources(fetchStocks());
    }

    public List<Stock> fetchStocks() {
        List<Stock> stocks = new ArrayList<>();
        for (Stock stock : repository.findAll()) {
            stocks.add(stock);
        }
        return stocks;
    }

    public Resource<Stock> save(Stock stock) {
        Image image = imageService.save(stock.getImage());
        stock.setImage(image);
        stock = repository.save(stock);
        return resourceAssembler.toResource(stock);
    }

    public Resource<Stock> fetch(Long id) {
        Stock stock = repository.findOne(id);
        return resourceAssembler.toResource(stock);
    }

    public Page<Stock> search(StockSearchCriteria searchCriteria) {
        StockSpecification stockSpecification = new StockSpecification(searchCriteria);
        return repository.findAll(stockSpecification, searchCriteria.getPageable());
    }

    public void delete(Stock stock) {
        repository.delete(stock);
    }
}

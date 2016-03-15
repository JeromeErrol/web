package com.market.service.stock;

import com.market.domain.Category;
import com.market.domain.Stock;
import com.market.domain.StockRepository;
import com.market.domain.StockSearchCriteria;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
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

    @Autowired
    private ElasticsearchOperations operations;

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

    public Resource<Stock> save(Stock stock){
        stock = repository.save(stock);
        return resourceAssembler.toResource(stock);
    }

    public Resource<Stock> fetch(Long id){
        Stock stock = repository.findOne(id);
        return resourceAssembler.toResource(stock);
    }

    public List<Resource<Stock>> search(StockSearchCriteria searchCriteria) {
        BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery();
        for (Category category: searchCriteria.getCategories()){
            queryBuilder.must(QueryBuilders.matchPhrasePrefixQuery("stock.category_id", category.getId()).maxExpansions(12));
        }
        NativeSearchQuery query = new NativeSearchQueryBuilder()
                .withQuery(queryBuilder)
                .build();
        List<Stock> stocks = operations.queryForList(query, Stock.class);
        return resourceAssembler.toResources(stocks);
    }

    public void delete(Stock stock){
        repository.delete(stock);
    }
}

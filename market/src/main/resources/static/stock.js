
$(document).ready(function () {
    Stocks.controller.init();
});

var Stocks = {

    model : {
        stocks : { },

        categories : [ ],

        getStock : function(id){
            for(var index in Stocks.model.stocks){
                var stock = Stocks.model.stocks[index];
                if(stock.id == id){
                    return stock;
                }
            };
            return null;
        }
    },

    view : {

        editStock : function(stock){
            $("#edit-stock").modal('show');
            $("#edit-stock").data("stock-id", stock.id);
            $("#edit-stock-title").val(stock.title);
            $("#edit-stock-price").val(stock.price);
            $("#edit-stock-discount").val(stock.discount);
            $("#edit-stock-category").val(stock.category.id);
        },

        getNewStock : function(){
            return {
                title : $("#create-stock-title").val(),
                category : parseInt($("#create-stock-category").val()),
                price : $("#create-stock-price").val(),
                discount : $("#create-stock-discount").val()
            };
        },

        drawStocks : function(stocks, onclick) {
            $("#stock-table-body").empty();
            $("#stock-grid").empty();


            var columnsPerRow = 5;
            var row = null;

            for(var index in stocks){
               var stock = stocks[index];
               var stockRow = Stocks.view.addStockToTable(stock);
               stockRow.click(onclick);
               stockRow.hover(function(){
                    $(this).css('cursor','pointer');
               });


               if(index % columnsPerRow == 0){
                    row = $("<div class='row'/>");
                    $("#stock-grid").append(row);
               }
               var col = $('<div class="col-md-4">' + stock.title + '</div>');
               col.append($("<p>" + stock.price + "</p>"));
               row.append(col);
            }
        },

        addStockToTable:function(stock){
            var row = $("<tr></tr>");
            row.append($("<td>" + stock.title + "</td>"));
            row.append($("<td>" + stock.price + "</td>"));
            row.append($("<td>" + stock.discount + "</td>"));
            row.data('id', stock.id);
            $("#stock-table-body").append(row);
            return row;
        },
    },

    // Deals with user input and communication to and from server
    controller : {

        filters : {
            categories : [ ]
        },

        applyFilters(){

            var filters = Stocks.controller.filters;
            var categories = filters.categories;

            var stockSearchCriteria = {
                price : parseFloat($("#filter-stock-price").val()),
                discount : parseFloat($("#filter-stock-discount").val()),
                title: $("#filter-stock-title").val(),
                categories : [

                ]
            };
            for(var index in categories){
                var category = categories[index];
                stockSearchCriteria.categories.push(category);
            }
            Stocks.service.search(stockSearchCriteria, function(stocks){
                Stocks.view.drawStocks(stocks, Stocks.controller.stockRowClicked);
            });
        },

        init : function(){
            Stocks.controller.fetchStock();
            Stocks.controller.fetchCategory();
            $("#create-stock-submit").click(Stocks.controller.createStockBtnClicked);
            $("#edit-stock-delete").click(Stocks.controller.deleteStockBtnClicked);
            $("#edit-stock-save").click(Stocks.controller.updateStockBtnClicked);
            $("#filter-stock-price").bind("input", Stocks.controller.applyFilters);
            $("#filter-stock-discount").bind("input", Stocks.controller.applyFilters);
            $("#filter-stock-title").bind("input", Stocks.controller.applyFilters);
        },

        fetchStock : function(){
            get("/stocks", function(stocks){
                Stocks.model.stocks = stocks;
                Stocks.view.drawStocks(stocks, Stocks.controller.stockRowClicked);
            });
        },

        stockRowClicked : function(e){
            var id = $(this).data("id");
            var stock = Stocks.model.getStock(id);
            Stocks.view.editStock(stock);
        },

        fetchCategory : function(){
            get("/categories", function(categories){
                $("#create-stock-category").empty();
                $("#edit-stock-category").empty();
                for(var index in categories){
                    var category = categories[index];
                    $("#create-stock-category").append(dynamic.option(category.id, category.title));
                    $("#edit-stock-category").append(dynamic.option(category.id, category.title));

                    var checkbox = dynamic.checkbox("stock-filter-category", category.id);
                    checkbox.change(Stocks.controller.categoryFilterCheckboxChanged);
                    var label = dynamic.label(category.title, null);
                    label.append(checkbox);
                    $("#filter-stock-category").append($(label));
                }
            });
        },

        categoryFilterCheckboxChanged: function(){
            var checked = $(this).is(":checked");
            var categoryId = parseInt($(this).val());
            var categories = Stocks.controller.filters.categories;

            if(checked){
                categories.push(categoryId);
            }else{
                var index = -1;
                for(var i = 0; i < categories.length; i++){
                    if(categories[i] == categoryId){
                        index = i;
                        break;
                    }
                }
                if (index > -1) {
                    categories.splice(index, 1);
                }
            }
            Stocks.controller.applyFilters();
        },

        createStockBtnClicked : function(){
            var newStock = Stocks.view.getNewStock();
            Stocks.service.create(newStock, function(stockCreated){
                var stockRow = Stocks.view.addStock(stockCreated);
            });
        },

        deleteStockBtnClicked : function(){
            var stock = {
                id : $("#edit-stock").data("stock-id")
            }

            Stocks.service.delete(stock, function(){

            });
        },

        updateStockBtnClicked : function(){
            var stock = {
                id : $("#edit-stock").data("stock-id"),
                title : $("#edit-stock-title").val(),
                price : $("#edit-stock-price").val(),
                discount : $("#edit-stock-discount").val(),
                category : parseInt($("#edit-stock-category").val())
            }
            Stocks.service.update(stock, function(){
                // updated
            });
        }
    },

    service : {
        create : function(stock, callback){
            post("/stocks/create", stock, callback);
        },

        delete : function(stock, callback){
            doDelete("/stocks", stock, callback);
        },

        update : function(stock, callback){
            put("/stocks", stock, callback);
        },

        search : function(stockSearchCriteria, callback){
            post("/stocks", stockSearchCriteria, function(stocks){
                 Stocks.model.stocks = stocks;
                 Stocks.view.drawStocks(stocks.content, Stocks.controller.stockRowClicked);
            });
        }
    }
}

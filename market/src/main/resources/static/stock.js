
$(document).ready(function () {
    Stocks.controller.init();
});

var Stocks = {

    model : {
        stocks : { },
        categories : { },

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

        drawCategories : function(categories){
            for(var index in categories){
                var category = categories[index];
                Stocks.view.addCategory(category);
            }
        },

        drawStocks : function(stocks, onclick) {
            $("#stock-table-body").empty();
            $("#create-stock-category").empty();
            for(var index in stocks){
               var stock = stocks[index];
               var stockRow = Stocks.view.addStock(stock);
               stockRow.click(onclick);
               stockRow.hover(function(){
                    $(this).css('cursor','pointer');
               });
            }
        },

        addStock:function(stock){
            var row = $("<tr></tr>");
            row.append($("<td>" + stock.title + "</td>"));
            row.append($("<td>" + stock.price + "</td>"));
            row.append($("<td>" + stock.discount + "</td>"));
            row.data('id', stock.id);
            $("#stock-table-body").append(row);
            return row;
        }
    },

    // Deals with user input and communication to and from server
    controller : {

        init : function(){
            Stocks.controller.fetchStock();
            Stocks.controller.fetchCategory();
            $("#create-stock-submit").click(Stocks.controller.createStockBtnClicked);
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
                $("#edit-stock-category").empty();
                for(var index in categories){
                    var category = categories[index];
                    var option = $("<option value='" + category.id + "'>" + category.title + "</option>");
                    $("#create-stock-category").append(option);
                    $("#edit-stock-category").append(option);
                }
            });
        },

        createStockBtnClicked : function(){
            var newStock = Stocks.view.getNewStock();
            Stocks.service.create(newStock, function(stockCreated){
                var stockRow = Stocks.view.addStock(stockCreated);
            });
        }
    },

    service : {
        create : function(stock, callback){
            post("/stocks", stock, callback);
        }
    }
}

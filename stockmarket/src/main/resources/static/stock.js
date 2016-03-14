
$(document).ready(function () {
    Stocks.controller.init();
});

var Stocks = {

    view : {

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

        drawStocks : function(stocks) {
            $("#stockTableBody").empty();
            $("#create-stock-category").empty();
            for(var index in stocks){
               var stock = stocks[index];
               Stocks.view.addStock(stock);
            }
        },

        addStock:function(stock){
            var stockTableBody = $("#stockTableBody");
            var row = $("<tr></tr>");
            row.append($("<td>" + stock.title + "</td>"));
            row.append($("<td>" + stock.price + "</td>"));
            row.append($("<td>" + stock.discount + "</td>"));
            stockTableBody.append(row);
        },

        addCategory: function(category){
            var li = $("<li class='list-group-item'>" + category.title + "</li>");
            $("#categories").append(li);

            // add category to dropdown
            // <option value="volvo">Volvo</option>
            var option = $("<option value='" + category.id + "'>" + category.title + "</option>");
            $("#create-stock-category").append(option);
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
                Stocks.view.drawStocks(stocks);
            });
        },

        fetchCategory : function(){
            get("/categories", function(categories){
                Stocks.view.drawCategories(categories);
            });
        },

        createStockBtnClicked : function(){
            var newStock = Stocks.view.getNewStock();
            Stocks.service.create(newStock, function(stockCreated){
                Stocks.view.addStock(stockCreated);
            });
        }
    },

    service : {
        create : function(stock, callback){
            post("/stocks", stock, callback);
        }
    }
}

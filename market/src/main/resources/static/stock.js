
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
               var col = $('<div class="col-sm-4"/>');
               col.append($("<p>" + stock.title + "</p>"));
               col.append($("<p>" + stock.price + "</p>"));
               col.append($("<p>" + stock.discount + "</p>"));
               col.append($("<p>" + stock.discount + "</p>"));
               var image = $("<img height=200px/>");
               image[0].src = stock.image.base64;
               col.append(image);

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
        }
    },

    // Deals with user input and communication to and from server
    controller : {

        filters : {
            categories : [ ]
        },

        data : {
            createStockImage : null
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
            Stocks.controller.fetchCategory();
            $("#create-stock-submit").click(Stocks.controller.createStockBtnClicked);
            $("#edit-stock-delete").click(Stocks.controller.deleteStockBtnClicked);
            $("#edit-stock-save").click(Stocks.controller.updateStockBtnClicked);
            $("#filter-stock-price").bind("input", Stocks.controller.applyFilters);
            $("#filter-stock-discount").bind("input", Stocks.controller.applyFilters);
            $("#filter-stock-title").bind("input", Stocks.controller.applyFilters);
            $("#toggle-view-button").click(Stocks.controller.toggleView);
            $("#stock-table").toggle(false);
            $("#create-stock-image").change(Stocks.controller.imageSelected);
            Stocks.controller.applyFilters();
        },

        toggleView:function(){
            var stockGrid = $("#stock-grid");
            var stockTable = $("#stock-table");
            stockGrid.toggle();
            stockTable.toggle();
        },

        imageSelected:function(){
            var preview = $('#create-stock-image-preview')[0]; //selects the query named img
            var file    = $('#create-stock-image')[0].files[0]; //sames as here
            var reader  = new FileReader();
            reader.onloadend = function () {
               preview.src = reader.result;
               Stocks.controller.data.createStockImage = reader.result;
            }
            if (file) {
               reader.readAsDataURL(file); //reads the data as a URL
            } else {
               preview.src = "";
            }
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
            newStock.image = Stocks.controller.data.createStockImage;

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

            post("/images/", Stocks.controller.data.createStockImage, function(image){

            });
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


var Images = {

    model : {

    },

    service : {

        select : function(id, callback){
            var image = Images.model[id];
            if(image != null){
                return image;
            }else{
                get("/images/" + id, function(image){
                    Images.model[id] = image;
                    callback(image);
                });
            }
        }
    }
}

function post(url, data, callback) {
    $.ajax({
        type: "POST",
        url: url,
        data: JSON.stringify(data),
        dataType: 'json',
        contentType: 'application/json; charset=utf-8',
        success: callback
    });
}

function put(url, data, callback) {
    $.ajax({
        type: "PUT",
        url: url,
        data: JSON.stringify(data),
        dataType: 'json',
        contentType: 'application/json',
        success: callback
    });
}

function get(url, callback) {
    $.ajax({
        type: "GET",
        url: url,
        dataType: 'json',
        contentType: 'application/json',
        success: callback
    });
}

function doDelete(url, data, callback) {
    $.ajax({
        type: "DELETE",
        url: url,
        data: JSON.stringify(data),
        dataType: 'json',
        contentType: 'application/json',
        success: callback
    });
}


var dynamic = {
    option : function(value, text){
        return $("<option value='" + value + "'>" + text + "</option>");
    },

    checkbox : function(name, value){
        return $("<input type='checkbox' name='" + name + "' value='" + value + "'/>");
    },

    label : function(text, forElement){
        return $("<label for='" + forElement + "'>" + text + "</label>");
    },

    div : function(id){
        if(id != null){
            return $("<div id='" + id + "'/>");
        }
        return $("<div/>");
    },

    span : function(){
        return $("<span/>");
    }
}
var WS = {
    post:function(data, url, callback) {
        $.ajax({
            type: "POST",
            url: url,
            data: JSON.stringify(data),
            dataType: 'json',
            contentType: 'application/json',
            success: callback
        });
    },

    put:function(data, url, callback) {
        $.ajax({
            type: "PUT",
            url: url,
            data: JSON.stringify(data),
            dataType: 'json',
            contentType: 'application/json',
            success: callback
        });
    },

    get:function(data, url, callback) {
        $.ajax({
            type: "GET",
            url: url,
            data: JSON.stringify(data),
            dataType: 'json',
            contentType: 'application/json',
            success: callback
        });
    },

    delete: function(data, url, callback) {
        $.ajax({
            type: "DELETE",
            url: url,
            data: JSON.stringify(data),
            dataType: 'json',
            contentType: 'application/json',
            success: callback
        });
    }
}
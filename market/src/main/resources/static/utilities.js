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

function put(data, url, callback) {
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

function doDelete(data, url, callback) {
    $.ajax({
        type: "DELETE",
        url: url,
        data: JSON.stringify(data),
        dataType: 'json',
        contentType: 'application/json',
        success: callback
    });
}
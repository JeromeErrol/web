var userId = 1;


$(document).ready(function () {
    view.init();
    var entries = service.getEntities(view.loadEntries);
});



var view = {

    entriesContrainer:null,
    createEntryBtn:null,
    entryInputTxt:null,

    init : function(){
        view.entriesContrainer = $("#entriesContrainer");
        view.entryInputTxt = $("#entryInputTxt");
        view.createEntryBtn = $("#createEntryBtn");
        view.createEntryBtn.click(view.createEntryBtnClicked);
    },

    loadEntries: function(entries){
        for (var index in entries){
            var entry = entries[index];
            var div = $("<div></div>")
            var p = $("<p>" + entry.text + "</p>");
            div.append(p);
            view.entriesContrainer.append(div);
        }
    },

    createEntryBtnClicked:function(e){
        service.createEntry(view.getEntryText(), function(entity){

        });
    },

    getEntryText :function(){
        return view.entryInputTxt.val();
    }
};


var service = {

    getEntities:function(callback) {
        get("/users/" + userId + "/entries", callback);
    },

    createEntry:function(text, callback){
        var entry = {
            "text" : text,
            "hash" : null,
            "userId" : userId
        }
        post(entry, "/entries", callback);
    }
};

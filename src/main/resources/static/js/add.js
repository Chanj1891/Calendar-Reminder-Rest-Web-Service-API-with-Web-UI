
function add(event) {

    var url = "/add";
    var name = document.getElementById("name").value;
    var description = document.getElementById("description").value;
    var duedate = document.getElementById("duedate").value;
    var status = document.getElementById("status").value;
    var itemJson = {};
    itemJson.name = !name?null:name;
    itemJson.description = !description?null:description;
    itemJson.duedate = !duedate?null:duedate;
    itemJson.status = !status?null:status;

    $.ajax({
        url: url, // your api url
        method: 'POST', // method is any HTTP method
        data: JSON.stringify(itemJson), // data as js object
        dataType   : 'json',
        contentType: 'application/json',
        complete: function(response) {
            var result = document.getElementById("result");
            result.innerHTML = "";
            setTimeout(function(){
                result.innerHTML += JSON.stringify(response.responseText);
            }, 250);
        }
    });
    event.preventDefault(); //by default the form buttons have submit type
}


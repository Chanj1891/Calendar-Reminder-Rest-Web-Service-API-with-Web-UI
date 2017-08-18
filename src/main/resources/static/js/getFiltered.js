function getFiltered(event) {

    var result = document.getElementById("result");
    var statusf = document.getElementById("statusf").value;
    var duedatef = document.getElementById("duedatef").value;
    var and = document.getElementById("and").checked;
    var or = document.getElementById("or").checked;


    $('#result').html("");

    if(!statusf && duedatef && !and && !or)
    {
        var url = "/get/duedate/"+duedatef;
        $.get(url, function (json) {
            $.each(json, function (i, value) {
                result.innerHTML += JSON.stringify(value);
                result.innerHTML += "\n";
            });
        });
        event.preventDefault(); //by default the form buttons have submit type
    }

    else if(statusf && !duedatef && !and && !or){
        var url = "/get/status/"+statusf;
        $.get(url, function (json) {
            $.each(json, function (i, value) {

                result.innerHTML += JSON.stringify(value);
                result.innerHTML += "\n";
            });
        });
        event.preventDefault(); //by default the form buttons have submit type
    }

    else if(statusf && duedatef && and || or){
        var url = "/get/"+duedatef+"/"+(and?"and":"or" )+"/"+statusf;
        $.get(url, function (json) {
            $.each(json, function (i, value) {

                result.innerHTML += JSON.stringify(value);
                result.innerHTML += "\n";
            });
        });
        event.preventDefault(); //by default the form buttons have submit type
    }
    else{
        result.innerHTML = "No result found";
        event.preventDefault();
    }


}
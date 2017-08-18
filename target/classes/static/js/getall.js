
function getall(event) {

    var url = "/getall";

    $.get(url, function (json) {
        $('#result').html("");
        setTimeout(function(){
            $.each(json, function (i, value) {
                var result = document.getElementById("result");
                result.innerHTML += JSON.stringify(value);
                result.innerHTML += "\n";
            });
        }, 250);
    });
    event.preventDefault(); //by default the form buttons have submit type
}


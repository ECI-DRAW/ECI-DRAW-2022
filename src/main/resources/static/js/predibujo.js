function userId() {
    const xhttp = new XMLHttpRequest();
    var idses = document.getElementsByName("idSesion")[0].value;
    var name = document.getElementsByName("userId")[0].value;
    var drawName = document.getElementsByName("drawingId")[0].value;
    //var gName = document.getElementsByName("gUserId")[0].value;

    xhttp.onload = function () {
        document.getElementById("user").style.display = "none";
        document.getElementById("application").style.display = "block";
    }
    xhttp.open("GET", "/setname?name=" + name);
    xhttp.send()
}
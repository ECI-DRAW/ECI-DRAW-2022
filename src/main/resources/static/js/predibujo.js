function userId() {
    const xhttp = new XMLHttpRequest();
    var idses = document.getElementsByName("idSesion")[0].value;
    var name = document.getElementsByName("userId")[0].value;
    var drawName = document.getElementsByName("drawingId")[0].value;
    //var gName = document.getElementsByName("gUserId")[0].value;
    fetch("/api/sesions/newsesion?idSesion=" + idses + "&name=" + name + "&answer=" + drawName, { method: "POST" })
        .then(data => data.json())
        .then(data => {
            if (data != null) {
                document.getElementById("user").style.display = "none";
                document.getElementById("application").style.display = "block";
                sessionStorage.setItem("idses", data.idses)
                sessionStorage.setItem("name", data.name)
                sessionStorage.setItem("drawName", data.drawName)
            } else {
                alert("No se pudo crear la sesión");
                window.location.href = "/"
            }

        })
}
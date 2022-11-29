function userId() {
    const xhttp = new XMLHttpRequest();
    var idSesion = document.getElementsByName("idSesion")[0].value;
    var name = document.getElementsByName("userId")[0].value;
    var answer = document.getElementsByName("drawingId")[0].value;
    //var gName = document.getElementsByName("gUserId")[0].value;
    fetch("/api/sesions/newsesion?idSesion=" + idSesion + "&name=" + name + "&answer=" + answer, { method: "POST" })
        .then(createUser(name))
        .then(connectUserxSesion(name, idSesion))
}

function createSesion(idSesion, name, answer) {
    fetch("/api/sesions/newsesion?idSesion=" + idSesion + "&name=" + name + "&answer=" + answer, { method: "POST" })
}

function createUser(username) {
    fetch("/api/users/newuser?username=" + username, { method: "POST" })
}

function connectUserxSesion(user, idSesion) {
    fetch("/api/usersxsesion/newUserXSesion?idUser=" + user + "&idSesion=" + idSesion, { method: "POST" })
}

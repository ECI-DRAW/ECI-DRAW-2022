async function userId() {
    const xhttp = new XMLHttpRequest();
    var idSesion = document.getElementsByName("idSesion")[0].value;
    var name = document.getElementsByName("userId")[0].value;
    var answer = document.getElementsByName("drawingId")[0].value;
    //var gName = document.getElementsByName("gUserId")[0].value;
    try {
        const ses = await createSesion(idSesion, name, answer);
        const us = await createUser(name);
        //const usxses = await connectUserxSesion(name, idSesion);
        //setTimeout(() => { us }, 1500);
        //window.location.href = "/dibujar.html"
    } catch (error) {

    }

}

function createSesion(idSesion, name, answer) {
    return new Promise((resolve, reject) => {
        fetch("/api/sesions/newsesion?idSesion=" + idSesion + "&host=" + name + "&answer=" + answer, { method: "POST" })
            .then(response => resolve(response.json()))
            .catch(error => reject(error))
    })
}

// function createHUser(username, idSesion) {
//     return new Promise((resolve, reject) => {
//         fetch("/api/users/newHostUser?username=" + username + "&idSesion=" + idSesion, { method: "POST" })
//             .then(response => resolve(response.json()))
//             .catch(error => reject(error))
//     })
// }

function createUser(username) {
    return new Promise((resolve, reject) => {
        fetch("/api/users/newuser?username=" + username, { method: "POST" })
            .then(response => resolve(response.json()))
            .catch(error => reject(error))
    })
}

function busca(username) {
    return new Promise((resolve, reject) => {
        fetch("/api/users/getUserByName?username=" + username, { method: "GET" })
            .then(response => resolve(response.json()))
            .catch(error => reject(error))
    })
}

function connectUserxSesion(user, idSesion) {
    return new Promise((resolve, reject) => {
        fetch("/api/usersxsesion/newUserXSesion?username=" + user + "&idSesion=" + idSesion, { method: "POST" })
            .then(response => resolve(response.json()))
            .catch(error => reject(error))
    });
}

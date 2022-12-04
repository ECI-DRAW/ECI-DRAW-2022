async function userId() {
    const xhttp = new XMLHttpRequest();
    //var name = document.getElementsByName("userId")[0].value;
    //var drawName = document.getElementsByName("drawingId")[0].value;
    var idSesion = document.getElementsByName("idSesion")[0].value;
    var username = document.getElementsByName("gUserId")[0].value;
    try {
        const guestu = await createGUser(username, idSesion);
    } catch (error) {
        //createGUser(username, idSesion);
        sessionStorage.setItem("idSesion", idSesion);
        window.location.href = '/adivinar.html';
    }
}

function createGUser(username, idSesion) {
    return new Promise((resolve, reject) => {
        fetch("/api/users/newGuestUser?username=" + username + "&idSesion=" + idSesion, { method: "POST" })
            .then(response => resolve(response.json()))
            .catch(error => reject(error))
    })
}
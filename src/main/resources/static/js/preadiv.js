async function userId() {
    const xhttp = new XMLHttpRequest();
    var idSesion = document.getElementsByName("idSesion")[0].value;
    var username = document.getElementsByName("gUserId")[0].value;
    sessionStorage.setItem("idSesion", idSesion);
    sessionStorage.setItem("username", username);
    try {
        if (username == "" || idSesion == "") {
            alert("Por favor complete todos los campos.");
        } else {
            const guestu = await createGUser(username, idSesion);
        }
    } catch (error) {
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

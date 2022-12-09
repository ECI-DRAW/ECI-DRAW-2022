async function userId() {
    const xhttp = new XMLHttpRequest();
    var idSesion = document.getElementsByName("idSesion")[0].value;
    var name = document.getElementsByName("userId")[0].value;
    var answer = document.getElementsByName("drawingId")[0].value;
    sessionStorage.setItem("idSesion", idSesion);
    sessionStorage.setItem("name", name);
    sessionStorage.setItem("answer", answer);
    try {
        if (name == "" || idSesion == "" || answer == "") {
            alert("Por favor complete todos los campos.");
        } else {
            const ses = await createSesion(idSesion, name, answer);
            window.location.href = "/dibujar.html";
        }
    } catch (error) {
        alert("La sesión ya existe, por favor ingrese otro número.");
    }
}

function createSesion(idSesion, name, answer) {
    return new Promise((resolve, reject) => {
        fetch("/api/sesions/newsesion?idSesion=" + idSesion + "&hostn=" + name + "&answer=" + answer, { method: "POST" })
            .then(response => resolve(response.json()))
            .catch(error => reject(error))
    })
}

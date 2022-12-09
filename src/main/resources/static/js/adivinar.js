var stomp;
var won;

function setup() {
    createCanvas(850, 430);
    stomp();
}

function stomp() {
    var socket = new SockJS("/stompEndpoint");
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        stompClient.subscribe("/topic/board/" + sessionStorage.getItem("idSesion"), function (event) {
            won = false;
            var json = JSON.parse(event.body);
            if (!json.eraser) {
                fill(json.colors);
                stroke(json.colors);
                strokeWeight(json.lwidth);
                line(json.xPos, json.yPos, json.pxPos, json.pyPos);
            } else {
                clear();
            }
        });
        stompClient.subscribe("/topic/win/" + sessionStorage.getItem("idSesion"), function (event) {
            alert(event.body);
            clearBoard();
        });
    });
}

function refresh(json) {
    stompClient.send("/topic/board/" + sessionStorage.getItem("idSesion"), {}, JSON.stringify(json));
}

function clearBoard() {
    clear();
    var json = {
        eraser: true,
    }
    refresh(json);
}

function adivinar() {
    let guess = prompt("Ingrese su respuesta");
    var idSesion = sessionStorage.getItem("idSesion");
    getAnswer(idSesion, guess);
}

function getAnswer(idSesion, guess) {
    fetch("/api/sesions/getSesionAnswer?idSesion=" + idSesion, { method: "GET" })
        .then(data => data.json())
        .then(data => {
            var ans = data["answer"];
            if (guess == ans) {
                won = true;
                alert("¡Correcto!");
                sendMessage();
            } else {
                alert("Intente de nuevo");
            }
            document.getElementById("btnguess").innerHTML = "Adivinar";
        })
}

function sendMessage() {
    var text = "" + sessionStorage.getItem("username") + " ha ganado la partida!!!";
    stompClient.send("/topic/win/" + sessionStorage.getItem("idSesion"), {}, text);
}

function getData() {
    if (sessionStorage.getItem("idSesion") == null && sessionStorage.getItem("username") == null) {
        window.location.href = "/index.html";
    } else {
        var idSesion = sessionStorage.getItem("idSesion");
        var username = sessionStorage.getItem("username");
        document.getElementById("idSesion").innerHTML = idSesion;
        document.getElementById("username").innerHTML = username;
    }
}

function salir() {
    sessionStorage.clear();
    window.location.href = "/index.html";
}

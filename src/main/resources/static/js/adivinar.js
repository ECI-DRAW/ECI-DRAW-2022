var stomp;

function setup() {
    createCanvas(850, 430);
    stomp();
}

function stomp() {
    var socket = new SockJS("/stompEndpoint");
    stompClient = Stomp.over(socket);
    var flag = JSON.parse('true');
    stompClient.connect({}, function (frame) {
        refresh(flag);
        stompClient.subscribe("/topic/board/" + sessionStorage.getItem("idSesion"), function (event) {
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
    });
}

function refresh(json) {
    stompClient.send("/topic/board/" + sessionStorage.getItem("idSesion"), {}, JSON.stringify(json));
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
                alert("¡Correcto!");
            } else {
                alert("Intente de nuevo");
            }
            document.getElementById("btnguess").innerHTML = "Adivinar";
        })
}

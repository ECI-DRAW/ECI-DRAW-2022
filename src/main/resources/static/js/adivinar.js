var paint = (0, 0, 0);
var stomp;
let lineWidth = 3;
var drawName;

function setup() {
    createCanvas(850, 430);
    stomp();
}

function stomp() {
    var socket = new SockJS("/stompEndpoint");
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        stompClient.subscribe("/topic/board" + sessionStorage.getItem("idSesion"), function (event) {
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

function colorSetter() {
    paint = document.getElementById("paint").value;
}

function colorEraser() {
    paint = (241, 241, 241);
}

function clearBoard() {
    clear();
    var json = {
        eraser: true,
    }
    refresh(json);
}

function refresh(json) {
    stompClient.send("/topic/board" + sessionStorage.getItem("idSesion"), {}, JSON.stringify(json));
}

function lineWidthSetter() {
    lineWidth = document.getElementById("lineWidth").value;
    strokeWeight(lineWidth);
}

function adivinar() {
    let guess = prompt("Ingrese su respuesta");
    console.log(drawName);
    if (guess == drawName) {
        alert("¡Correcto!");
    } else {
        alert("Intente de nuevo");
    }
    document.getElementById("btnguess").innerHTML = "Adivinar";
}

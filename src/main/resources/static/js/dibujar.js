var paint = (0, 0, 0);
var stomp;
let lineWidth = 3;

function setup() {
    createCanvas(850, 430);
    stomp();
}

function draw() {
    if (mouseIsPressed === true) {
        fill(paint);
        stroke(paint);
        strokeWeight(lineWidth);
        line(mouseX, mouseY, pmouseX, pmouseY);
        var json = {
            xPos: mouseX,
            yPos: mouseY,
            pxPos: pmouseX,
            pyPos: pmouseY,
            colors: paint,
            lwidth: lineWidth,
            eraser: false,
        }
        refresh(json);
    }
}

function stomp() {
    var socket = new SockJS("/stompEndpoint");
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        clearBoard()
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
        stompClient.subscribe("/topic/win/" + sessionStorage.getItem("idSesion"), function (event) {
            alert(event.body);
            clearBoard();
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
    stompClient.send("/topic/board/" + sessionStorage.getItem("idSesion"), {}, JSON.stringify(json));
}

function lineWidthSetter() {
    lineWidth = document.getElementById("lineWidth").value;
    strokeWeight(lineWidth);
}

function getData() {
    if (sessionStorage.getItem("idSesion") == null || sessionStorage.getItem("name") == null) {
        window.location.href = "/index.html";
    } else {
        var idSesion = sessionStorage.getItem("idSesion");
        var name = sessionStorage.getItem("name");
        document.getElementById("idSesion").innerHTML = idSesion;
        document.getElementById("name").innerHTML = name;
    }
}

function salir() {
    sessionStorage.clear();
    window.location.href = "/index.html";
}

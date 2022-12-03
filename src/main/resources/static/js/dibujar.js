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


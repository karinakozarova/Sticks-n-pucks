var wsUri = "wss://echo.websocket.org/";
var output;

function init() {
    output = document.getElementById("output");
    testWebSocket();
}

function testWebSocket() {
    websocket = new WebSocket(wsUri);
    websocket.onopen = function (evt) {
        onOpen(evt)
    };
    websocket.onclose = function (evt) {
        onClose(evt)
    };
    websocket.onmessage = function (evt) {
        onMessage(evt)
    };
    websocket.onerror = function (evt) {
        onError(evt)
    };
}

function onOpen(evt) {
    writeToScreen("The websocket is OPEN!");
}

function onClose(evt) {
    // writeToScreen("Chat closed SUCCESFULLY!");
    document.getElementById("userInput").style.visibility = "hidden";
}

async function onMessage(evt) {
    await new Promise(r => setTimeout(r, 1000));
    printMessage = "<div class=\"bg-gray-300 text-black w-3/4 mx-4 my-2 p-2 rounded-lg\" style='padding-top: 20px;'>" + evt.data + "</div> <br>";
    writeToScreen(printMessage);
}

function onError(evt) {
    writeToScreen('<span style="color: red;">ERROR:</span> ' + evt.data);
}

function doSend(message) {
    printMessage = "<div class=\"bg-green-300 float-right w-3/4 mx-4 my-2 p-2 rounded-lg clearfix text-white\" style='padding-top: 20px;'>" + message + "</div> <br>"
    writeToScreen(printMessage);
    websocket.send(message);
}

function writeToScreen(message) {
    var pre = document.createElement("p");
    pre.style.wordWrap = "break-word";
    pre.innerHTML = message;
    output.appendChild(pre);
}

function sendMessageViaSocket() {
    var input = document.getElementById("userInput").value;
    doSend(input);
}

function exitChat() {
    websocket.close();
    // writeToScreen("Socket is closed SUCCESFULLY!");
}

window.addEventListener("load", init, false);
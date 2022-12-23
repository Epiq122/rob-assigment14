function initialSetup() {
    const username = sessionStorage.getItem("username");
    const channelId = sessionStorage.getItem("channelId");
    if (!username || !channelId) {
        window.location.href = "../welcome";
    }
}

initialSetup();


const textarea = document.querySelector('#textarea');
const messagesElement = document.querySelector("#messages");
const channelId = sessionStorage.getItem("channelId");

textarea.addEventListener("keypress", (event) => {
    if (event.keyCode === 13) {
        sendMessage();
    }
});

function sendMessage() {
    const username = sessionStorage.getItem("username");
    const messageBody = textarea.value;
    textarea.value = "";

    const message = {
        sender: username,
        body: messageBody,
        channelId: channelId
    };

    fetch(`/channels/${channelId}/messages`, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(message)
    }).then((response) => response.json())
        .then((data) => {
            displayMessages(data);
        });
}

function displayMessages(messages) {
    messagesElement.innerHTML = "";
    messages.forEach((message) => {
        const messageDiv = document.createElement("div");
        messageDiv.classList.add("message");

        const senderBold = document.createElement("b");
        senderBold.classList.add("sender");
        senderBold.textContent = `${message.sender}: `;

        const bodySpan = document.createElement("span");
        bodySpan.classList.add("body");
        bodySpan.textContent = message.body;

        messageDiv.appendChild(senderBold);
        messageDiv.appendChild(bodySpan);
        messagesElement.appendChild(messageDiv);
    });
}

function getMessages() {
    fetch(`/channels/${channelId}/messages`)
        .then((response) => response.json())
        .then((data) => {
            displayMessages(data);
        });
}

setInterval(getMessages, 500);

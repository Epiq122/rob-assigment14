const textarea = document.querySelector('#textarea');
const channelId = sessionStorage.getItem("channelId");


function initialSetup() {
    if (sessionStorage.getItem("username") == null) {
        window.location.href = "../welcome";
    }

    if (sessionStorage.getItem("channelId") == null) {
        window.location.href = "../welcome";
    }

}

initialSetup();

function createMessageElements() {
    const messageDiv = document.createElement("div");
    messageDiv.setAttribute("class", "message");
    const boldText = document.createElement("b");
    boldText.setAttribute("class", "sender");
    boldText.innerHTML = `${item.sender}: `;
    const span = document.createElement("span");
    span.setAttribute("class", "body");
    span.innerHTML = `${item.body}`;
    messageDiv.appendChild(boldText);
    messageDiv.appendChild(span);
    document.querySelector("#messages").appendChild(messageDiv);

}


const sendMessage = textarea.onkeyup = event => {
    const keyCode = event.keyCode
    if (keyCode === "enter" || keyCode === "13") {
        const username = sessionStorage.getItem("username");
        const messageBody = textarea.value;
        textarea.value = "";

        const message = {
            "sender": username,
            "body": messageBody,
            "channelId": channelId
        };

        fetch(`/channels/${channelId}/messages`, {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(message)
        }).then((response) => response.json())
            .then(data => {
                document.querySelector("#messages").innerHTML = ``;

                for (const item of data) {
                    createMessageElements();
                }
            });
    }
}
setInterval(sendMessage, 500);
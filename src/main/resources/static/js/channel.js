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


textarea.onkeypress = event => {
    const keyCode = event.keyCode
    if (keyCode === 13) {
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
                    const messageDiv = document.createElement("div");
                    messageDiv.setAttribute("class", "message");
                    const senderBold = document.createElement("b");
                    senderBold.setAttribute("class", "sender");
                    senderBold.innerHTML = `${item.sender}: `;
                    const bodySpan = document.createElement("span");
                    bodySpan.setAttribute("class", "body");
                    bodySpan.innerHTML = `${item.body}`;
                    messageDiv.appendChild(senderBold);
                    messageDiv.appendChild(bodySpan);
                    document.querySelector("#messages").appendChild(messageDiv);
                }
            });
    }
}


function getMessages() {
    fetch(`/channels/${channelId}/messages`)
        .then(response => response.json())
        .then(data => {
            document.querySelector("#messages").innerHTML = "";
            for (let i = 0; i < data.length; i++) {
                const messageDiv = document.createElement("div");
                messageDiv.setAttribute("class", "message");
                const senderBold = document.createElement("b");
                senderBold.setAttribute("class", "sender");
                senderBold.innerHTML = `${data[i].sender}: `;
                const bodySpan = document.createElement("span");
                bodySpan.setAttribute("class", "body");
                bodySpan.innerHTML = `${data[i].body}`;
                messageDiv.appendChild(senderBold);
                messageDiv.appendChild(bodySpan);
                document.querySelector("#messages").appendChild(messageDiv);
            }
        });


}


setInterval(getMessages, 500);
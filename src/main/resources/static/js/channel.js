const chatBox = document.getElementById("chatBox");
const messageContainer = document.getElementById("message-container");


chatBox.addEventListener('keypress', event => {
    if (event.key === 'Enter') {
        let message = {
            content: chatBox.value,
            channelId: channelId,
            userId: userId,
            createDate: new Date()

        }
        let text = chatBox.value
        chatBox.value = ""
        fetch("/messages", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(message)
        }).then(() => {
            getMessages()
        })
        return false;
    }
})


// make a get messages requesr
function getMessages() {
    fetch("/messages/" + channelId)
        .then(response => response.json())
        .then(messages => {
            messageContainer.innerHTML = "";
            messages.forEach(message => {
                let messageElement = document.createElement("div");
                messageElement.innerHTML = message.content;
                messageContainer.append(messageElement);
            })
        })
}


// function getMessages() {
//     fetch(`/messages/${channelId}`)
//         .then(response => response.json())
//         .then(messages => {
//             messages.forEach(message => {
//                 messageContainer.innerHTML += `<div>
// 			  <span class="timestamp">${message.user.name}: </span>
// 		  	  <span class="message">${message.text}</span>
// 			</div>`
//             })
//         })
//
//
// }




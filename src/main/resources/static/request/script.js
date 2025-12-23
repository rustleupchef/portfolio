window.onload = function() {
    const xhr = new XMLHttpRequest();
    xhr.open("POST", window.location.href);
    xhr.onload = function() {
        if (xhr.readyState === 4 && xhr.status === 200) {
            console.log(xhr.responseText);
            const ticket = JSON.parse(xhr.responseText);

            const title = document.createElement("title");
            title.innerText = ticket.subject;
            document.head.append(title);

            document.getElementById("title").innerText = ticket.subject;
            document.getElementById("description").innerText = ticket.message;
            document.getElementById("user").innerText = ticket.user;
            
        }
    }
    xhr.send();
}


function resolve() {
    const xhr = new XMLHttpRequest();
    const id = new URLSearchParams(window.location.href.split("?")[1]).get("id");
    xhr.open("POST", `/resolve?id=${encodeURIComponent(id)}`);
    xhr.onload = function() {
        console.log(xhr.responseText);
        const parsedData = JSON.parse(xhr.responseText)
        if (parsedData.type === "success") {
            location.assign("/");
        } else {
            alert(parsedData.message);
        }
    }
    xhr.send();
}
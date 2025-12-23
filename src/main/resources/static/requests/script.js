window.onload = function() {
    const xhr = new XMLHttpRequest();
    xhr.open("POST", "/requests");
    xhr.onload = function() {
        if (xhr.readyState === 4 && xhr.status === 200) {
            const tickets = JSON.parse(xhr.responseText);
            const container = document.querySelector(".container");
            for (let ticket of tickets) {
                const request = document.createElement("div");
                request.className = "request-box";

                request.onclick = function() {
                    location.assign(`/request?id=${encodeURIComponent(ticket.ticket_id)}`);
                }

                const title = document.createElement("div");
                title.innerText = ticket.subject;

                const user = document.createElement("h2");
                user.innerText = ticket.user;

                request.appendChild(title);
                request.appendChild(user);

                container.append(request);
            }
        }
    }
    xhr.send();
}
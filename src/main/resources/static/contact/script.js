function ticket() {
    const subject = document.getElementById("subject").value;
    const description = document.getElementById("description").value;
    const contact = document.getElementById("personal-contact").value;

    const data = {
        subject : subject,
        message : description,
        contact : contact
    };

    const xhr = new XMLHttpRequest();
    xhr.open("POST", "/contact");
    xhr.setRequestHeader("Content-Type", "application/json");

    xhr.onload = function() {
        if (xhr.readyState === 4 && xhr.status === 200) {
            console.log(xhr.responseText);
            const parsedData = JSON.parse(xhr.responseText)
            if (parsedData.type === "success") {
                location.assign("/");
            } else {
                alert(parsedData.message);
            }
        }
    }

    xhr.send(JSON.stringify(data));
}
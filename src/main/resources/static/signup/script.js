function signup() {
    const username = document.getElementById("username").value;
    const password = document.getElementById("password").value;

    if (username.length < 1) {
        alert("Please enter a valid username");
        return;
    }

    if (password.length < 5) {
        alert("Please enter a password of 5 or greater length");
        return;
    }

    const xhr = new XMLHttpRequest();
    xhr.open("POST", "/signup");
    xhr.setRequestHeader("Content-Type", "application/json");
    const data = {
        username: username,
        password: password
    };

    xhr.onload = function() {
        if (xhr.readyState === 4 && xhr.status === 200) {
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
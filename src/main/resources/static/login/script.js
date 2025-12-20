function login() {
    const username = document.getElementById("username").value;
    const password = document.getElementById("password").value;

    if (username.length < 1) {
        alert("Please enter a username");
        return;
    }

    if (password.length < 1) {
        alert("Please enter a password");
        return;
    }

    const xhr = new XMLHttpRequest();
    xhr.open("POST", "/login");
    xhr.setRequestHeader("Content-Type", "application/json");
    const data = {
        username: username,
        password: password
    };

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
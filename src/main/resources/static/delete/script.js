function destroy() {
    if (document.getElementById("confirm").value !== "DELETE") {
        alert("You did not type in the correct word");
        return;
    }

    const xhr = new XMLHttpRequest();
    console.log(window.location.href);
    xhr.open("POST", window.location.href);
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
    xhr.send();
}
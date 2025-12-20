window.onload = function() {
    const xhr = new XMLHttpRequest();
    xhr.open("POST", window.location.href);
    xhr.onload = function() {
        if (xhr.readyState === 4 && xhr.status === 200) {
            console.log(xhr.responseText);
            const project = JSON.parse(xhr.responseText);

            const title = document.createElement("title");
            title.innerText = project.title;
            document.head.append(title);

            document.getElementById("title").innerText = project.title;
            document.getElementById("image").src = project.img;
            document.getElementById("description").innerText = project.description;

            const skills = document.getElementById("skills");
            for (let skill of project.skills) {
                const skillItem = document.createElement("li");
                skillItem.innerText = skill;
                skills.appendChild(skillItem);
            }
        }
    }
    xhr.send();
}
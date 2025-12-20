window.onload = function() {
    const xhr = new XMLHttpRequest();
    xhr.open("POST", "/projects");
    xhr.onload = function() {
        if (xhr.readyState === 4 && xhr.status === 200) {
            const container = document.querySelector(".container");
            const projects = JSON.parse(xhr.responseText);
            for (let project of projects) {
                const projectDiv = document.createElement("div");
                projectDiv.innerText = project.title;
                projectDiv.className = "project-box";
                projectDiv.onclick = function() {
                    location.assign("/project?id=" + encodeURIComponent(project.project_id));
                }
                container.appendChild(projectDiv);
            }
        }
    }
    xhr.send();
}
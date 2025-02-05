console.log("Script.js Loaded");

// Add event listeners to all sidebar links for smooth scrolling
document.querySelectorAll('.sidebar a').forEach(anchor => {
    anchor.addEventListener('click', function (e) {
        console.log(`Navigating to ${this.textContent}`);
    });
});

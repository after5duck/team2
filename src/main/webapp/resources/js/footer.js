let heartState = false;

document.getElementById("footer_btn").addEventListener("click", function () {
	const show = document.getElementById("text_box");

	if (!heartState) {
		show.style.display = "block";
		heartState = true;
	} else {
		show.style.display = "none";
		heartState = false;
	}
})
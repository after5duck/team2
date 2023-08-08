document.addEventListener('DOMContentLoaded', function () {
	var allCheck = document.getElementById("check1");
	var check2 = document.getElementById("check2");
	var check3 = document.getElementById("check3");
	var check4 = document.getElementById("check4");
	var individualChecks = [check2, check3, check4];

	function updateAllCheckStatus() {
		if (check2.checked && check3.checked && check4.checked) {
			allCheck.checked = true;
		} else {
			allCheck.checked = false;
		}
	}

	check2.addEventListener('change', updateAllCheckStatus);
	check3.addEventListener('change', updateAllCheckStatus);
	check4.addEventListener('change', updateAllCheckStatus);

	allCheck.addEventListener('change', function () {
		var isChecked = allCheck.checked;
		check2.checked = isChecked;
		check3.checked = isChecked;
		check4.checked = isChecked;
	});
});

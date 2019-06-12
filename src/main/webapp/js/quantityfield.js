//js for hide and show quantity field according to checkbox

$(document).ready(function () {
	alert("start")
    $('input[type="checkbox"]').click(function () {
        var inputValue = $(this).attr("id");
        alert(inputValue);
        $("." + inputValue).toggle();
    });
});
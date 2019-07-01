function setAppNum(num) {
    document.getElementById("appId").value = num;
    $("#setDriverHeader").text("Set driver for application #" + num);
}

function login() {
    $.ajax({
        url: "/login",
        type: "POST",
        data: "username=" + $("#username").val() + "&password=" + $("#password").val(),
        success: function (data) {
            if (data["error"]) {
                Swal.fire(data["error"]);
            }
            else {
                location.href="/index.html";
            }
        },
    })
}
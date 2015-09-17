$(function() {
    $("#up_month").click(function () {
        alert(43366666635);
        var t = $("#up_month").val();
        $.ajax({
            type: "GET",
            url: "changeDay.do",
            dataType: "json",
            contentType: 'application/json',
            data: {upOrDown: t},
            success: function (data) {
                alert(1);
            }
        });
    });
});
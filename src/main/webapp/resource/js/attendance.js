$(function() {
    $(".upOrDown_month").click(function () {
        /**通过事件源*/
        var t = $(event.target).val();
        $.ajax({
            type: "GET",
            url: "http://localhost:8080/kaoqin/admin/changeDay.do",
            dataType: "json",
            contentType: 'application/json',
            data: {upOrDown: t},
            success: function (data) {
                /**返回天数*/
                var list = data.data.dateList;
                var len = list.length;
                for(var i=0;i<len;i++){
                    var cla ;
                    var index =i+1;
                    if(i<9){
                        cla = ".date0"+index;
                    }else(
                        cla = ".date"+index
                    )
                    /*alert(cla);
                    alert(list[i])*/
                    $(cla).text(list[i]);
                }
            }
        });
    });
});
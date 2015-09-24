$(function() {

    /**编辑的切换*/
    $('#attendance_edit').click(function(){

        $("#attendance_edit").addClass("hidden");
        $("#attendance_cancle").removeClass("hidden");
        $("#attendance_submit").removeClass("hidden");

        /**可以编辑考勤 状态*/
        $('#attendance_form input').each(function(){
            $(this).removeAttr("readonly");
            $(this).parent('td').addClass("info");
        });
    });
    $('#attendance_cancle').click(function(){
        $("#saveAttend_msg").text("");
        $("#attendance_edit").removeClass("hidden");
        $("#attendance_cancle").addClass("hidden");
        $("#attendance_submit").addClass("hidden");

        /**不可编辑考勤 状态*/
        $('#attendance_form input').each(function(){
            $(this).attr("readonly","readonly");
            $(this).parent('td').removeClass("info");
        });
    });
    /**编辑后提交*/
    $('#attendance_submit').click(function(){
        var jsonStr = '{"attendanceVoList":[';
        $('#attendance_form input').each(function(){
            var des = $(this).val().trim();
            //{"attendanceVoList":[{"description":"p","userId":1,"day":"sd"},{}]}
            /**有考勤记录 编辑*/
            if(des){
                var content = '{"description":"'+des+'",';
                var info = $(this).parent("td").find("span").text().trim();
                jsonStr += content+info+'},'
            }
        });
        var index = jsonStr.lastIndexOf(",");
        var json =jsonStr.substring(0,index);
        json=json+"]}";
        console.log(json);
        $.ajax({
            type:'POST',
            url:"http://localhost:8080/kaoqin/admin/saveAttendance.do",
            dataType: "json",
            contentType:"application/json",
            data:json,
            success:function(data){
                $("#saveAttend_msg").text(data.msg);
            }
        });
    });


    /**导出excel*/
   /* $('#create_excel').click(function(){
        alert(1);
        $.ajax({
            type:'GET',
            url:"http://localhost:8080/kaoqin/admin/createExcel.do",
            dataType:"json",
            success:function(data){
                alert(data.msg);
                $("#saveAttend_msg").text(data.msg);
            }
        });
    });*/

});
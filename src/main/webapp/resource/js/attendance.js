$(function() {
    /**查询条件默认月份*/
   /* var now= new Date();
    var year=now.getYear()+1900;
    var month=now.getMonth()+1;
    $('#month_year_project .month option').each(function(){
        var month_select = $(this).text();
        if(month_select == month){
            $(this).attr('selected','true');
        }
    });
    /!**查询条件默认年份*!/
    $('#month_year_project .year option').each(function(){
        var year_select = $(this).text();
        if(year_select == year){
            $(this).attr('selected','true');
        }
    });*/
    /**根据条件查询*/
    $('#search_condition').click(function(){
        var year_select = $('#month_year_project .year').val();
        var month_select = $('#month_year_project .month').val();
        var project_id = $('#month_year_project .project').val();
        var url ="findByCondition.do?projectId="+project_id+"&year="+year_select+"&month="+month_select;
        location.href=url;
        /*$.ajax({
            type:'GET',
            url:"findByCondition.do",
            dataType: "json",
            data:{"projectId":project_id,"year":year_select,"month":month_select},
            success:function(data){
               alert(123123);
            }
        });*/
    });

    /**编辑的切换*/
    $('#attendance_edit').click(function(){

        $("#attendance_edit").addClass("hidden");
        $("#attendance_cancle").removeClass("hidden");
        $("#attendance_submit").removeClass("hidden");
        $("#saveAttend_msg").addClass("hidden");
        /**可以编辑考勤 状态*/
        $('#attendance_form input').each(function(){
            $(this).removeAttr("readonly");
            $(this).parent('td').addClass("info");
        });
    });
    $('#attendance_cancle').click(function(){
        $("#saveAttend_msg").addClass("hidden");
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
            url:"saveAttendance.do",
            dataType: "json",
            contentType:"application/json",
            data:json,
            success:function(data){
                $("#saveAttend_msg").removeClass("hidden");
                $("#saveAttend_msg").text(data.msg);
            }
        });
    });


    /**导出excel*/
    $('#create_excel').click(function(){
        $.ajax({
            type:'GET',
            url:"createExcel.do",
            dataType:"json",
            success:function(data){
                $("#saveAttend_msg").removeClass("hidden");
                $("#saveAttend_msg").text(data.msg);
            }
        });
    });

});
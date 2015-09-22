$(function() {
    /**编辑的切换*/
    $('#attendance_edit').click(function(){
        $("#attendance_edit").addClass("hidden");
        $("#attendance_cancle").removeClass("hidden");
        $("#attendance_submit").removeClass("hidden");

        /**可输入input*/
        $('#attendance_form input').each(function(){
            $(this).removeAttr("readonly");
        });
    });
    $('#attendance_cancle').click(function(){
        $("#attendance_edit").removeClass("hidden");
        $("#attendance_cancle").addClass("hidden");
        $("#attendance_submit").addClass("hidden");

        /**不可输入input*/
        $('#attendance_form input').each(function(){
            $(this).attr("readonly","readonly");
        });
    });
    /**编辑后提交*/
    $('#attendance_submit').click(function(){
        $('#attendance_form input').each(function(){
            console.log($(this).val());
        });
    });

});
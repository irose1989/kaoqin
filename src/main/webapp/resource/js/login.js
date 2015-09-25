/**登入界面*/

$(function(){
    /**清空消息*/
    $('#user_msg').text("");
    $('#password_msg').text("");
    $('#login_msg').text("");
    $('#isoftNo').blur(function(){

        if($("#isoftNo").val().length==0){
            $('#user_msg').text("用户名不能为空");
            return;
        }
        $('#user_msg').text("");
        $('#login_msg').text("");
    });
    $('#password').blur(function(){
        if($("#password").val().length==0){
            $('#password_msg').text("密码不能为空");
            return;
        }
        $('#password_msg').text("");
        $('#login_msg').text("");
    })
    $('#loginBtn').click(function(){
        /**如果input 为空返回*/
        $('#login input').each(function(){
            if(!$(this).val()){
                $('#login_msg').text("请看提示");
                return loop;
            }
        });
        var isoftNo =$('#isoftNo').val();
        var password =$('#password').val();
        /**输入框不为空*/
        $.ajax({
            type:'GET',
            url:"toLogin.do",
            contentType:"application/json",
            dataType: "json",
            data:{"isoftNo":isoftNo,"password":password},
            success:function(data){
                alert(data.msg);
            }
        });
    });
    loop;
});
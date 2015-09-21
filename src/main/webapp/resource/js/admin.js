/**批量注册框*/
$(function(){
    var count = 1;
    $("#add_more_account").click(function(){
        count++;
        var cla = "create_account"+count
        $("#add_more_account").before('<div class="'+cla+'"><input class="span3"  type="text" name="isoftNo"><button class="btn remove" style="color: #cc374b">删除</button><span style="color: red;font-size: small"></span></div>');
    })

    /**删除输入框*/
    $("#create_account").on("click",'.remove',function(e){
        $(e.target).parent('div').remove();
    })

})

/**失去焦点检查是否为空，用户是否已经注册提示*/
$(function(){

    $("#create_account").on("blur",'input',function(e){
        $(e.target).parent('div').find('span').text("");
        $('#create_msg').text("");
        var no =$(e.target).val()
        if(!no){
            $(e.target).parent('div').find('span').text("账号不能为空");
            return;
        }
        /**检查用户是否已经注册*/
        $.ajax({
            type:'GET',
            url:"http://localhost:8080/kaoqin/admin/checkUser.do",
            dataType: "json",
            data:{"isoftNo":no},
            success:function(data){
                var code = data.code;
                var msg = data.msg;
                if(code==3){
                    $(e.target).parent('div').find('span').text(msg);
                    return;
                }
            }
        });
    })
})

$(function(){
    $("#bitch_openAccount").click(function(){
        /**遍历还有没提示消息*/
        $('#create_account span').each(function(index,element){
            var msg = $(this).text();
            if(msg){
                $('#create_msg').text("请按提示填写");
                return;
            }
        });
        var json = {};
        x=$("form").serializeArray();
        var json='{"userVoList":['
        $.each(x, function(i, field){
            json +=('{"'+field.name +'"'+ ":" + '"'+field.value+'"}' + ",");
        });
        var index =json.lastIndexOf(",");
        json =json.substring(0,index)+"]}";
        alert(json)
        var ttt ='{"userVoList":[{"isoftNo":"123"},{"isoftNo":"1234"}]}'
        alert(ttt);

        $.ajax({
            type:'POST',
            url:"http://localhost:8080/kaoqin/admin/batchOpenAccount.do",
            contentType:"application/json",
            dataType: "json",
            data:json,
            success:function(data){
                var msg = data.msg;
                $('#create_msg').text(msg);
            }
        });
    });
})
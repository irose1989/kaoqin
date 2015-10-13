/**批量注册框*/
$(function(){
    var count = 1;
    $("#add_more_account").click(function(){
        count++;
        var cla = "create_account"+count
        $("#add_more_account").before('<div class="'+cla+'"><input class="span3"  type="text" name="isoftNo"><button class="btn remove" style="color: #cc374b">删除</button><span style="color: red;font-size: small"></span></div>');

        swithchOpen();
    })

    /**删除输入框*/
    $("#create_account").on("click",'.remove',function(e){
        $(e.target).parent('div').remove();
        swithchOpen();
    })
})

/**开通账号名字切换方法*/
function swithchOpen(){
    /**多个输入框显示批量开通*/
    var inputCounts =$('#create_account input').length;
    if(inputCounts==1){
        $('#bitch_openAccount').text("开通账号");
    }else{
        $('#bitch_openAccount').text("批量开通账号");
    }
}

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
                url:"checkUser.do",
                contentType:"application/json",
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
    loop:
    $("#bitch_openAccount").click(function(){
        /**遍历 有无提示消息                return 跳出一个方法？？？？？？？？？？？？？*/

        $('#create_msg').text("")
        $('#create_account input').each(function(){
            var input = $(this).val();
            if(!input){
                $(this).parent('div').find('span').text("账号不能为空");
                return loop;
            }
        });
        $('#create_account span').each(function(index,element){
            var msg = $(this).text();
           /* alert(msg);*/
            if(msg){
                $('#create_msg').text("请按提示填写");
                return loop;
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
        var ttt ='{"userVoList":[{"isoftNo":"123"},{"isoftNo":"1234"}]}'
        $.ajax({
            type:'POST',
            url:"batchOpenAccount.do",
            contentType:"application/json",
            dataType: "json",
            data:json,
            success:function(data){
                var code = data.code;
                var msg = data.msg;
                if(code == 6){
                    $('#create_msg').text(msg);
                }else{
                    $('#create_msg').text(msg);
                }

            }
        });
    });
})
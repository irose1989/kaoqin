var power;

$(function(){

    /*$("#id1").focus(function(){
        $("#id1").hide();
        $("#id2").show();
        $("#id2").focus();
    });

    $("#id2").blur(function(){
        if($("#id2").val().length==0){
            $("#id2").hide();
            $("#id1").show();
        }
    });

    $("#name1").focus(function(){
        $("#name1").hide();
        $("#name2").show();
        $("#name2").focus();
    });

    $("#name2").blur(function(){
        if($("#name2").val().length==0){
            $("#name2").hide();
            $("#name1").show();
        }
    });*/

    $('#search_form button').click(function(){
        $('#search_form .search_msg').text("");
        var realName = $('#search_form .real_name').val();
        var projectName = $('#search_form .project_name').val();
        var isoftNo = $('#search_form .isoftNo').val();
        if(!realName && !projectName && !isoftNo){
            $('#search_form .search_msg').text("搜索条件不能全为空");
        }else{
            //不为空
            $.ajax({
                type:'GET',
                url:"searchUser.do",
                dataType:"json",
                data:{"realName":realName,"isoftNo":isoftNo,"projectName":projectName},
                success:function(data){
                    var userVoList = data.data;
                    var len = userVoList.length;
                    /*alert(userVoList[0].roleId);*/
                    /*<tr><td>1</td><td>张三</td><td>网商银行</td><td>普通员工</td>
                    <td><a href="javascript:;" class="change">修改权限</a>/<a href="javascript:;" class="delete">删除</a></td>
                    </tr>*/
                    for(var i =0;i<len;i++){
                        var index = i+1;
                        var user = userVoList[i];
                        var isoftNo = user.isoftNo;
                        var name = user.realName;
                        var projectName = user.projectName;
                        var roleId = user.roleId;
                        var row ='<tr><td>'+isoftNo+'</td><td>'+name+'</td><td>'+projectName+'</td>' +
                            '<td>'+roleId+'</td><td><a href="javascript:;" class="change">修改权限' +
                            '</a>/<a href="javascript:;" class="delete">删除</a></td></tr>'
                        $('#search_table').append(row);
                    }

                }
            });
        }
        return false;

    });

    //�޸�Ȩ��
    $('tbody').on("click",".change",function(){

        var att=$(this).parent().prev();
        power=att.text();
        //alert(att.html());
        var htmlString='<select id="changeSelect"><option value="普通员工">普通员工</option><option value="项目经理">项目经理</option><option value="管理员">管理员</option></select>';
        att.html(htmlString);
        $("#changeSelect").focus();
    });


    $('tbody').on("change","#changeSelect",function(){

        if(confirm("确定修改")){
            power=$("#changeSelect").val();

        }

        $("#changeSelect").parent().html(power);
    });

    $('tbody').on("blur","#changeSelect",function(){
        //alert($("#changSelect").val());
        $("#changeSelect").parent().html(power);
    });

    //ɾ��
    $('tbody').on("click",".delete",function(){
        if(confirm("确定删除")){
            $(this).parent().parent().remove();
        }
    });



});
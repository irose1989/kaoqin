var power;

$(function(){
    var arr = [];
    console.log(arr.length);
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
                    for(var i =0;i<len;i++){
                        var index = i+1;
                        var user = userVoList[i];
                        var isoftNo = user.isoftNo;
                        arr.push(isoftNo);
                        var name = user.realName;
                        var projectName = user.projectName;
                        var roleId = user.roleId;
                        var role = getRoleName(roleId);
                        var add = true;
                        var arrSize = arr.length;
                        for(var j = 0;j<arrSize-1;j++){
                            var preIsoftNo = arr[j];
                            if(isoftNo == preIsoftNo){
                                add = false;
                                arr.pop(isoftNo);
                                break;
                            }
                            add = true;
                        }
                        if(add){
                            var row ='<tr><td>'+isoftNo+'</td><td>'+name+'</td><td>'+projectName+'</td>' +
                                '<td>'+role+'</td><td><a href="javascript:;" class="change">修改权限' +
                                '</a>/<a href="javascript:;" class="delete">删除</a></td></tr>'
                            $('#search_table').append(row);
                        }
                    }
                    console.log(arr);
                }
            });
        }
        return false;

    });

    /**修改权限*/
    $('tbody').on("click",".change",function(){

        var att=$(this).parent().prev();
         power=att.text();
        //alert(att.html());
        var htmlString='<select id="changeSelect"><option value="1">普通员工</option><option value="3">项目经理</option><option value="2">管理员</option></select>';
        att.html(htmlString);
        $("#changeSelect").focus();
    });


    $('tbody').on("change","#changeSelect",function(){
        var roleId;
        if(confirm("确定修改")){
            roleId=$("#changeSelect").val();
        }
        var role = getRoleName(roleId);
        $("#changeSelect").parent().html(role);
    });

    $('tbody').on("blur","#changeSelect",function(){
        //alert($("#changSelect").val());
        $("#changeSelect").parent().html(power);
    });

    //删除
    $('tbody').on("click",".delete",function(){
        if(confirm("确定删除")){
            var isoftNo = $(this).parent().parent().children('td:eq(0)').text();
            removeItem(arr,isoftNo);
            console.log(arr);
            $(this).parent().parent().remove();
        }
    });

});
/**获取角色名称*/
function getRoleName(roleId){
    var role;
    if(roleId == 1){role='普通员工';}
    if(roleId == 2){role='管理员';}
    if(roleId == 3){role='项目经理';}
    return role;
};
function removeItem(arys,item){
    for(var i=0;i < arys.length;i++) {
        if(item == arys[i]) arys.splice(i,1);
    }
}
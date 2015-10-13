var power;

$(function(){
    $('#search_form button').click(function(){
        var arr = [];
        /**每次搜索table都清空*/
        var rows = $('#search_table tr');

        for(var i=1;i<rows.length;i++){
            rows[i].remove();
        }
        $('#search_form .search_msg').text("");
        var realName = $('#search_form .real_name').val();
        var projectId = $('#search_form .project').val();
        /*var projectName = $('#search_form .project_name').val();*/
        var isoftNo = $('#search_form .isoftNo').val();
        $.ajax({
            type:'GET',
            url:"searchUser.do",
            dataType:"json",
            data:{"realName":realName,"isoftNo":isoftNo,"projectId":projectId},
            success:function(data){
                var userVoList = data.data;
                if(!userVoList){return;}
                var len = userVoList.length;
                for(var i =0;i<len;i++){
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
                            '<td><input hidden value='+roleId+'>'+role+'</td><td><a href="javascript:;" class="change">修改权限' +
                            '</a>/<a href="javascript:;" class="delete">删除</a><span hidden>'+roleId+'</span></td></tr>'
                        $('#search_table').append(row);
                    }
                }
            }
        });

        //删除
        $('tbody').on("click",".delete",function(){
            if(confirm("确定删除")){
                var isoftNo = $(this).parent().parent().children('td:eq(0)').text();
                removeItem(arr,isoftNo);
                $(this).parent().parent().remove();
            }
        });
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

        /**默认显示身份*/
        var row = $(this).parent().parent();
        var preRoleId = row.find("span").text();
        var options = $('#changeSelect option');
        var len = options.size();
        for(var i =0;i<len;i++){
            if(options[i].value==preRoleId){
                options[i].selected = true;
            }
        }
    });

    $('tbody').on("change","#changeSelect",function(){
        var row = $(this).parent().parent();
        var isoftNo = $("#changeSelect").parent().parent().children('td:eq(0)').text();
        var roleId;
        if(confirm("确定修改")){
            roleId=$("#changeSelect").val();
            $.ajax({
                type:'GET',
                url:"changeRole.do",
                dataType:"json",
                data:{"isoftNo":isoftNo,"roleId":roleId},
                success:function(data){
                    row.find("span").text(roleId);
                }
            });
        }
        var role = getRoleName(roleId);
        $("#changeSelect").parent().html(role);
    });

    $('tbody').on("blur","#changeSelect",function(){
        //alert($("#changSelect").val());
        $("#changeSelect").parent().html(power);
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
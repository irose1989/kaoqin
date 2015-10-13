/**员工编辑个人页面*/
$(function(){
    /**清空提示语*/
    $('#userInfoEdit .warn').text("");
    /**该页面登入时默认的选项*/
    var infoUser = $('#userInfo_warn').text();
    var json_userInfo = eval('('+infoUser+')');

    /**项目：*/
    var projectId = json_userInfo.projectId;
    projectId = noId(projectId);
    var options = $('#userInfoEdit .project option');
    for(var i = 0 ; i<options.size();i++){
        var value = options[i].value;
        if(value == projectId){
            options[i].selected=true;
        }
    }
    /**职务岗位*/
    var jobId = json_userInfo.job;
    jobId = noId(jobId);
    options = $('#userInfoEdit .job option');
    for(var i = 0 ; i<options.size();i++){
        value = options[i].value;
        if(value == jobId){
            options[i].selected=true;
        }
    }
    /**专业技术*/
    var professionalSkillId = json_userInfo.professionalSkill;
    professionalSkillId = noId(professionalSkillId);
    options = $('#userInfoEdit .professionalSkill option');
    for(var i = 0 ; i<options.size();i++){
        value = options[i].value;
        if(value == professionalSkillId){
            options[i].selected=true;
        }
    }

    /**技术等级*/
    var skillLeverId = json_userInfo.skillLever;
    skillLeverId = noId(skillLeverId);
    options = $('#userInfoEdit .skillLever option');
    for(var i = 0 ; i<options.size();i++){
        value = options[i].value;
        if(value == skillLeverId){
            options[i].selected=true;
        }
    }

    /**在职状态*/
    var jobStateId = json_userInfo.jobState;
    jobStateId = noId(jobStateId);
    options = $('#userInfoEdit .jobState option');
    for(var i = 0 ; i<options.size();i++){
        value = options[i].value;
        if(value == jobStateId){
            options[i].selected=true;
        }
    }


    /**编辑之后提交*/
    $('#userInfoEditCommit').click(function(){
        var isoftNo = $('#userInfoEdit .isoftNo').text();
        var realName = $('#userInfoEdit .realName').val().trim();
        var project = $('#userInfoEdit .project').val().trim() ;
        var tel = $('#userInfoEdit .tel').val().trim();
        var wangwang = $('#userInfoEdit .wangwang').val().trim();
        var isoftEmail = $('#userInfoEdit .isoftEmail').val().trim();
        var aliId = $('#userInfoEdit .aliId').val().trim();
        var location = $('#userInfoEdit .location').val().trim();
        var aliEmail = $('#userInfoEdit .aliEmail').val().trim();
        var job = $('#userInfoEdit .job').val().trim();
        var professionalSkill = $('#userInfoEdit .professionalSkill').val().trim();
        var roleId = $('#userInfoEdit .roleId').val().trim();
        var skillLever = $('#userInfoEdit .skillLever').val().trim();
        var jobState = $('#userInfoEdit .jobState').val().trim();

        /**w未填项值为null*/
        realName = empityToNull(realName);
        project = empityToNull(project);
        tel = empityToNull(tel);
        wangwang = empityToNull(wangwang);
        isoftEmail = empityToNull(isoftEmail);
        aliId = empityToNull(aliId);
        location = empityToNull(location);
        aliEmail = empityToNull(aliEmail);
        job = empityToNull(job);
        professionalSkill = empityToNull(professionalSkill);
        roleId = empityToNull(roleId);
        skillLever = empityToNull(skillLever);
        jobState = empityToNull(jobState);

        /*console.log(realName+","+project+","+tel+","+wangwang+","+isoftEmail+","+isoftEmail+","+aliId+","+location+","+aliEmail+","+job+","+professionalSkill);*/
        if(!realName || !isoftEmail ){
            $('#userInfoEdit .warn').text("带*为必填项");
            return false;
        }
        //{"attendanceVoList":[{"description":"p","userId":1,"day":"sd"},{}]}
        var json ='{"realName":"'+realName+'","isoftNo":'+isoftNo+',"projectId":'+project+',"telephone":'+tel+',"wangwangNum":'+wangwang+',"isoftEmail":'+isoftEmail+',"wbNo":'+aliId+',"location":'+location+',"wbEmail":'+aliEmail+',"job":'+job+',"professionalSkill":'+professionalSkill+',"roleid":'+roleId+',"skillLever":'+skillLever+',"jobState":'+jobState+'}';
        /*console.log(json);*/
        /**向后台发起请求*/
        $.ajax({
            type:'POST',
            url:"editUserInfo.do",
            dataType: "json",
            contentType:"application/json",
            data:json,
            success:function(data){
                var msg = data.msg;
                $('#userInfoEdit .warn').text(msg);
            }
        });
        /*消除按钮刷新*/
        return false;
    });
});

/**select选项 value没有 默认1*/
function noId(num){
    if(num==0){
        num=1;
        return num;
    }
    return num;
};
/**未填项设为空*/
function empityToNull(data){
    if(!data){
        data =null;
        return data;
    }
    return data;
}
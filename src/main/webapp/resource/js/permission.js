var power;

$(function(){

    $("#id1").focus(function(){
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
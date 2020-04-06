

//更新密码
function updatePassWord(oldPassWord,newPassWord,validatePassWorld) {
    console.log("初始验证 oldPassWord="+oldPassWord+" newPassWorld=" +newPassWord+" validatePassWord="+validatePassWorld);
    var validate = validatePassword(newPassWord,validatePassWorld);
    if (validate == false)
        return ;
    var userId = getCookie("userId");
    console.log(userId);
    $.ajax({
        type:"post",
        url:"/updatePassWord",
        data:{
            "userId":userId,
            "oldPassWord":oldPassWord,
            "newPassWord":newPassWord
        },
        success:function (result) {
            console.log(result);
           alert(result);
           if (result=="修改密码成功")
               window.location.reload();
        }
    })
}

//验证两次输入的新密码是否相同
function validatePassword(newPassWord,validatePassWord) {
    if (newPassWord != ""&&validatePassWord!=""){
        if (newPassWord != validatePassWord) {
            $("#tip").html("两次输入的新密码不匹配*") ;
            $("#tip").attr('style','color:red;');
            return false;
        }
        else{
            $("#tip").html("√")  ;
            $("#tip").attr('style','color:green;');
            return true;
        }

    }
    else return false;
}
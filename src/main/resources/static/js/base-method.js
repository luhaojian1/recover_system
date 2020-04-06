//日期格式化  YY-MM-DD HH:mm:ss
function timestampToTime(timestamp) {
    var date = new Date(timestamp );//时间戳为10位需*1000，时间戳为13位的话不需乘1000
    var Y = date.getFullYear() + '-';
    var M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
    var D = (date.getDate()< 10 ? '0'+date.getDate(): date.getDate()) ;
    var H = ' ' + (date.getHours()+1 < 10 ? '0'+(date.getHours()) : date.getHours()) + ':';
    var m = (date.getMinutes() < 10 ? '0'+(date.getMinutes()) : date.getMinutes()) + ':';
    var s = (date.getSeconds() < 10 ? '0'+(date.getSeconds()) : date.getSeconds());
    return Y+M+D+H+m+s;
}
//日期格式化  YY-MM-DD
function timestampToDate(timestamp) {
    var date = new Date(timestamp );//时间戳为10位需*1000，时间戳为13位的话不需乘1000
    var Y = date.getFullYear() + '-';
    var M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
    var D = (date.getDate()< 10 ? '0'+date.getDate(): date.getDate()) ;
    return Y+M+D;
}

//判断就诊状态
function judgeVisStatus(visStatus) {
    if (visStatus == 1)
        return "待诊";
    else if (visStatus == 2)
        return "过号";
    else if (visStatus == 3)
        return "已就诊";
    else if (visStatus == 4)
        return "退号";
}


//跳转到个人中心时标记当前用户主页
function setPersonalHomePage(href){
    console.log(href);
    setCookie("href",href);

}

//设置cookie
function setCookie(cname,cvalue,exdays)
{
    var d = new Date();
    d.setTime(d.getTime()+(exdays*24*60*60*1000));
    var expires = "expires="+d.toGMTString();
    document.cookie = cname + "=" + cvalue + "; " + expires;
}

//获取cookie
function getCookie(cname)
{
    var name = cname + "=";
    var ca = document.cookie.split(';');
    for(var i=0; i<ca.length; i++)
    {
        var c = ca[i].trim();
        if (c.indexOf(name)==0) return c.substring(name.length,c.length);
    }
    return "";
}

//设置提示
function setTip(tip) {
    $("#tip").text(data);
    $("#tip_modal").modal();
}
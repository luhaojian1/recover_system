
//找到指定的患者信息
function findAppointedPatient(formId,pageNum) {

    $.ajax({
        type:"get",
        url:'/findAppointedPatient/pageNum='+pageNum,
        data:$(formId).serialize(),
        dataType:"json",
        success:function (map) {
            console.log(map.patients);
            var tbody = "";                                           //
            $("#patient_partial_list").html("");
            $("#paginationList").html("");
            $.each(map.patients,function (i,patient) {
                var sex= patient.sex==true?"男":"女";
                tbody += '<tr id='+'"'+patient.patientId+'"'+'><td>'+ patient.patientId +'</td><td>'+ patient.patientName +'</td><td>'+sex
                    +'</td><td>'+ patient.age +'</td><td>'+ patient.nation+'</td><td>'+ patient.nativePlace
                    +'</td><td>'+ patient.homeAdress+'</td><td>'+ patient.carId+'</td><td>'+ patient.phoneNumber
                    +'</td><td><a href="#update_patient" role="button" class="btn btn-warning"  ' +
                    'onclick="searchPatient('+patient.patientId+')">详细信息</a>' +
                    '<a href="#delete_model" role="button" class="btn btn-danger" data-toggle="modal"'
                    +'onclick="assignmentDeleteModel('+patient.patientId+')">删除</a></td></tr>';
            });
            var pageBody = pagination();
            $("#paginationList").append(pageBody);
            $(formId).append(tbody);

        },
        error:function () {
            alert("找不到该患者的信息");
        }
    })
}

//
function searchPatient(patientId) {
    console.log(patientId);

    $.ajax({
        type:"get",
        url:"/searchAppointedPatient",
        data:{"patientId":patientId},
        dataType:"json",
        success:function (patient) {
            console.log(patient);
            if (patient != null){
                $("#updatePatientId").val(patient.patientId);
                $("#updatePatientName").val(patient.patientName);
                var sex = patient.sex;
                var updateSex = document.getElementById("updateSex");
                if(sex == true)
                    updateSex.options[1].selected=true;
                else updateSex.options[2].selected=true;

                $("#updateAge").val(patient.age);

                var updateNation = document.getElementById("updateNation");
                var nation = patient.nation;
                for(var i=0;i<updateNation.options.length;i++){
                    if(updateNation.options[i].value==nation)
                        updateNation.options[i].selected=true;
                }
                var array = patient.nativePlace.split(",");
                console.log(array[0]+" "+array[1]);
                var province = document.getElementById("province");
                var city = document.getElementById("updateCity");
                for(var i=0;i<province.options.length;i++){
                    if(province.options[i].value==array[0])
                        province.options[i].selected=true;
                    chinaChange(province,city);
                }
                for(var i=0;i<city.options.length;i++){
                    //console.log(city.options[i].value+" "+array[1]);
                    if(city.options[i].value==patient.nativePlace)
                        city.options[i].selected=true;
                }

                $("#updateHomeAdress").val(patient.homeAdress);
                $("#updateCardId").val(patient.carId);
                $("#updatePhone").val(patient.phoneNumber);
                var date =timestampToTime(patient.mpBirthday);
                $("#updateBirthday").val(date);
                $("#updateOccupation").val(patient.occupation);
                $("#updateWorkPlace").val(patient.workPlace);
                $("#updateBloodType").val(patient.bloodType); //血型
                $("#updateFamSickHistroy").val(patient.famSickHistroy); //是否存在家族病史
                var famSickHistroy = patient.famSickHistroy;
                var updateFamSickHistroy = document.getElementById("updateFamSickHistroy");
                if ( famSickHistroy == true){
                    updateFamSickHistroy.options[0].selected = true;
                    $("#updateSickHistrionicInstruction").val(patient.sickHistrionicInstruction); //家族病史说明
                }
                else{
                    updateFamSickHistroy.options[1].selected = true;
                    $("#updateSickHistrionicInstruction").attr("type","hidden");
                }
                var drugAllergy = patient.drugAllergy;
                var updateDrugAllergy = document.getElementById("updateDrugAllergy"); //是否药物过敏
                if (drugAllergy == true){
                    updateDrugAllergy.options[0].selected = true;
                    $("#updateDrugAllergyIntroduction").val(patient.drugAllergyIntroduction); //药物过敏说明
                }
                else{
                    updateDrugAllergy.options[1].selected = true;
                    $("#updateDrugAllergyIntroduction").attr("type","hidden");
                    document.getElementById("whetherDrugAllergy").style.display = "block";
                }



                $("#update_patient").modal();
            }
        },
        error:function () {
            alert("找不到该patient");
        }
    })
}
//日期格式化 yy-mm-dd
function timestampToTime(timestamp) {
    var date = new Date(timestamp );//时间戳为10位需*1000，时间戳为13位的话不需乘1000
    var Y = date.getFullYear() + '-';
    var M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
    var D = (date.getDate()+1 < 10 ? '0'+(date.getDate()+1) : date.getDate()+1) ;
    return Y+M+D;
}
//更新患者信息
function updatePatient(formId) {
    var form = "#"+formId;
    $.ajax({
        type:"post",
        url:"/updatePatient",
        data:$(form).serialize(),
        dataType:"json",
        success:function (patient) {
            console.log(patient);
            if (patient != null )
            {
                var cells = document.getElementById(patient.patientId).cells;
                console.log(cells);
                cells[0].innerHTML = ''+patient.patientId;
                cells[1].innerHtml = patient.patientName;
                cells[2].innerHTML = patient.sex == true?"男":"女";
                cells[3].innerHTML = patient.age;
                cells[4].innerHTML = patient.nation;
                cells[5].innerHTML = patient.nativePlace;
                cells[6].innerHTML = patient.homeAdress;
                cells[7].innerHTML = patient.carId;
                cells[8].innerHTML = patient.phoneNumber;
                cells[9].innerHTML = '<a href="#update_patient" role="button" class="btn btn-warning"  ' +
                    'onclick="searchPatient('+patient.patientId+')">详细信息</a>'+
                    '<a href="#delete_model" role="button" class="btn btn-danger" data-toggle="modal"'
                    +'onclick="assignmentDeleteModel('+patient.patientId+')">删除</a>';
                alert("修改成功");
            }
            else alert("修改失败，请检查数据格式是否正确");
        },
        error:function () {
            alert("修改失败，请检查数据格式是否正确");
        }

    })
}

//在删除模块中设置患者ID
function assignmentDeleteModel(patientId) {
    $("#deletePatientId").val(patientId);
}

//删除病人信息
function deletePatient() {
    var deleteatientId = $("#deletePatientId").val();
    $.ajax({
        type: "post",
        url: "/deletePatient",
        data: {"patientId": deleteatientId},
        dataType: "json",
        success: function (patient) {
            console.log(patient);
            document.getElementById(deleteatientId).remove();
            alert("删除成功");

        },
        error: function () {
            return;
        }
    })
}

//验证身份证号码是否重复
function checkCardId(carId,lableId) {
    var id = carId ;
    var lable = "#"+lableId;
    var year = id.substring(6,10);
    var month = id.substring(10,12);
    var day = id.substring(12,14);
    var birthday=year+"-"+month+"-"+day;
    $("#mpBirthday").val(birthday);

    if (id.length !== 0){
        var reg = /^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$|^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}([0-9]|X)$/;
        var r = id.match(reg);
        if (r === null) {
            $(lable).html("身份证格式不正确");
            $(lable).attr('style','color:red;');
            return ;
        }
    }else{
        $(lable).html("");
        return ;
    }
    $.ajax({
        type:"get" ,
        url:"/searchPatientCarId",
        data:{"carId":id},
        dataType:"json",
        success: function (data) {
            console.log(data);
            if (data!=null){
                $(lable).html("该身份证已被使用");
                $(lable).attr('style','color:red;');
            }
        },
        error:function (data) {

            $(lable).html("√");
            $(lable).attr('style','color:green;');


        }

    })
}

//验证电话号码格式是否正确
function checkphoneNumber(phoneNumber,lableId) {
    var id = phoneNumber ;
    var lable = "#"+lableId;
    if (id.length !== 0){
        var reg = /(\d{11})|^((\d{7,8})|(\d{4}|\d{3})-(\d{7,8})|(\d{4}|\d{3})-(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1})|(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1}))$/;
        var r = id.match(reg);
        if (r === null) {
            $(lable).html("联系格式不正确");
            $(lable).attr('style','color:red;');
            return ;
        }
    }else{
        $(lable).html("√");
        return ;
    }

}




var china=new Object();
china['北京市']=['北京市区','北京市辖区'];
china['上海市']=['上海市区','上海市辖区'];
china['天津市']=['天津市区','天津市辖区'];
china['重庆市']=['重庆市区','重庆市辖区'];
china['河北省'] = ['石家庄', '唐山市', '邯郸市', '秦皇市岛', '保市定', '张家市口', '承德市', '廊坊市', '沧州市', '衡水市', '邢台市'];
china['山西省']=['太原市','大同市','阳泉市','长治市','晋城市','朔州市','晋中市','运城市','忻州市','临汾市','吕梁市'];
china['辽宁省']=['沈阳市','大连市','鞍山市','抚顺市','本溪市','丹东市','锦州市','营口市','阜新市','辽阳市','盘锦市','铁岭市','朝阳市','葫芦岛市'];
china['吉林省']=['长春市','吉林市','四平市','辽源市','通化市','白山市','松原市','白城市','延边州','长白山管委会'];
china['黑龙江省']=['哈尔滨市','齐齐哈尔市','大庆市','佳木斯市','牡丹江市','七台河市','双鸭山市','黑河市','鸡西市','伊春市','绥化市','鹤岗市','加格达奇市'];
china['江苏省']=['南京市','苏州市','无锡市','常州市','南通市','扬州市','镇江市','泰州市','盐城市','连云港市','宿迁市','淮安市','徐州市'];
china['浙江省']=['杭州市','宁波市','温州市','嘉兴市','湖州市','绍兴市','金华市','衢州市','舟山市','台州市','丽水市'];
china['安徽省']=['合肥市','芜湖市','蚌埠市','淮南市','马鞍山市','淮北市','铜陵市','安庆市','黄山市','滁州市','阜阳市','宿州市','巢湖市','六安市','亳州市','池州市','宣城市'];
china['福建省']=['福州市','厦门市','莆田市','三明市','泉州市','漳州市','南平市','龙岩市','宁德市'];
china['江西省']=['南昌市','景德镇市','萍乡市','九江市','新余市','鹰潭市','赣州市','吉安市','宜春市','抚州市','上饶市'];
china['山东省']=['济南市','青岛市','淄博市','枣庄市','东营市','烟台市','潍坊市','济宁市','泰安市','威海市','日照市','莱芜市','临沂市','德州市','聊城市','滨州市','菏泽市'];
china['河南省']=['郑州市','开封市','洛阳市','平顶山市','安阳市','鹤壁市','新乡市','焦作市','濮阳市','许昌市','漯河市','三门峡市','南阳市','商丘市','信阳市','周口市','驻马店市'];
china['湖北省']=['武汉市','黄石市','十堰市','荆州市','宜昌市','襄樊市','鄂州市','荆门市','孝感市','黄冈市','咸宁市','随州市'];
china['湖南省']=['长沙市','株洲市','湘潭市','衡阳市','邵阳市','岳阳市','常德市','张家界市','益阳市','郴州市','永州市','怀化市','娄底市'];
china['广东省']=['广州市','深圳市','珠海市','汕头市','韶关市','佛山市','江门市','湛江市','茂名市','肇庆市','惠州市','梅州市','汕尾市','河源市','阳江市','清远市','东莞市','中山市','潮州市','揭阳市','云浮市'];
china['海南省']=['文昌市','琼海市','万宁市','五指山市','东方市','儋州市'];
china['四川省 ']=['成都市','自贡市','攀枝花市','泸州市','德阳市','绵阳市','广元市','遂宁市','内江市','乐山市','南充市','眉山市','宜宾市','广安市','达州市','雅安市','巴中市','资阳市'];
china['贵州省']=['贵阳市','六盘水市','遵义市','安顺市'];
china['云南省']=['昆明市','曲靖市','玉溪市','保山市','昭通市','丽江市','普洱市','临沧市'];
china['陕西省']=['西安市','铜川市','宝鸡市','咸阳市','渭南市','延安市','汉中市','榆林市','安康市','商洛市'];
china['甘肃省']=['兰州市','金昌市','白银市','天水市','嘉峪关市','武威市','张掖市','平凉市','酒泉市','庆阳市','定西市','陇南市'];
china['青海省']=['西宁市'];
china['台湾省'] = ['台北市','高雄市','基隆市','台中市','台南市','新竹市','嘉义市'];
china['广西壮族自治区']=['南宁市','柳州市','桂林市','梧州市','北海市','防城港市','钦州市','贵港市','玉林市','百色市','贺州市','河池市','来宾市','崇左市'];
china['内蒙古自治区']=['呼和浩特市','包头市','乌海市','赤峰市','通辽市','鄂尔多斯市','呼伦贝尔市','巴彦淖尔市','乌兰察布市'];
china['西藏自治区']=["拉萨市"];
china['宁夏回族自治区']=['银川市','石嘴山市','吴忠市','固原市','中卫市'];
china['新疆维吾尔自治区']=['乌鲁木齐市','克拉玛依市'];
china['香港特别行政区']=['台北市','高雄市','基隆市','台中市','台南市','新竹市','嘉义市'];


//改变城市
function chinaChange(province, city) {
    var pv, cv;
    var i, ii;
    pv = province.value;
    cv = city.value;
    city.length = 1;
    if (pv == '0') return;
    if (typeof (china[pv]) == 'undefined') return;


    for (i = 0; i < china[pv].length; i++) {
        ii = i + 1;

        city.options[ii] = new Option();
        city.options[ii].text = china[pv][i];
        city.options[ii].value = pv+","+china[pv][i];
    }
    city.options[0].text = "请选择市区";

};



function change(flag,id) {
    if("false" === flag)
        $("#"+id).attr('type','hidden');
    else $("#"+id).attr('type','text');
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

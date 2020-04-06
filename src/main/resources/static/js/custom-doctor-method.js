


//寻找待诊患者队列
function findRegisterByDoctorId(doctorId,visStatus) {
    console.log(doctorId);
    if (doctorId == null){
        alert("doctorId is null");
        return ;
    }
    $.ajax({
        type:"get",
        url:"/findRegistersByDoctorId",
        data:{"doctorId":doctorId,
            "visStatus":visStatus
        },
        dataType:"json",
        success:function (map) {
            console.log(map.registers);
            $("#show_register_info").html("");
            var tbody = "";

            $.each(map.registers,function (i,register) {
                var visStatus = judgeVisStatus(register.visStatus);
                var date = timestampToTime(register.registerDate);
                tbody +='<tr id='+'"'+register.registerId+'"'+'><td>'+ register.registerId +'</td><td>'+ register.patientId
                    +'</td><td>'+ register.patientName +'</td><td>'+register.doctor.userName+'</td><td>'+register.doctor.officeId
                    +'</td><td>'+ visStatus +'</td><td>'+ date
                    +'</td><td> <button  class=" btn btn-primary" data-dismiss="modal" '  +
                    'onclick=setRegisterInfo('+"'"+register.registerId+"'"+')>确定</button></td></tr>';
            });
            $("#show_register_info").append(tbody);
            $("#waiting_sequence").modal();
        },
        error:function () {
            alert("咱无患者挂号");
            return ;
        }
    })
}

//设置就诊患者信息
function setRegisterInfo(registerId) {
    console.log(registerId);
    $.ajax({
        type:"get",
        url:"/findRegistersById",
        data:{"registerId":registerId},
        dataType:"json",
        success:function (register) {
            console.log(register);
            console.log(register.patient.sex);
            $("#registerId").val(register.registerId);
            $("#patient").val(register.patient.patientId);
            $("#patientId").val(register.patient.patientId);
            $("#patientName").val(register.patientName);
            var sex = register.patient.sex==true?"男":"女";
            console.log(sex);
            $("#sex").val(sex);
            //$("#diagnosisNo").val(register.diagnosisNo);
            var visStatus = document.getElementById("visStatus");
            for(var i=0;i<visStatus.options.length;i++){
                if(visStatus.options[i].value == register.visStatus)
                    visStatus.options[i].selected = true;
            }
            // findDoctor(register.doctor.userName);

        },
        error:function () {
            alert("出现了一点意外，请重新点击");
        }
    })
}

//查找药物信息
function finddrug(drugCategroy,drugInfo) {
    console.log("drugCategroy="+drugCategroy+" drugInfo="+drugInfo);
    $.ajax({
        type:"get",
        url:"/findDrugList",
        data:{"drugCategroy":drugCategroy,
            "drugInfo":drugInfo },
        dataType:"json",
        success:function (map) {
            console.log(map.drugs);
            $("#show_drug_info").html("");
            var tbody = "";
            $.each(map.drugs,function (i,drug) {

                tbody +=  '<tr id='+'"'+drug.drugId+'"'+'><td>'+ drug.drugId +'</td><td>'+ drug.drugName
                    +'</td><td>'+ drug.drugProperties +'</td><td>'+drug.function+'</td><td>'+ drug.dosage
                    +'</td><td>'+ drug.attention +'</td><td>'+ drug.specifications
                    +'</td><td> <button  class=" btn btn-primary" data-dismiss="modal" '  +
                    'onclick=setdrugListInfo('+"'"+ drug.drugId +"'"+')>确定</button></td></tr>';
                /*  */
            });
            $("#show_drug_info").append(tbody);
            $("#drug_list").modal();
        }
    })


}
//设置药单信息
function setdrugListInfo(drugId) {
    if ($('#drug'+drugId).length>0){
       alert("该药已存在治疗单上");
        return ;
    }
    $.ajax({
        type:"get",
        url:"/findDrugById",
        data:{"drugId":drugId},
        dataType:"json",
        success:function (drug) {
            console.log(drug);
            var dosage = setDosage(drug.drugId,drug.unitPrice);
            var tbody = '<tr id='+'"drug'+drug.drugId+'"'+'><td>'+ drug.drugId +'</td><td>'+ drug.drugName
                +'</td><td>'+ dosage +'</td><td>'+ drug.dosage
                +  '<input style="width: 70px;" type="hidden" name="sumPrice"  value='+drug.unitPrice+'  id='+'"price'+drug.drugId+'"'+'>'
                + '</td><td> <button  class=" btn btn-danger"  '  +
                'onclick=deleteList('+"'drug"+ drug.drugId +"'"+')>×</button></td></tr>';
            $("#drugList_info").append(tbody);

        },
        error:function () {
            alert("出现了一点意外，请重新点击");
        }
    })
}
//查找康复器材信息
function findEquipment(equipmentCategory,equipmentInfo) {
    console.log("equipmentCategory = "+equipmentCategory+" equipmentInfo = "+equipmentInfo);
    $.ajax({
        type:"get",
        url:"/findEquipmentList",
        data:{"equipmentCategory":equipmentCategory,
            "equipmentInfo":equipmentInfo },
        dataType:"json",
        success:function (map) {
            console.log(map.resList);
            $("#show_equipment_info").html("");
            var tbody = "";
            $.each(map.resList ,function (i,equipment) {

                tbody +=  '<tr id='+'"'+equipment.rm_id+'"'+'><td>'+ equipment.rm_id +'</td><td>'+ equipment.rm_name
                    +'</td><td>'+ equipment.office.officeId +'</td><td>'+equipment.rm_specifications+'</td><td>'+ equipment.rm_classification
                    +'</td><td>'+ equipment.rm_function
                    +'</td><td> <button  class=" btn btn-primary" data-dismiss="modal" '  +
                    'onclick=setEquipmentInfo('+"'"+ equipment.rm_id +"'"+')>确定</button></td></tr>';
                /*  */
            });
            $("#show_equipment_info").append(tbody);
            $("#recoverEquipment_list").modal();
        },
        error:function () {
            return ;
        }
    })


}
//设置器材列表清单
function  setEquipmentInfo(rmId) {
    console.log(rmId);
    if ($('#rmList'+rmId).length>0){
        alert("该器材已存在治疗单上");
        return ;
    }
    $.ajax({
        type:"get",
        url:"/findRecoverEquipmentById",
        data:{"rm_Id":rmId },
        dataType:"json",
        success:function (equipment) {
            console.log(equipment);
            var tbody = "";
            var equipmentDosage = setEquipmentDosage(equipment.rm_id,equipment.hourUnitPrice);

            tbody +=  '<tr id='+'"rmList'+equipment.rm_id+'"'+'><td>'+ equipment.rm_id +'</td><td>'+ equipment.rm_name
                +'</td><td>'+ equipmentDosage
                +'<input style="width: 70px;" type="hidden" name="usePrice" value='+equipment.hourUnitPrice+' id='+'"price'+equipment.rm_id+'"'+'>'
                +'</td><td> <button  class=" btn btn-danger"  '  +
                'onclick=deleteList('+"'rmList"+ equipment.rm_id +"'"+')>×</button></td></tr>';
            $("#euqipemntList_info").append(tbody);

        },
        error:function () {
            return ;
        }
    })



}

//删除治疗清单列表信息
function deleteList(id) {
    console.log(id);
    $("#"+id).remove();
}


//设置疾病等级
function clickSickClassification(value) {
    console.log(value);
    var options = '<option >请选择</option>';
    if (value == "精神病"){
        for(var i=1;i<5;i++){
            options +='<option value="' +  i+ '" >精神残疾' + i+ '级</option>';
        }
    }
    else{
        for(var i=1;i<5;i++){
            options +='<option value="' +  i+ '" >身体残疾' + i+ '级</option>';
        }
    }
    $("#sickLevel").html("");
    $("#sickLevel").append(options);
}

//设置用药天数
function setDosage(id,price) {
    console.log(id+" "+price);
    var drugDosage =
        '<select id="dosage'+id+'"  name="dosage" style="width: 80px;" onchange="setPrice(this.value,'+"'"+id+"'"+','+"'"+price+"'"+')">\n' +
        '<option value="1">1天</option>\n' +
        '<option value="2">2天</option>\n' +
        '<option value="3">3天</option>\n' +
        '<option value="4">4天</option>\n' +
        '<option value="5">5天</option>\n' +
        '<option value="6">6天</option>\n' +
        '<option value="7">1周</option>' ;

    return drugDosage;
}

//器材使用次数
function setEquipmentDosage(id,price) {
    console.log(id+" "+price);
    var drugDosage = '<select id="dosage'+id+'"  name="dosage" style="width: 80px;" onchange="setEquipmentlistPrice(this.value,'+"'"+id+"'"+','+"'"+price+"'"+')">\n';
    for (var i=1;i<=30;i++){
        drugDosage += '<option value='+i+'>'+i+'</option>\n' ;
    }
    drugDosage += '</select>次';
    return drugDosage;
}


//设置药品价格
function setPrice(dosage,id,price) {
    console.log(dosage+" "+id+" "+price);
    var sumPrice = dosage*price;
    $("#price"+id).val(sumPrice);
}
//设置康复器材价格
function setEquipmentlistPrice(dosage,id,price) {
    console.log(dosage+" "+id+" "+price);
    var sumPrice = dosage*price;
    $("#price"+id).val(sumPrice);
}

//获取药物列表清单
function getDrugTbodyArray(id,diagnosis) {
    var result = false;
    var tbodyhtml = document.getElementById(id);
    var rows = tbodyhtml.rows;
    var arr = [];
    for(var i=0;i<rows.length;i++){
        var druglist = {};
        var cells = rows[i].cells;
        druglist.drugId =cells[0].innerHTML;
        druglist.diagnosisId = diagnosis;
        druglist.drugDosage = $("#dosage"+druglist.drugId).val();
        druglist.drugPrice = $("#price"+druglist.drugId).val();
        druglist.drugListDate = new Date();
        arr.push(druglist);
    }
    console.log(arr);
    $.ajax({
        type:"post",
        url:"/addDruglist",
        contentType: "application/json;charset=UTF-8",
        data:JSON.stringify(arr),
        success:function (data) {
           result = data;

        },
        error:function () {
            alert("药物治疗蛋保存失败");
            return false;
        }
    });
    return result;
}

//获取康复器材列表清单
function getEquipmentTbodyArray(id,diagnosisId) {
    var tbodyhtml = document.getElementById(id);
    var rows = tbodyhtml.rows;
    var arr = [];
    for(var i=0;i<rows.length;i++){
        var equipmentlist = {};
        var cells = rows[i].cells;
        equipmentlist.rm_id =cells[0].innerHTML;
        equipmentlist.userId = $("#doctorId").val();
        equipmentlist.diagnosisId = diagnosisId;
        equipmentlist.useTimes = $("#dosage"+equipmentlist.rm_id).val();
        equipmentlist.usePrice = $("#price"+equipmentlist.rm_id).val();
        equipmentlist.equipmentListDate = new Date();
        arr.push(equipmentlist);
    }
    console.log(arr);
    $.ajax({
        type:"post",
        url:"/addEquipmentlist",
        contentType: "application/json;charset=UTF-8",
        data:JSON.stringify(arr),
        success:function (data) {
            console.log(data);
        },
        error:function () {
            alert("康复器材清单保存失败");
        }
    });
}



//设置诊断记录
function setDiagnosis() {
    var diagnosis = {};
    diagnosis.registerId = $("#registerId").val();
    diagnosis.patientId = $("#patientId").val();
    diagnosis.doctorId = $("#doctorId").val();
    diagnosis.sickClassification = $("#sickClassification").val();
    diagnosis.sickLevel = $("#sickLevel").val();
    diagnosis.chiefComplaint = $("#chiefComplaint").val();
    diagnosis.recoverPlan = $("#recoverPlan").val();
    diagnosis.diagnosisResult = $("#diagnosisResult").val();
    diagnosis.diagnosisDate = new Date();

    if (diagnosis.patientId == null || diagnosis.patientId == "")
    {
        alert("没有患者信息，无法提交");
        return ;
    }
    console.log(diagnosis);
    if (diagnosis == null)
        alert("diagnosis 为空");
    $.ajax({
        type:"post",
        url:"/addDiagnosis",
        contentType: "application/json;charset=UTF-8",
        data:JSON.stringify(diagnosis),
        success:function (data) {
            console.log(data);
            if($("#euqipemntList_info").children().length>0){
                getEquipmentTbodyArray("euqipemntList_info",data);
            }
           if($("#drugList_info").children().length>0){
              getDrugTbodyArray("drugList_info",data);
           }
           alert("提交成功");
            window.location.reload();

        },
        error:function () {
            alert("提交失败，请检查！");
        }
    })

}



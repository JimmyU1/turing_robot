/**
 * Created by Jimmy on 2017/6/2.
 */
var content = "请开始你的表演.\n\n";
var user = "佳肥猫";
var robot = "小螃蟹";
var msg = "11";
$(function () {
    $(document).keydown(function(event){
        if(event.keyCode == 13){
            $("#btn").click();
        }
    });

    function setEmpty(id) {
        $("#"+id).textbox('setValue','');
    }

    $("#btn").bind('click',function () {
        var message = $("#msg").val();
        addInfo();
        sendMessage(message);
        setEmpty("msg");
    });

    function addInfo(){
        msg = $("#msg").val();
        var info = "<p class='info-title'>" + user + "\t"+ new Date() +  "</p>" + "<p class='info'>" + msg + "</p> ";
        $("#content").append(info);

    }

    function addText(text, host) {
        var content = "<p class='text-title'>" + robot + "\t"+ new Date() + "\t" + "IP:" + host + "</p>" + "<p class='text'>" + text + "</p> ";
        $("#content").append(content);
    }


    function sendMessage(message) {
        $.ajax({
            url: "/robot/talk",
            type: "get",
            data: {
                "info":message
            },
            dataType:"json",
            async: false,
            success: function (data) {
                var text = data.text;
                var host = data.host;
                addText(text, host);
            },
            error: function () {
                $.messager.alert("Error",'There is a problem about sending message.');
            }
        });
    }
});






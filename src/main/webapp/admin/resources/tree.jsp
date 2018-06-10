<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript">

    var title = [[
        {title: '名称', field: 'title', width: 180},
        {field: 'size', title: '大小', width: 60, align: 'right'},
        {field: 'duration', title: '时长', width: 80},
        {field: 'downPath', title: '路径', width: 80}
    ]];

    // =============================加属性=================================
    var onClick = function () {

    }
    var toolbar = [{
        text: '专辑详情',
        iconCls: 'icon-lightbulb',
        handler: function () {
            var row = $('#tt').treegrid("getSelected");
            if (row == null) {
                alert("请先选择");
                return;
            }

            if (row.size == null) {
                $('#dd').dialog({closed: false,});
                $("#img").prop("src",row.picPath)
                $("#album").text(row.title)
                $("#author").text(row.author)
                $("#number").text(row.number)
                $("#announcer").text(row.announcer)


            } else {
                alert("请选择一个专辑");
            }
        }
    }, {
        text: '添加专辑',
        iconCls: 'icon-cdr_add',
        handler: function () {//=========添加专辑=====================================
            $('#addAlbum').dialog({closed: false,});

        }
    }, {
        text: '添加章节',
        iconCls: 'icon-script_add',
        handler: function () {
            $('#addAudio').dialog({closed: false,});
        }
    }, {
        text: '下载音频',//========================================下载音频按钮===================================
        iconCls: 'icon-download',
        handler: function () {
            var row = $('#tt').treegrid("getSelected");
            if (row == null) {
                alert("请先选择");
                return;
            }

            if (row.size == null) {
                alert("请选择一个音频");
                return;
            }
            var id=row.id;

            window.location.href="/tree/upload?id="+id;

        }
    }];

// ==================================all======================================
    $('#tt').treegrid({
        onClickRow: onClick,
        fitColumns: true,
        url: '/tree/showAlbum',
        idField: 'id',
        treeField: 'title',
        columns: title,
        toolbar: toolbar,
        onDblClickRow:function(){
            var row = $('#tt').treegrid("getSelected");
            if (!(row.size == null)) {
                $('#play').dialog({
                    closed:false,
                });
                $("#resources").prop("src",row.downPath);
            }
        }


    });

//========================添加专辑、音频 、专辑详情弹窗==============================================================
    var buttons=[{
        text:'提交',
        handler:function(){
            $('#formAlbum').submit();
            $('#addAlbum').dialog({ closed: true});
        }
    },{
        text:'取消',
        handler:function(){
            $('#addAlbum').dialog({ closed: true});
        }
    }];


    $('#dd').dialog({
        title: '专辑详情',
        width: 400,
        height: 250,
        closed: true,
        cache: false,
        modal: true
    });



    var buttons2=[{
        text:'提交',
        handler:function(){
            $('#formAudio').submit();
            $('#addAudio').dialog({ closed: true});
        }
    },{
        text:'取消',
        handler:function(){
            $('#addAudio').dialog({ closed: true});
        }
    }];



    $('#addAlbum').dialog({
        title: '添加专辑',
        width: 400,
        height: 300,
        closed: true,
        cache: false,
        modal: true,
        buttons:buttons,

    });

    $('#addAudio').dialog({
        title: '添加音频',
        width: 400,
        height: 150,
        closed: true,
        cache: false,
        modal: true,
        buttons:buttons2,
    });
    //播放
    $('#play').dialog({
        title: '播放',
        width: 400,
        height: 150,
        closed: true,
        cache: false,
        modal: true,
    });


    // =============================添加专辑弹窗  end==============================================================


    // =============================给表单美化，添加功能(上传专辑，音频表单) start==============================================================
    $('#formAlbum').form({
        closed:true,
        url: '/tree/addAlbum',
        success: function (data) {
            alert("专辑添加成功")
            $('#dd').dialog({ closed: true});
        }
    });
    //格式化标题框
    $("#albumName").textbox({
        prompt: "专辑名",
        required: true,
        width:150,
    });
    //格式化描述框
    $("#albumAuthor").textbox({
        prompt: "作者",
        required: true,
        width:150,

    });
    $("#albumAnnouncer").textbox({
        prompt: "播音",
        required: true,
        width:150,

    });
    $("#albumMs").textbox({
        prompt: "描述",
        width:150,
    });
    //文件筐
    $("#albumImg").filebox({
        prompt: "请选择图片",
        required: true,
        width:150,
    });



    $('#formAudio').form({
        closed:true,
        url: '/tree/keepAudio',
        success: function (data) {
            alert("音频添加成功")
            $('#dd').dialog({ closed: true});
        }
    });



    $('#albumId').combobox({
        url:"/tree/getComboboxData",
        valueField:'id',
        textField:'text',
        width:150,
    });

    //文件筐
    $("#audioFile").filebox({
        prompt: "请选择音频",
        required: true,
        width:150,
    });

    // =============================给表单美化，添加功能(上传专辑，音频表单)   end==============================================================


</script>
<style type="text/css">
    .align{
        margin-left: 30%;
    }
</style>
<table id="tt" style="width:600px;height:400px"></table>

<div id="dd">
    <img id="img" class="align"></br></br>
    <div id="message" class="align">
        专辑名：<span id="album"></span></br></br>
        作者：<apan id="author"></apan></br></br>
        集数：<span id="number"></span></br></br>
        播音：<span id="announcer"></span></br></br>
    </div>
</div>

<%--=============================================================================--%>




<%--===================================专辑提交表单 start==========================================--%>
<div id="addAlbum">
    <form id="formAlbum" method="post" enctype="multipart/form-data">
        <div id="big">
        </br></br>
            <div>
                <label for="albumName">专辑名:</label>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input id="albumName" name="albumName"/>
            </div>
            </br>
            <div>
                <label for="albumAuthor">作者:</label>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input id="albumAuthor" name="albumAuthor "/>
            </div>
            </br>
            <div>
                <label for="albumAnnouncer">播音:</label>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input id="albumAnnouncer" name="albumAnnouncer "/>
            </div>
            </br>


            <div>
                <label for="albumMs">介绍:</label>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input id="albumMs" name="albumMs"/>
            </div>
            </br>
            <div>
                <label for="albumImg">选择文件:</label>
                &nbsp;&nbsp;<input id="albumImg" name="albumImg"/>
            </div>

        </div>

    </form>
</div>
<%--===================================专辑提交表单 end==========================================--%>


<%--===================================添加音频 start==========================================--%>
<div id="addAudio">
    <form id="formAudio" method="post" enctype="multipart/form-data">
        <div id="big1">
            </br>
            <div>
                <label for="albumId">选择专辑</label>
                &nbsp;&nbsp;<input id="albumId" name="albumId"/>
            </div>

            </br>
            <div>
                <label for="audioFile">选择文件:</label>
                &nbsp;&nbsp;<input id="audioFile" name="audioFile"/>
            </div>

        </div>

    </form>
</div>


<div id="play">
    <audio controls id="resources">
        <source src="horse.mp3" type="audio/mpeg">
        您的浏览器不支持 audio 元素。
    </audio>

</div>
<%--===================================专辑音频 end==========================================--%>


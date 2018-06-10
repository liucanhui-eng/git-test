<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<script type="text/javascript">
    // =========================================组件==================================================
    var clums = [[
        {field: 'tel', title: '手机', width: 100},
        {field: 'dharmaName', title: '法号', width: 100},
        {field: 'name', title: '姓名', width: 100},
        {field: 'sex', title: '性别', width: 100},
        {field: 'province', title: '省份', width: 100},
        {field: 'sign', title: '城市', width: 100},
        {field: 'status', title: '状态', width: 100},
        {field: 'date', title: '注册时间', width: 100, align: 'right'}
    ]];

    var toolbar = [{
        text: '导出用户信息',
        iconCls: 'icon-edit',
        handler: function () {
            $('#dd').dialog({
                closed: false,
            });
        }
    }, {
        text: '导入用户信息',
        iconCls: 'icon-help',
        handler: function () {
            $('#uploadDiv').dialog({closed:false});
        }
    }];

    //导出的buttons
    var buttons=[{
        text:'确认导出',
        handler:function(){
            $("#ff").form("submit", {
                onSubmit: function (param) {
                    param.text =$('#cc').combotree('getText');
                },
            });
            $('#dd').dialog({
                closed:true,
            });
        }
    },{
        text:'关闭',
        handler:function(){
            $('#dd').dialog({
               closed:true,
            });
        }
    }];


    //导入的buttons
    var buttons2=[{
        text:'确认导入',
        handler:function(){
            $("#uploadForm").submit();
            $('#uploadDiv').dialog({
                closed:true,
            });
        }
    },{
        text:'关闭',
        handler:function(){
            $('#dd').dialog({
                closed:true,
            });
        }
    }];





    // ===========================================================================================

//分页
    $(function () {
        $('#dg').datagrid({
            title: '查看用户详细信息',
            pagination: true,
            pageList: [10, 20, 30],
            pageSize: 10,
            url: '/user/queryUserByPage',
            toolbar: toolbar,
            columns: clums,
        });
    })


//导出用户信息
    $('#dd').dialog({
        title: '导出用户信息',
        width: 400,
        height: 400,
        closed: true,
        cache: false,
        buttons:buttons,
        modal: true
    });

    //导入用户信息
    $('#uploadDiv').dialog({
        title: '导入用户信息',
        width: 400,
        height: 250,
        closed: true,
        cache: false,
        buttons:buttons2,
        modal: true
    });

//上传文本框
    $('#uploadInput').filebox({
        required: true,
        prompt: '选择文件',
    });


    $('#cc').combotree({
        url: '/user/ShowField',
        multiple: true,
        checkbox: true,

        required: true,
        prompt: '请选择需要导出的字段(可多选)',
    });

//导出表单
    $('#ff').form({
        url: '/user/export',
        onSubmit: function () {},
    });
//导入表单
    $('#uploadForm').form({
        url: '/user/inputExcel',
        onSubmit: function () {},
    });

</script>


<table id="dg"></table>
<%--   选择导出属性   --%>
<div id="dd">
    <form id="ff">
        <input id="cc" name="filed" style="width: 300px;height: 30px">
    </form>
</div>


<%--   选择上传文件   --%>
<div id="uploadDiv">
    <form id="uploadForm" enctype="multipart/form-data" method="post">
        <input id="uploadInput" name="file" style="width: 300px;height: 30px">
    </form>
</div>
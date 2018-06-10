<%@page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; UTF-8" %>

<script type="text/javascript">


    $(function () {
        $('#ff').form({
            closed:true,
            url: '/slide/add',
            success: function (data) {
                alert("保存成功")
                $('#dd').dialog({ closed: true});
            }
        });
        //格式化标题框
        $("#title").textbox({
            prompt: "请输入标题",
            required: true
        });
        //格式化描述框
        $("#ms").textbox({
            prompt: "请输入相关描述(可不填)",
        });
        //文件筐
        $("#img").filebox({
            prompt: "请选择文件",
            required: true
        });


    });
</script>

<style type="text/css">
    #big{
        margin-top: 10%;
        margin-left: 10%;
    }
</style>


<form id="ff" method="post" enctype="multipart/form-data">
    <div id="big">
        <div>
            <label for="title">标题:</label>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input id="title" name="title"/>
        </div>
        </br>
        <div>
            <label for="ms">描述:</label>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input id="ms" name="ms"/>
        </div>
        </br>

        <div>
            <label for="img">选择文件:</label>
            &nbsp;&nbsp;<input id="img" name="img"/>
        </div>

    </div>

</form>
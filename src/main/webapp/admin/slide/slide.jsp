<%@page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; UTF-8" %>
<script type="text/javascript">
    $(function () {

        var cls=[[
                {field: 'title', title: '标题', width: 100},
                {field: 'status', title: '状态', width: 100,editor:"text"},
                {field: 'imagePath', title: '路径', width: 100},
                {field: 'date', title: '时间', width: 100, align: 'right'}
            ]];


        $('#dg').edatagrid();

        $('#dg').edatagrid({
            url: '/slide/showAll',
            updateUrl:'/slide/update',
            destroyUrl:'/slide/delete',
            columns:cls,
            singleSelect:false,
            ctrlSelect:true,
            fitColumns: true,
            striped: true,
            //工具栏=============================================
            toolbar: [{
                iconCls: 'icon-add',
                handler: function () {//添加
                    $('#dd').dialog({ closed: false});
                }
            }, '-', {
                iconCls: 'icon-edit',
                handler: function () {//修改
                    $.each($("#dg").edatagrid("getSelections"),function(index,row){
                        $("#dg").edatagrid("editRow",$("#dg").edatagrid("getRowIndex",row));
                    })



                }
            }, '-', {
                iconCls: 'icon-control_remove_blue',
                handler: function () {//删除
                    $('#dg').edatagrid('destroyRow');
                },
            }, '-', {
                iconCls: 'icon-picture_save',
                handler: function () {
                    $('#dg').edatagrid("saveRow")
                },
            }],

            //=======================隐藏显示=================================
            view: detailview,
            detailFormatter: function (rowIndex, rowData) {
                //alert("'"+rowData.imagePath+"'");
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="' + rowData.imagePath + '" style="height:50px;"></td>' + '<td style="border:0">' +
                    '<p>描述: ' + rowData.title + '</p>' +
                    '<p>状态: ' + rowData.status + '</p>' +
                    '<p>时间: ' + rowData.date + '</p>' +
                    '</td>' +
                    '</tr></table>';
            },


        });
        //===============================dialog窗口===========================================
        //工具按钮
        var buttons=[{
            text:'保存',
            handler:function(){
                $('#ff').submit();
            }
        },{
            text:'关闭',
            handler:function(){
                $('#dd').dialog({ closed: true});
            }
        }];
       $('#dd').dialog({
            title: '添加图片',
            width: 400,
            height: 250,
            closed: true,
            cache: false,
            href: '/admin/slide/form.jsp',
            modal: true,
            buttons:buttons,
        });



    });

</script>

<table  id="dg"></table>
<div id="dd"></div>

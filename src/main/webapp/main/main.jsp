<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>持名法州主页</title>
    <link rel="stylesheet" type="text/css" href="../themes/default/easyui.css">
        <link rel="stylesheet" type="text/css" href="../themes/IconExtension.css">
        <script type="text/javascript" src="../js/jquery.min.js"></script>
    <script type="text/javascript" src="../js/jquery.easyui.min.js"></script>
    <!-- 引入 ECharts 文件 -->
    <script src="../js/echarts.min.js"></script>
    <script type="text/javascript" src="../js/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/china.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.edatagrid.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/datagrid-detailview.js"></script>
    <script type="text/javascript">
        //========================================菜单=========================================
   $(function () {

       //$('#main').tabs('add',{});
       $('#aa').accordion({
           animate: false
       });

       $.ajax({
           url: "/showMenus",
           success: function (result) {
               $.each(result, function (index124, m) {
                   var second = "";
                   $.each(m.children, function (index2, m2) {
                       second = second + "</br><p  style='text-align: center' id=\"btn\" " +
                           "onClick=createTab('"+m2.url+"','"+m2.title+"','"+m2.iconCls+"') "+
                           "class=\"easyui-linkbutton\" data-options=\"iconCls:'icon-search'\">"
                           + m2.title + "</p></br></br>";
                   });
                   if (m.parent_id == null) {
                       $('#aa').accordion('add', {
                           title: m.title,
                           content: second,
                           selected: false,
                           iconCls:m.iconCls,
                       });
                   }
               })
           }
       })

   });
        function createTab(url,title,iconCls) {

            $('#main').tabs();
            if(!$('#main').tabs("exists",title)){
                //alert("url=="+url+"   title="+title + "   iconcls="+iconCls);
                $('#main').tabs('add',{
                    title:title,
                    //href:'/admin/resources/tree.jsp',
                    //href:'/admin/slide/slide.jsp',
                    href:url,

                    closable:true,
                    tools:[{
                        iconCls:'icon-mini-refresh',
                        handler:function(){
                            alert('refresh');
                        }
                    }]
                });
            }else{
                $('#main').tabs("select",title);
            }

        }
    </script>


</head>
<body class="easyui-layout">
<div data-options="region:'north',split:true" style="height:60px;background-color:  #5C160C">
    <div style="font-size: 24px;color: #FAF7F7;font-family: 楷体;font-weight: 900;width: 500px;float:left;padding-left: 20px;padding-top: 10px">
        持名法州后台管理系统
    </div>
    <div style="font-size: 16px;color: #FAF7F7;font-family: 楷体;width: 300px;float:right;padding-top:15px">
        欢迎您:${sessionScope.admin.name} &nbsp;<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">修改密码</a>&nbsp;&nbsp;<a
            href="/back/exit" class="easyui-linkbutton" data-options="iconCls:'icon-01'">退出系统</a></div>
</div>
<div data-options="region:'south',split:true" style="height: 40px;background: #5C160C">
    <div style="text-align: center;font-size:15px; color: #FAF7F7;font-family: 楷体">&copy;百知教育 htf@zparkhr.com.cn</div>
</div>

<div data-options="region:'west',   title:'导航菜单',split:true" style="width:220px;">
   <%-- <jsp:include page="menu.jsp"></jsp:include>--%>
    <div id="aa"></div>
</div>
<div data-options="region:'center'">
    <div id="tt" class="easyui-tabs" data-options="fit:true,narrow:true,pill:true">
        <div id="main" title="主页" data-options="iconCls:'icon-neighbourhood',"
             style="background-image:url(image/shouye.jpg);background-repeat: no-repeat;background-size:100% 100%;"></div>
    </div>
</div>
</body>
</html>
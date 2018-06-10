<%@page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>持名法州后台管理中心</title>

    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">

    <link rel="icon" href="img/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="css/common.css" type="text/css"/>
    <link rel="stylesheet" href="css/login.css" type="text/css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/script/jquery.js"></script>
    <script type="text/javascript" src="script/common.js"></script>
    <script type="text/javascript">


        //标记验证码是否正确
        var flag="false";

        $(function(){
            //点击更换验证码：
            $("#captchaImage").click(function(){//点击更换验证码
                document.getElementById("captchaImage").src="/getImage?date="+new Date().getTime();

            });
            //自动检测验证码

            $("#enCode").blur(function () {
                var code=$("#enCode").val();
                $.ajax({
                    url:"/getCode",
                    success:function(date){
                        if(date==code){
                            flag="true";
                            $("#check").addClass("ok").text("√");
                        }else{
                            $("#check").addClass("filed").text("×");
                        }
                    }
                })

            })


            $("#login").click(function(){
                if(flag=="false"){
                    alert("请输入正确的验证码！！！");
                    //return;
                }
                var name=$("#name").val()
                var password=$("#password").val();
                alert(name+password);
                $.ajax({
                    type:"post",
                    url:"/back/login",
                    data:"name="+name+"&password="+password,
                    dateType:"text",
                    success:function(result){
                        if(result=="success")
                            location.href="/main/main.jsp";
                        else
                            alert("error"+result);
                    }
                });
            });



        });
    </script>
</head>
<body>

<div class="login">
    <form id="loginForm" action="../back/index.html" method="post" >

        <table>
            <tbody>
            <tr>
                <td width="190" rowspan="2" align="center" valign="bottom">
                    <img src="img/header_logo.gif" />
                </td>
                <th>
                    用户名:
                </th>
                <td>
                    <input type="text" id="name" name="name" class="text" value="请输入用户名" maxlength="20"/>
                </td>
            </tr>
            <tr>
                <th>
                    密&nbsp;&nbsp;&nbsp;码:
                </th>
                <td>
                    <input type="password" id="password" name="password" class="text"  maxlength="20" autocomplete="off"/>
                </td>
            </tr>

            <tr>
                <td>&nbsp;</td>
                <th>验证码:</th>
                <td>
                    <input type="text" id="enCode" name="enCode" class="text captcha" maxlength="4" autocomplete="off"/>
                    <img id="captchaImage" width="120px" class="captchaImage" src="/getImage" title="点击更换验证码"/>
                    <span id="check"></span>
                </td>
            </tr>
            <tr>
                <td>
                    &nbsp;
                </td>
                <th>
                    &nbsp;
                </th>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <th>&nbsp;</th>
                <td>
                    <input type="button" class="homeButton" value="" onclick="location.href='/'"><input type="button"   id="login" class="loginButton" value="登录">
                </td>
            </tr>
            </tbody></table>
        <div class="powered">COPYRIGHT © 2008-2017.</div>
        <div class="link">
            <a href="http://www.chimingfowang.com/">持名佛网首页</a> |
            <a href="http://www.chimingbbs.com/">交流论坛</a> |
            <a href="">关于我们</a> |
            <a href="">联系我们</a> |
            <a href="">授权查询</a>
        </div>
    </form>
</div>
</body>
</html>
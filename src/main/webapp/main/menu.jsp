<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
    <!--菜单处理-->


    $('#aa').accordion({
        animate: false
    });

        $.ajax({
            url: "/showMenus",
            success: function (result) {
                $.each(result, function (index, m) {
                    var second = "";
                    $.each(m.children, function (index2, m2) {
                        second = second + "<p  style='text-align: center' id=\"btn\" " +
                            "class=\"easyui-linkbutton\" data-options=\"iconCls:'icon-search'\">"
                            + m2.title + "</p></br>";
                       // alert(second);
                        $('#second' + (index + 1)).linkbutton({
                            iconCls: 'icon-search',
                        });
                    });
                    if (m.parent_id == null) {
                        $('#aa').accordion('add', {

                            title: m.title,
                            content: second,
                            selected: false,
                            iconCls:'icon-large_clipart.png',
                        });
                    }
                })
            }
        })


</script>

</head>
<body>

    <div id="aa" class="easyui-accordion" data-options="fit:true">

    </div>
</body>
</html>
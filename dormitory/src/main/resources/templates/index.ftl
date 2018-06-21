<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>主页</title>
	<#include "layout/stylesandscripts.ftl">
</head>
<body>
<div class="layui-layout layui-layout-admin">
	<#include "layout/header.ftl">
    <div style="height: 60px;"></div>
	<#include "layout/menu_navigation.ftl">
    <div style="margin-left: 200px;">
        <#--ajax刷新div使用-->
     <#--<div id="mainContent"></div>-->
	<#include "${pagepath.mypath}">
    </div>
    <#include "layout/footer.ftl">
</div>


<script>
    //JavaScript代码区域
    layui.use('element', function () {
        var element = layui.element;
    });

</script>

<script>
    function ajaxfresh(url) {
        $.ajax({
            type: "get",
            async: false,
            url: url,
            timeout:3000,
            success:function (page) {
                        $("#mainContent").html(page);
                    },
            error: function () {
                console.log("faild");
            }
        });
    }
</script>
</body>
</html>
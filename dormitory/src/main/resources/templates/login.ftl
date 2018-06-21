<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>登录</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <!-- <link href="/res/font/font-awesome.css" rel="stylesheet" media="screen">
    <link href="/res/font/font-awesome.min.css" rel="stylesheet" media="screen">

    <link href="/res/layui-font/iconfont.css" rel="stylesheet" media="screen"> -->

    <link href="/dorm/layui/css/layui.css" rel="stylesheet">
    <link href="/dorm/css/login/global.css" rel="stylesheet">
    <link href="/dorm/css/login/style.css" rel="stylesheet">
    <script src="/dorm/js/jquery-3.2.1.min.js" type="text/javascript"></script>
    <script src="/dorm/layui/layui.js" type="text/javascript"></script>
    <!--<script src="/public/layui/layui.all.js" type="text/javascript"></script>-->
    <!--<script src="/public/global.js" type="text/javascript"></script>-->
    <style>
        .layui-form-item .layui-input-inline {
            margin: 0 0 10px 0px
        }
    </style>
</head>
<body>
<!-- 用户登录 -->

<div class="login-main" id="login">
    <header class="layui-elip">学生宿舍管理系统</header>
    <form class="layui-form" id="loginform">
        <div class="layui-form-item">
            <div class="layui-input-inline">
                <input id="username" name="username" placeholder="请输入登录用户名"  type="text" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-inline">
                <input id="password" name="password" placeholder="请输入登录密码"  type="password" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item" style="display: none">
            <div class="layui-input-inline">
                <label id="loginerror" style="color:red"></label>
            </div>
        </div>
        <div class="layui-input-inline login-btn">
            <button type="submit" lay-submit="" lay-filter="login" class="layui-btn" id="loginbutton">登录</button>
        </div>
        <hr/>
        <p><a href="javascript:showMain('register');" class="fl">注册账号</a><a href="javascript:showMain('newpassword');" class="fr">忘记密码？</a></p>
    </form>
</div>

<!-- 找回密码 -->
<div class="login-main" id="newpassword" style="display:none;">
    <header class="layui-elip">找回密码</header>
    <form class="layui-form" id="newpasswordform">
        <div class="layui-form-item">
            <div class="layui-input-inline" style="width:65%;float:left;">
                <input name="email" lay-verify="email" placeholder="请输入注册账号的邮箱"  type="text" autocomplete="off" class="layui-input">
            </div>
            <div class="layui-input-inline" style="width:29%;float:right;">
                <div onclick="sendEmailCode()" class="layui-btn">获取验证码</div>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-inline">
                <input name="code" lay-verify="required" placeholder="请输入邮件的验证码"  type="text" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-inline">
                <input name="password" lay-verify="required" placeholder="请输入新的登录密码"  type="password" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-input-inline login-btn">
            <button type="submit" lay-submit="" lay-filter="newpassword" class="layui-btn">修改</button>
        </div>
        <hr/>
        <p><a href="javascript:showMain('register');" class="fl">注册账号</a><a href="javascript:showMain('login');" class="fr">我有账号</a></p>
    </form>
</div>

<!-- 用户注册 -->
<div class="login-main" id="register" style="display:none;">
    <header class="layui-elip">新用户注册</header>
    <form class="layui-form" id="registerForm">
        <div class="layui-form-item">
            <div class="layui-input-inline" style="width:65%;float:left;">
                <input name="email" lay-verify="email" placeholder="请输入您的邮箱"  type="text" autocomplete="off" class="layui-input">
            </div>
            <div class="layui-input-inline" style="width:29%;float:right;">
                <div onclick="sendRegistEmailCode()" class="layui-btn">获取验证码</div>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-inline">
                <input name="code" lay-verify="required" placeholder="请输入邮件的验证码"  type="text" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-inline">
                <input name="userName" lay-verify="required" placeholder="请输入用户名"  type="text" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-inline">
                <input name="password" lay-verify="required" placeholder="请输入登录密码"  type="password" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-input-inline login-btn">
            <button type="submit" lay-submit="" lay-filter="register" class="layui-btn">立即注册</button>
        </div>
        <hr/>
        <p><a href="javascript:;" class="fl"></a><a href="javascript:showMain('login');" class="fr">我有账号</a></p>
    </form>
</div>
<script>
    $(function() {
//	var form = layui.form();
        layui.use('form',function () {
            var form=layui.form;
            form.on('submit(login)', function(data) {
                $.ajax({
                    url:'/dorm/dologin',
                    type:'POST',
                    data:$('#loginform').serialize(),//字符串或者对象（key/value的格式）
                    dataType:'json',
                    beforeSend:function () {
                        //每次登录前清除错误提示信息
//					$('#loginerror').parent().parent().hide();
//					$('#loginerror').text('');

                        var username=$('#username').val();
                        var password=$('#password').val();
                        if(!username){
                            layer.tips('用户名必填', '#username',{
                                tips:[2,'#f7ca18']
                            });
                            return false;//取消本次ajax请求
                        }
                        if(!password){
                            layer.tips('密码必填', '#password',{
                                tips:[2,'#f7ca18']
                            });
                            return false;//取消本次ajax请求
                        }

                        $('#loginbutton').text("登录中...");
                        $('#loginbutton').attr("disabled",true);
                    },
                    success:function(res){
//					console.log(data);
                        if(res.code==0){
                            window.location.href="/dorm/index";
                            //  /dorm/index
                        }
                        else{
//						$('#loginerror').parent().parent().show();
//						$('#loginerror').text(res.msg);
                            layer.msg(res.msg);

                            $('#loginbutton').text("登录");
                            $('#loginbutton').attr("disabled",false);
                        }
                    }
                });

                return false;
            });
        });
    });


    //修改密码
    /*form.on('submit(newpassword)', function(data) {
        wait("正在修改......");
        $.post("changePassword.json",$("#newpasswordform").serialize(),function(data) {
            hide();
            if(data.code == 200) {
                success("修改成功请登录");
                showMain("login");
            }
            else {
                error(data.msg);
            }

        },"json");
        return false;
    });

    //新用户注册
    form.on('submit(register)', function(data) {
        wait("正在注册......");
        $.post("register.json",$("#registerForm").serialize(),function(data) {
            hide();
            if(data.code == 200) {
                success("注册成功请登录");
                showMain("login");
            }
            else {
                error(data.msg);
            }

        },"json");
        return false;
    });

});

function sendEmailCode() {
    wait("请稍后......");
    $.post("sendChangePasswordEmailCode.json",$("#newpasswordform").serialize(),function(data) {
        hide();
        if(data.code == 200) {
            success("发送成功,请登录你的邮箱查询");
        }
        else {
            error(data.msg);
        }

    },"json");
    return false;
}

//新用户注册
function sendRegistEmailCode() {
    wait("请稍后......");
    $.post("sendRegistEmailCode.json",$("#registerForm").serialize(),function(data) {
        hide();
        if(data.code == 200) {
            success("发送成功,请登录你的邮箱查询");
        }
        else {
            error(data.msg);
        }

    },"json");
    return false;
}

function showMain(id) {
    $(".login-main").hide();
    $("#"+id).show();
}*/
</script>
</body>
</html>

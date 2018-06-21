<!--<style type="text/css">
    .avatar{
        width: 45px;
        height: 45px;
        margin-right: 10px;
        border-radius: 50%;
    }
</style>-->

<div class="layui-header">
    <div class="layui-logo">学生宿舍管理系统</div>
    <ul class="layui-nav layui-layout-right">
        <li class="layui-nav-item">
            <a href="javascript:;">
                <img id="imgMini" src="/dorm/img/defaultavatar.jpeg" class="layui-nav-img">
                ${myuser}
            </a>
            <dl class="layui-nav-child">
                <dd><a href="javascript:;" onclick="changeAvatar()">修改头像</a></dd>
                <dd><a href="">安全设置</a></dd>
                <dd><a href="/dorm/logout">退出系统</a></dd>
            </dl>
        </li>
        <!--<li class="layui-nav-item"><a href="">退了</a></li>-->
    </ul>
</div>

<div id="avatarhtml" style="display: none" class="layui-row">
    <div class="layui-col-md-offset3">
        <input type="hidden" id="file_id">
        <!--<input type="hidden" id="url" value="$!{url}">-->
        <button type="button" class="layui-btn" id="selectImg">选择图片</button>
        <button type="button" class="layui-btn layui-btn-danger" id="upload">开始上传</button>
        <div class="layui-upload-list">
            <img class="layui-upload-img" src="/img/defaultavatar.jpeg" id="img" style="border: 1px solid #f2f2f2;width: 256px;height: 256px;">
            <p id="imgText"></p>
        </div>
    </div>
</div>
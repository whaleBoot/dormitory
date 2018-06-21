<div class="layui-side layui-bg-black">
    <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
    <ul class="layui-nav layui-nav-tree" id="nav_tree">
        <li class="layui-nav-item">
            <a href="/dorm/index">系统概述</a></li>
        <li class="layui-nav-item" >
            <a  href="javascript:;" >学生信息管理</a>
            <dl class="layui-nav-child" >
                <dd><a href="/dorm/stuinfo/stuadd">添加学生信息</a></dd>
                <dd><a href="/dorm/stuinfo/stulist">管理学生信息</a></dd>
                <#--<dd><a href="" onclick="ajaxfresh('/dorm/stuinfo/stulist')">管理学生信息</a> </dd>-->
            </dl>
        </li>
        <li class="layui-nav-item">
            <a href="javascript:;">宿舍信息管理</a>
            <dl class="layui-nav-child">
                <dd><a href="/dorm/dormadd">添加宿舍信息</a></dd>
                <dd><a href="/dorm/dormlist">管理宿舍信息</a></dd>
            </dl>
        </li>
        <li class="layui-nav-item">
            <a href="javascript:;">系统用户管理</a>
            <dl class="layui-nav-child">
                <dd><a href="javascript:;">添加用户信息</a></dd>
                <dd><a href="javascript:;">管理用户信息</a></dd>
            </dl>
        </li>
        <li class="layui-nav-item"><a href="javascript:;">关于</a></li>
    </ul>
</div>
</div>
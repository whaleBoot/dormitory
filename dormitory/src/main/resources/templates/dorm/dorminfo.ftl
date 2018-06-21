<div style="position: relative">
<#--列表页content-->
    <blockquote class="layui-elem-quote" style="position: fixed;width: 100%; z-index: 10;">
        <form class="layui-form layui-form-pane"  id="searchForm">
            <div class="layui-form-item" style="margin-bottom: 0;">
                <div class="layui-inline">
                    <label class="layui-form-label" style="margin-bottom: 0">姓名</label>
                    <div class="layui-input-inline">
                        <input type="text" name="name" id="usernameSearch" placeholder="请输入姓名" autocomplete="off"
                               class="layui-input">
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label" style="margin-bottom: 0">宿舍号</label>
                    <div class="layui-input-inline">
                        <input type="text" name="sid" id="telSearch" placeholder="请输入宿舍号" autocomplete="off"
                               class="layui-input">
                    </div>
                </div>
                <div class="layui-inline">
                    <button class="layui-btn" id="search-btn" lay-submit lay-filter="search" onclick="javascript:void(0);">查询</button>
                </div>
            </div>
        </form>
    </blockquote>
<#--主要内容content-->
    <div id="page-content-wrapper" style="">
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-12 column">
                <#--<table class="table table-bordered table-condensed">-->
                    <table class="layui-table">
                        <thead>
                        <tr style="background-color: #f2f2f2; height: 40px;line-height: 40px;">
                            <th>楼号</th>
                            <th>宿舍号</th>
                            <th>人数</th>
                            <th>性别</th>
                            <th>价格</th>
                            <th>报修信息</th>
                            <th colspan="2">操作</th>
                        </tr>
                        </thead>
                        <tbody>

                        <#list dormPage.content as dorm>
                        <tr>
                            <td>${dorm.bid}</td>
                            <td>${dorm.did}</td>
                            <td>${dorm.canlive}</td>
                            <td>${dorm.gender}</td>
                            <td>${dorm.price}</td>
                            <td>${dorm.repair}</td>
                            <td><a href="/dorm/dormtoEdit?num=${dorm.id}">修改</a></td>
                            <td><a href="/dorm/dormdelete?sid=${dorm.id}">删除</a></td>
                        </tr>
                        </#list>
                        </tbody>
                    </table>
                </div>

            <#--分页-->
                <div class="col-md-12 column">
                    <ul class="pagination pull-left">
                    <#if currentPage lte 1>
                        <li class="disabled"><a href="#">上一页</a></li>
                    <#else>
                        <li><a href="/dorm/dormlist?page=${currentPage - 1}&size=${size}">上一页</a></li>
                    </#if>

                    <#list 1..dormPage.getTotalPages() as index>
                        <#if currentPage == index>
                            <li class="disabled"><a href="#">${index}</a></li>
                        <#else>
                            <li><a href="/dorm/dormlist?page=${index}&size=${size}">${index}</a></li>
                        </#if>
                    </#list>

                    <#if currentPage gte dormPage.getTotalPages()>
                        <li class="disabled"><a href="#">下一页</a></li>
                    <#else>
                        <li><a href="/dorm/dormlist?page=${currentPage + 1}&size=${size}">下一页</a></li>
                    </#if>
                    </ul>
                </div>

            </div>
        </div>

    </div>
    <div class="zhe" id="zhe"></div>
    <div class="search-toast" id="search-toast">
        <dl>
            <dt>结果 <span>X</span></dt>
            <dl>学号：<span id="sid"></span></dl>
            <dl>姓名：<span id=""></span>性别：<span> 女</span>年龄：<span> 3</span></dl>
            <dl>手机号： 12345678911</dl>
            <dl>学院： 信电学院</dl>
            <dl>专业： 计算机科学与技术</dl>
            <dl><span>楼号： 1</span><span>宿舍号： 425</span></dl>
        </dl>
    </div>
</div>


<style>
    .zhe {
        /*注释*/
        display: none;
        width: 100%;
        height: 100%;
        background-color: #ccc;
        opacity: 0.6;
        z-index: 11;
        position: absolute;
        top: 0;
    }

    .search-toast {
        /*注释*/
        display: none;
        position: absolute;
        width: 350px;
        margin: auto;
        top: 0px;
        left: 0;
        right: 0;
        bottom: 0;
        z-index: 12;
        border: 1px solid #ccc;
        height: 300px;
        background: #ccc;
    }

    .search-toast dt {
        background-color: #000;
        color: #fff;
        height: 40px;
        line-height: 40px;
        padding-left: 10px;
        margin: -5px;
    }

    .search-toast dt span {
        display: inline-block;
        height: 40px;
        width: 40px;
        text-align: center;
        color: #red;
        float: right;
        cursor: pointer;
    }

    .search-toast dl {
        margin: 5px;
        height: 30px;
        line-height: 30px;
        border-bottom: 1px solid #fff;
    }

    .search-toast dl span {
        margin-right: 10px;
    }
</style>


<script>
    $(function () {

        $("#search-btn").click(function () {

            $.ajax({
                url: "/dorm/stuinfo/findbyname",
                type: "post",
                async: true,//同步
                data: $('#searchForm').serialize(),//传出的数据
                dataType: "json",//返回的数据类型，常用：html/text/json
                success: function (res) {
                    if (res.code == 0) {
                        var mstu = res.data;
                        console.log(mstu)
                        $('#zhe').css('display', 'block')
                        $('#search-toast').css('display', 'block')
                    }
                }
            })
        });
    });
</script>
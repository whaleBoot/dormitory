
<#--修改信息-->
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <form role="form" method="post" action="/dorm/stuinfo/edit">
                        <div class="form-group">
                            <label>学号</label>
                            <input name="sid" type="text"  class="form-control" value="${(stu.sid)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>姓名</label>
                            <input name="name" type="text" class="form-control" value="${(stu.name)!''}"/>
                        </div>

                        <div class="form-group">
                            <label>密码</label>
                            <input name="password" type="password" class="form-control" value="${(stu.password)!''}"/>
                        </div>

                        <div class="form-group">
                            <label>年龄</label>
                            <input name="age" type="number" class="form-control" value="${(stu.age)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>性别</label>
                            <input name="sex" type="text"   class="form-control" value="${(stu.sex)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>手机号</label>
                            <input name="telephone" type="text" class="form-control" value="${(stu.telephone)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>学院</label>
                            <input name="department" type="text" class="form-control" value="${(stu.department)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>专业</label>
                            <input name="major" type="text" class="form-control" value="${(stu.major)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>居住楼号</label>
                            <input name="bid" type="text" class="form-control" value="${(stu.bid)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>居住宿舍号</label>
                            <input name="did" type="text" class="form-control" value="${(stu.did)!''}"/>
                        </div>

                        <#--<input hidden type="text" name="productId" value="${(s.productId)!''}">-->
                        <button type="submit" class="btn btn-default">提交</button>
                    </form>
                </div>
            </div>
        </div>
    </div>

</div>
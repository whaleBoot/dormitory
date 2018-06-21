
<#--修改信息-->
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <form role="form" method="post" action="/dorm/dormedit">
                        <div class="form-group">
                            <label>楼号</label>
                            <input name="sid" type="text"  class="form-control" value="${(dorm.bid)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>宿舍号</label>
                            <input name="name" type="text" class="form-control" value="${(dorm.did)!''}"/>
                        </div>

                        <div class="form-group">
                            <label>性别</label>
                            <input name="password" type="password" class="form-control" value="${(dorm.gender)!''}"/>
                        </div>

                        <div class="form-group">
                            <label>人数</label>
                            <input name="age" type="number" class="form-control" value="${(dorm.canlive)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>价格</label>
                            <input name="sex" type="text"   class="form-control" value="${(dorm.price)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>报修信息</label>
                            <input name="telephone" type="text" class="form-control" value="${(dorm.repair)!''}"/>
                        </div>

                        <#--<input hidden type="text" name="productId" value="${(s.productId)!''}">-->
                        <button type="submit" class="btn btn-default">提交</button>
                    </form>
                </div>
            </div>
        </div>
    </div>

</div>
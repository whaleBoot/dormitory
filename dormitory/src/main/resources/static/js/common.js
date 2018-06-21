function Format(now,mask){
    if(!now){
        return "";
    }

    var d = new Date(now);
    var zeroize = function (value, length)
    {
        if (!length) length = 2;
        value = String(value);
        for (var i = 0, zeros = ''; i < (length - value.length); i++)
        {
            zeros += '0';
        }
        return zeros + value;
    };

    return mask.replace(/"[^"]*"|'[^']*'|\b(?:d{1,4}|m{1,4}|yy(?:yy)?|([hHMstT])\1?|[lLZ])\b/g, function ($0){
        switch ($0)
        {
            case 'd': return d.getDate();
            case 'dd': return zeroize(d.getDate());
            case 'ddd': return ['Sun', 'Mon', 'Tue', 'Wed', 'Thr', 'Fri', 'Sat'][d.getDay()];
            case 'dddd': return ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday'][d.getDay()];
            case 'M': return d.getMonth() + 1;
            case 'MM': return zeroize(d.getMonth() + 1);
            case 'MMM': return ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'][d.getMonth()];
            case 'MMMM': return ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'][d.getMonth()];
            case 'yy': return String(d.getFullYear()).substr(2);
            case 'yyyy': return d.getFullYear();
            case 'h': return d.getHours() % 12 || 12;
            case 'hh': return zeroize(d.getHours() % 12 || 12);
            case 'H': return d.getHours();
            case 'HH': return zeroize(d.getHours());
            case 'm': return d.getMinutes();
            case 'mm': return zeroize(d.getMinutes());
            case 's': return d.getSeconds();
            case 'ss': return zeroize(d.getSeconds());
            case 'l': return zeroize(d.getMilliseconds(), 3);
            case 'L': var m = d.getMilliseconds();
                if (m > 99) m = Math.round(m / 10);
                return zeroize(m);
            case 'tt': return d.getHours() < 12 ? 'am' : 'pm';
            case 'TT': return d.getHours() < 12 ? 'AM' : 'PM';
            case 'Z': return d.toUTCString().match(/[A-Z]+$/);
            // Return quoted strings with the surrounding quotes removed
            default: return $0.substr(1, $0.length - 2);
        }
    });
};

$.fn.serializeObject = function(filter) {
    var o = Object.create(null),
        elementMapper = function(element) {
            element.name = $.camelCase(element.name);
            return element;
        },
        appendToResult = function(i, element) {
            if(element.value == "" && filter == true){
            }else{
                var node = o[element.name];
                if ('undefined' != typeof node && node !== null) {
                    o[element.name] = node.push ? node.push(element.value) : [node, element.value];
                }else {
                    o[element.name] = element.value;
                }
            }
        };

    $.each($.map(this.serializeArray(), elementMapper), appendToResult);
    return o;
};

function changeMenu(module) {
    $.get('/systemmenu/changeMenu',{module:module},function (res) {
        $('#nav_tree').html(res.data.menus);
    },"json");
}

function changeAvatar() {
    /*var url=$('#url').val();
    if(url){
        $('#img').attr('src',url);
    }
    else{
        $('#img').attr('src','/public/img/defaultavatar.jpeg');
    }*/
    var imgIndex=layer.open({
        type: 1,
        skin: 'layui-layer-rim', //加上边框
        area: ['600px', '450px'], //宽高
        title:['修改头像','font-size:24px;'],
        content: $('#avatarhtml'),
        btn:['保存','取消'],
        yes:function(index, layero){
            console.log(index);
            console.log(layero);
            var file_id=$('#file_id').val();
            $.post('/user/changeAvatar',{fileId:file_id},function (res){
                if(res.code==200){
                    layer.alert(res.msg,{icon: 1},function(index){
                        layer.close(index);
                        layer.close(imgIndex);
                    });
                    window.location.reload();
                }
                else if(res.code<0){
                    layer.alert(res.msg,{icon:2});
                }
                else{
                    layer.alert("服务器异常",{icon:2});
                }
            },"json");
        },
        btn2:function(index, layero){
            layer.close();
        }
    });
}


layui.use(['upload','util'],function () {
    var upload=layui.upload;
    var util=layui.util;

    util.fixbar({
    });

    //普通图片上传
    var uploadInst = upload.render({
        elem: '#selectImg',
        url: '/file/upload',
        auto:false,
        bindAction:'#upload',
        size:1024,//设置最大上传的文件大小，单位kb
        choose: function(obj){
            //预读本地文件示例，不支持ie8
            obj.preview(function(index, file, result){
                $('#img').attr('src', result); //图片链接（base64）
            });
        },
        before:function (obj) {
            console.log(obj);
            layer.load();
        },
        done: function(res){
            layer.closeAll('loading');
            //如果上传失败
            if(res.code==200){
                $('#file_id').val(res.data.id);
                return layer.msg('上传成功');
            }
            else{
                return layer.msg('服务器异常');
            }

            //上传成功
        },
        error: function(){
            layer.closeAll('loading');

            //演示失败状态，并实现重传
            var imgText = $('#imgText');
            imgText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-mini reload">重试</a>');
            imgText.find('.reload').on('click', function(){
                uploadInst.upload();
            });
        }
    });
});


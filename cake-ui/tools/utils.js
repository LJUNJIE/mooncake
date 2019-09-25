define([], function () {

    var utils = {};


    // 给ajax添加默认配置
    utils['ajaxDefaultConfig'] = function () {
        $.ajaxSetup({
            async: true,
            type: 'POST',
            contentType: 'application/json;charset=utf-8',
            dataType: 'json'
        });
    }

    // 请求报错添加提示
    utils['ajaxError'] = function () {
        $(document).ajaxError(function () {
            layer.msg('服务器错误');
        });
    }


    /**
     *
     *
     * @param {*} components ['table', 'form', 'laydate', 'laypage', 'laytpl']
     * @returns Promise
     */
    utils['loadComponents'] = function (components) {
        var defer = $.Deferred();

        layui.use(components, function () {
            window.gComponents = {}

            components.forEach(function (el) {
                window.gComponents[el] = layui[el];
            });

            defer.resolve(true);
        });

        return defer;
    };


    /**
     *
     *获取URL后面的参数  key是要获取的参数名称
     * @param {*} key
     * @returns value
     */
    utils['getUrlQuery'] = function (key) {
        var reg = new RegExp("(^|&)" + key + "=([^&]*)(&|$)", "i");
        var r = window.location.search.substr(1).match(reg);
        if (r != null) return unescape(r[2]);
        return null;
    };


    /**
     *
     *页面加载中的方法
     * @param {*} containerEl 页面的容器元素 一个jquery对象
     * @returns operate
     */
    utils['initLoading'] = function (containerEl) {
        var operate = {},
            index = null;

        operate.start = function () {
            if (containerEl instanceof jQuery) {
                containerEl.animate({
                    opacity: 0
                }, 100, function () {
                    index = layer.load(0);
                });
            } else {
                index = layer.load(0);
            }
        }

        operate.end = function () {
            if (containerEl instanceof jQuery) {
                containerEl.animate({
                    opacity: 1
                }, 500, function () {
                    layer.close(index);
                });
            } else {
                layer.close(index);
            }
        }

        return operate;
    }

    /**
     *获取HTML
     *
     * @param {*} url
     * @returns Promise
     */
    utils['getHTML'] = function (url) {
      return $.ajax({
            async: true,
            type: 'GET',
            contentType: 'text/html;charset=utf-8',
            dataType: 'html',
            url: url
        });
    }

    return utils;

});
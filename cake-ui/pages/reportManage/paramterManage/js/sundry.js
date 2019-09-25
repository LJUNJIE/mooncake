define([], function () {
    'use strict';

    var Sundry = {};

    Sundry['API'] = {
        getTemTree: '/temTree',
        getParaTree: '/paraTree'
    };

    /**
     *
     *
     * @param {*} postData 请求传递的参数
     * @returns promise
     */
    Sundry['getTemTree'] = function (postData) {
        return $.ajax({
            url: Sundry.API.getTemTree,
            data: postData
        })
    };


    /**
     *
     *
     * @param {*} postData
     * @returns promise
     */
    Sundry['getParaTree'] = function (postData) {
        return $.ajax({
            url: Sundry.API.getParaTree,
            data: postData
        });
    }

    return Sundry;
});
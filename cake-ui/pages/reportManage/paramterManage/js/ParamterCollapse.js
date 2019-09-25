define(['./Collapse.js'], function(Collapse) {
    'use strict';
    
    function ParamterCollapse (data) {
        this.data = data;
    }

    ParamterCollapse.prototype = new Collapse();

    return ParamterCollapse

});
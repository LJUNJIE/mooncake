define(['./Collapse.js'], function(Collapse) {
    'use strict';

    function TemplateCollapse (data) {
        this.data = data;
    }

    TemplateCollapse.prototype = new Collapse();

    TemplateCollapse.prototype.deleteItem = function () {
        
    };

    TemplateCollapse.prototype.modifyItem = function () {

    }

    return TemplateCollapse;
    
});
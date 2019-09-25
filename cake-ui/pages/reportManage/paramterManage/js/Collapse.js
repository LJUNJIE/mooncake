define([], function() {
    'use strict';

    var attrs = {
        data: {
            get: function () {
                return this._data;
            },
            set: function (newVal, oldVal) {
                this._data = newVal;
                this.render(newVal);
            }
        }
    }

    function Collapse () {
        this._data = null;
        Object.defineProperties(this, attrs);
    }

    Collapse.prototype.render = function (data) {
       var html = template('collapse_tem_parent' , data);
       console.log('模板获取',html)
       $('#template_pannel').html(html);
       gComponents.element.render('collapse');
    };

    
    return Collapse;
});
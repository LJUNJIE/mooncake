require([
    '../../../tools/utils.js',
    './js/sundry.js',
    './js/TemplateCollapse.js',
    './js/ParamterCollapse.js'
], function (Utils, Sundry, TemplateCollapse , ParamterCollapse) {

    Utils.loadComponents(['element', 'layer']).then(function () {
       var element = gComponents.element;
       
       // 开启ajax默认配置
       Utils.ajaxDefaultConfig();
       
       // 开启错误提示
       Utils.ajaxError();

       return Utils.getHTML('./template.html');
    }).then(function (html) {
        var temContainer = $('#template_container');

        // 注入模板并将不需要编译的部分 添加到DOM
        temContainer.html(html).prev('#app').html($('#container_tem').html());

        // 获取折叠面板的数据
        return $.when(Sundry.getTemTree(null), Sundry.getParaTree(null));
    }).then(function (temTreeData, paraTreeData) {
        console.log('temTreeData', temTreeData[0])
        var tCollapse = new TemplateCollapse(temTreeData[0]);
        var pCollapse = new ParamterCollapse(paraTreeData[0]);
    });


});
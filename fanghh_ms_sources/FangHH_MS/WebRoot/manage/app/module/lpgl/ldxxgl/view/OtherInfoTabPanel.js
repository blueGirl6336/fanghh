Ext.define('HRMS.module.lpgl.ldxxgl.view.OtherInfoTabPanel', {
    extend: 'Ext.tab.Panel',
    alias: 'widget.otherinfopanel',
    activeTab: 0,
    border:0,
    initComponent: function () {
        Ext.applyIf(this, {
            items: [
                Ext.create('HRMS.module.lpgl.ldxxgl.view.House')
            ]
        });
        this.callParent(arguments);
    },
    //向主操作页面中添加标签页
    addView: function (view) {
        var items = this.items.items;
        if (items != null) {
            for (var i in items) {
                if (items[i].title == view.title) {
                    this.setActiveTab(items[i]);
                    return;
                }
            }
            this.add(view);
            this.setActiveTab(view);
        }
    },
    //判断是否已经有某个页面
    //如果有，直接设置为高亮
    hasThisPage: function (title) {
        var items = this.items.items;
        if (items != null) {
            for (var i in items) {
                if (items[i].title == title) {
                    this.setActiveTab(items[i]);
                    return true;
                }
            }
        }
        return false;
    }
});
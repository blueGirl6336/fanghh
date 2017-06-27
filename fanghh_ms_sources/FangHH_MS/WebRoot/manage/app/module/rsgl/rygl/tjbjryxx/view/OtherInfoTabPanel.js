Ext.define('HRMS.module.rsgl.rygl.tjbjryxx.view.OtherInfoTabPanel', {
    extend: 'Ext.tab.Panel',
    alias: 'widget.otherinfopanel',
    activeTab: 0,
    border:0,
    initComponent: function () {
        Ext.applyIf(this, {
            items: [
                Ext.create('HRMS.module.rsgl.rygl.tjbjryxx.view.Quota'),
                Ext.create('HRMS.module.rsgl.rygl.tjbjryxx.view.EducationBackground'),
                Ext.create('HRMS.module.rsgl.rygl.tjbjryxx.view.WorkExperience'),
                Ext.create('HRMS.module.rsgl.rygl.tjbjryxx.view.ProfessionalAndTechnical'),
                Ext.create('HRMS.module.rsgl.rygl.tjbjryxx.view.ManagementPosition'),
                Ext.create('HRMS.module.rsgl.rygl.tjbjryxx.view.Contact'),
                Ext.create('HRMS.module.rsgl.rygl.tjbjryxx.view.AbroadAndVisiting'),
                Ext.create('HRMS.module.rsgl.rygl.tjbjryxx.view.Awards'),
                Ext.create('HRMS.module.rsgl.rygl.tjbjryxx.view.ServicePost'),
                Ext.create('HRMS.module.rsgl.rygl.tjbjryxx.view.PoliticalStatus'),
                Ext.create('HRMS.module.rsgl.rygl.tjbjryxx.view.Tutor'),
                Ext.create('HRMS.module.rsgl.rygl.tjbjryxx.view.TalentsProgram'),
                Ext.create('HRMS.module.rsgl.rygl.tjbjryxx.view.FamilyMembers'),
                Ext.create('HRMS.module.rsgl.rygl.tjbjryxx.view.SocialConcurrentPost')
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
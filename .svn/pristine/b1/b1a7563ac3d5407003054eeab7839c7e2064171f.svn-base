/*定制grid控件，增加行背景颜色的设置。
 * 根据数据是否通过验证，改变背景颜色
 */

Ext.define('HRMS.customize.GridWithBgColr', {
	extend : 'Ext.grid.Panel',
	stripeRows:false ,
	viewConfig: {
        //Return CSS class to apply to rows depending upon data values
        getRowClass: function(record, index) {
            var c = record.get('throughAudit');
            if (c) {
                return 'grid-row-throughAudit';
            } else {
                return 'x-grid-row-alt';
            }
        }
    }

});
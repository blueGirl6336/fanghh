/* 定制报表显示控件
 */
Ext.define('HRMS.customize.ReportTablePanel', {
	extend : 'Ext.panel.Panel',
	bodyCls : 'reportTable',
	margin : '15 0 0 0',
	initComponent : function() {
		var me = this;

		this.callParent(arguments);
		me.getTableData(me, me.tableUrl);
	},

	getTableData : function(panel, url) {
		Ext.Ajax.request({
			url : url,
			success : function(response) {
				var jsonResult = Ext.JSON.decode(response.responseText);
				var reportTable = jsonResult.data;
				panel.showTableData(panel, reportTable);
			}
		});
	},
	showTableData : function(me, reportTable) {
		var html = me.generateHtml(reportTable);
		me.update(html);
	},
	generateHtml : function(reportTable) {
		var html = "";
		html += this.addTitleLine(reportTable);
		html += reportTable.html;
		html += this.addRemark(reportTable);
		return html;
	},
	addTitleLine : function(reportTable) {
		var line = "";
		if (reportTable.updateDate != null && reportTable.updateDate != '') {
			line += "<span class=\"updateTime\">数据日期：" + reportTable.updateDate
					+ "</span>";
		}
		return line;
	},
	addRemark : function(reportTable) {
		var line = "";
		if (reportTable.remark != null) {
			line += "<br />"+reportTable.remark;
			return line;
		} else {
			return '';
		}
	}
});
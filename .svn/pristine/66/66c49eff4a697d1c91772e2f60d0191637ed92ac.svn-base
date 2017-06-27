/**
 * @class Ext.ux.grid.Printer
 * @author Ed Spencer (edward@domine.co.uk) Helper class to easily print the
 *         contents of a grid. Will open a new window with a table where the
 *         first row contains the headings from your column model, and with a
 *         row for each item in your grid's store. When formatted with
 *         appropriate CSS it should look very similar to a default grid. If
 *         renderers are specified in your column model, they will be used in
 *         creating the table. Override headerTpl and bodyTpl to change how the
 *         markup is generated
 * 
 * Usage:
 * 
 * 1 - Add Ext.Require Before the Grid code Ext.require([
 * 'Ext.ux.grid.GridPrinter', ]);
 * 
 * 2 - Declare the Grid var grid = Ext.create('Ext.grid.Panel', { columns:
 * //some column model, store : //some store });
 * 
 * 3 - Print! Ext.ux.grid.Printer.mainTitle = 'Your Title here'; //optional
 * Ext.ux.grid.Printer.print(grid);
 * 
 * Original url: http://edspencer.net/2009/07/printing-grids-with-ext-js.html
 * 
 * Modified by Loiane Groner (me@loiane.com) - September 2011 - Ported to Ext JS
 * 4 http://loianegroner.com (English) http://loiane.com (Portuguese)
 * 
 * Modified by Bruno Sales - August 2012
 * 
 * Modified by Paulo Goncalves - March 2012
 * 
 * Modified by Beto Lima - March 2012
 * 
 * Modified by Beto Lima - April 2012
 * 
 * Modified by Paulo Goncalves - May 2012
 * 
 * Modified by Nielsen Teixeira - 2012-05-02
 * 
 * Modified by Joshua Bradley - 2012-06-01
 * 
 * Modified by Loiane Groner - 2012-09-08
 * 
 * Modified by Loiane Groner - 2012-09-24
 * 
 * Modified by Loiane Groner - 2012-10-17 FelipeBR contribution: Fixed: support
 * for column name that cotains numbers Fixed: added support for template
 * columns
 * 
 * Modified by QIQI - 2013-03-17 Close automatically after print
 * 
 */
Ext
		.define(
				"Ext.ux.grid.Printer",
				{

					requires : 'Ext.XTemplate',

					statics : {
						/**
						 * Prints the passed grid. Reflects on the grid's column
						 * model to build a table, and fills it using the store
						 * 
						 * @param {Ext.grid.Panel}
						 *            grid The grid to print
						 */
						print : function(grid) {
							// We generate an XTemplate here by using 2
							// intermediary XTemplates - one to create the
							// header,
							// the other to create the body (see the escaped {}
							// below)
							var columns = [];
							// account for grouped columns
							Ext.each(grid.columns, function(c) {
								if (c.items.length > 0) {
									columns = columns.concat(c.items.items);
								} else {
									columns.push(c);
								}
							});
							// Ext.each(columns, function (c) {
							// alert(c.labelWidth);
							// });

							// build a usable array of store data for the
							// XTemplate
							// 修改：只处理选中项
							var data = [];
							Ext
									.each(
											grid.getSelectionModel()
													.getSelection(),
											function(item, row) {
												var convertedData = {};

												// apply renderers from column
												// model
												for ( var key in item.data) {
													var value = item.data[key];

													Ext
															.each(
																	columns,
																	function(
																			column,
																			col) {

																		if (column
																				&& column.dataIndex == key) {

																			/*
																			 * TODO:
																			 * add
																			 * the
																			 * meta
																			 * to
																			 * template
																			 */
																			var meta = {
																				item : '',
																				tdAttr : '',
																				style : ''
																			};
																			value = column.renderer ? column.renderer
																					.call(
																							grid,
																							value,
																							meta,
																							item,
																							row,
																							col,
																							grid.store,
																							grid.view)
																					: value;
																			var varName = Ext.String
																					.createVarName(column.dataIndex);
																			if (value == null)
																				value = '';
																			convertedData[varName] = value;

																		} else if (column
																				&& column.xtype === 'rownumberer') {

																			var varName = Ext.String
																					.createVarName(column.id);
																			convertedData[varName] = (row + 1);

																		} else if (column
																				&& column.xtype === 'templatecolumn') {

																			value = column.tpl ? column.tpl
																					.apply(item.data)
																					: value;

																			var varName = Ext.String
																					.createVarName(column.id);
																			convertedData[varName] = value;

																		}
																	}, this);
												}

												data.push(convertedData);
											});

							// remove columns that do not contains dataIndex or
							// dataIndex is empty. for example: columns filter
							// or columns button
							var clearColumns = [];
							Ext
									.each(
											columns,
											function(column) {
												if ((column)
														&& (!Ext
																.isEmpty(column.dataIndex) && !column.hidden)) {
													clearColumns.push(column);
												} else if (column
														&& column.xtype === 'rownumberer') {
													column.text = '序号';
													clearColumns.push(column);
												} else if (column
														&& column.xtype === 'templatecolumn') {
													clearColumns.push(column);
												}
											});
							columns = clearColumns;

							// get Styles file relative location, if not
							// supplied
							if (this.stylesheetPath === null) {
								var scriptPath = Ext.Loader
										.getPath('Ext.ux.grid.Printer');
								this.stylesheetPath = scriptPath.substring(0,
										scriptPath.indexOf('Printer.js'))
										+ 'gridPrinterCss/print.css';
							}

							// use the headerTpl and bodyTpl markups to create
							// the main XTemplate below
							// Ext.each(columns,function(c){
							// alert(c.toString());
							// });
							var headings = Ext.create('Ext.XTemplate',
									this.headerTpl).apply(columns);
							var body = Ext
									.create('Ext.XTemplate', this.bodyTpl)
									.apply(columns);

							var pluginsBody = '', pluginsBodyMarkup = [];

							// add relevant plugins
							Ext.each(grid.plugins, function(p) {
								if (p.ptype == 'rowexpander') {
									pluginsBody += p.rowBodyTpl.join('');
								}
							});

							if (pluginsBody != '') {
								pluginsBodyMarkup = [
										'<tr class="{[xindex % 2 === 0 ? "even" : "odd"]}"><td colspan="'
												+ columns.length + '">',
										pluginsBody, '</td></tr>' ];
							}

							// Here because inline styles using CSS, the browser
							// did not show the correct formatting of the data
							// the first time that loaded
							// modified by QIQI don't use
							/*
							 * var htmlMarkup = [ '<!DOCTYPE html PUBLIC
							 * "-//W3C//DTD XHTML 1.0 Transitional//EN"
							 * "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">', '<html
							 * class="' + Ext.baseCSSPrefix +
							 * 'ux-grid-printer">', '<head>', '<meta
							 * content="text/html; charset=UTF-8"
							 * http-equiv="Content-Type" />', '<link href="' +
							 * this.stylesheetPath + '" rel="stylesheet"
							 * type="text/css" />', '<title>' + grid.title + '</title>', '<style
							 * type="text/css">', "body{margin: 0; padding:
							 * 0;color:red;}", '</style>', '</head>', '<body
							 * class="' + Ext.baseCSSPrefix +
							 * 'ux-grid-printer-body">', '<div class="' +
							 * Ext.baseCSSPrefix + 'ux-grid-printer-noprint ' +
							 * Ext.baseCSSPrefix + 'ux-grid-printer-links">', '<a
							 * class="' + Ext.baseCSSPrefix +
							 * 'ux-grid-printer-linkprint"
							 * href="javascript:void(0);"
							 * onclick="window.print();">' + this.printLinkText + '</a>', '<a
							 * class="' + Ext.baseCSSPrefix +
							 * 'ux-grid-printer-linkclose"
							 * href="javascript:void(0);"
							 * onclick="window.close();">' + this.closeLinkText + '</a>', '</div>', '<h1><center>' +
							 * this.mainTitle + '</center></h1>', '<table>', '<tr>',
							 * headings, '</tr>', '<tpl for=".">', '<tr class="{[xindex % 2 === 0 ? "even" : "odd"]}">',
							 * body, '</tr>', pluginsBodyMarkup.join(''), '</tpl>', '</table>', '</body>', '</html>'];
							 */

							var htmlHead = '<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">'
									+ '<html class="'
									+ Ext.baseCSSPrefix
									+ 'ux-grid-printer">'
									+ '<head>'
									+ '<meta content="text/html; charset=UTF-8" http-equiv="Content-Type" />'
									+ '<title>'
									+ grid.title
									+ '</title>'
									+ '<script language="javascript" src="../ext-4.2/ux/grid/LodopFuncs.js"></script>'
									+ this.objectString
									+ this.savescript
									+ '<link href="./css/print.css" rel="stylesheet" type="text/css"/>'
									+ '</head>';

							var htmlBodyTmpl = [
									'<body class="' + Ext.baseCSSPrefix
											+ 'ux-grid-printer-body">',
									'<div class="' + Ext.baseCSSPrefix
											+ 'ux-grid-printer-noprint '
											+ Ext.baseCSSPrefix
											+ 'ux-grid-printer-links">',
											'<input type="file" id="file" style="display:none"/>',
									'<input class="button" type="button" onclick="window.print();" value='
											+ this.printLinkText + ' />',
									'<input class="button" type="button" onclick="javascript:SaveAsExcel();" value='
											+ this.exportExcel + ' />',
									'<input class="button" type="button" onclick="javascript:SaveAsWord(\'UTF-8\',document.getElementById(\'allInfoTable\').innerHTML);" value='
											+ this.exportWord + ' />',
									'<input class="button" type="button" onclick="window.close();" value='
											+ this.closeLinkText + ' />',
									'</div>',
									'<h1><center>' + this.mainTitle
											+ '</center></h1>',
									'<div id="allInfoTable">',
									'<table >',
									'<thead>',
									'<tr>',
									headings,
									'</tr>',
									'</thead>',
									'<tpl for=".">',
									'<tr class="{[xindex % 2 === 0 ? "even" : "odd"]}">',
									body, '</tr>', pluginsBodyMarkup.join(''),
									'</tpl>', '</table>', '</div>', '</body>',
									'</html>' ];

							var htmlBody = Ext.create('Ext.XTemplate',
									htmlBodyTmpl).apply(data);
							var html = htmlHead + htmlBody;

							// open up a new printing window, write to it, print
							// it and close
							var win = window.open('', 'printgrid');

							// document must be open and closed
							win.document.open();
							win.document.write(html);
							// win.document.close();

							if (this.printAutomatically) {
								win.print();
							}

							// Another way to set the closing of the main
							if (this.closeAutomaticallyAfterPrint) {
								if (Ext.isIE) {
									window.close();
								} else {
									win.close();
								}
							}
						},

						/**
						 * @property stylesheetPath
						 * @type String The path at which the print stylesheet
						 *       can be found (defaults to
						 *       'ux/grid/gridPrinterCss/print.css')
						 */
						stylesheetPath : null,

						/**
						 * @property printAutomatically
						 * @type Boolean True to open the print dialog
						 *       automatically and close the window after
						 *       printing. False to simply open the print
						 *       version of the grid (defaults to false)
						 */
						printAutomatically : false,

						/**
						 * @property closeAutomaticallyAfterPrint
						 * @type Boolean True to close the window automatically
						 *       after printing. (defaults to false)
						 */
						closeAutomaticallyAfterPrint : true,

						/**
						 * @property mainTitle
						 * @type String Title to be used on top of the table
						 *       (defaults to empty)
						 */
						mainTitle : '',

						/**
						 * Text show on print link
						 * 
						 * @type String
						 */
						printLinkText : '打印',
						/**
						 * Text show on export to Excel
						 * 
						 * @type String
						 */
						exportExcel : '导出Excel',
						/**
						 * Text show on export to Word
						 * 
						 * @type String
						 */
						exportWord : '导出Word',
						/**
						 * Text show on export to Pdf
						 * 
						 * @type String
						 */
						exportPdf : '导出PDF',

						/**
						 * Text show on close link
						 * 
						 * @type String
						 */
						closeLinkText : '关闭',
						/**
						 * object
						 * 
						 * @type String
						 */
						objectString : '<object id="LODOP_OB" classid="clsid:2105C259-1E0C-4534-8141-A753534CB4CA" width=0 height=0> '
								+ '<embed id="LODOP_EM" TYPE="application/x-print-lodop" width=0 height=0 PLUGINSPAGE="install_lodop32.exe"></embed>'
								+ '</object>',
						/**
						 * export to Excel javascript
						 * 
						 * @type String
						 */
						savescript : '<script language="javascript" type="text/javascript">'
								+ 'var LODOP; /*声明为全局变量*/'
								+ 'function SaveAsExcel(){'
								+ 'LODOP=getLodop(document.getElementById(\'LODOP_OB\'),document.getElementById(\'LODOP_EM\'));'
								+ 'LODOP.PRINT_INIT("");'
								+ 'LODOP.ADD_PRINT_TABLE(20,20,"100%","100%",document.getElementById("allInfoTable").innerHTML); '
								+ 'LODOP.SET_SAVE_MODE("Orientation",2); /*Excel文件的页面设置：横向打印   1-纵向,2-横向;*/'
								+ 'LODOP.SET_SAVE_MODE("PaperSize",9);  /*Excel文件的页面设置：纸张大小   9-对应A4*/'
								+ 'LODOP.SET_SAVE_MODE("Zoom",100);       /*Excel文件的页面设置：缩放比例*/'
								+ 'LODOP.SET_SAVE_MODE("CenterHorizontally",true);/*Excel文件的页面设置：页面水平居中*/'
								+ 'LODOP.SET_SAVE_MODE("CenterVertically",true); /*Excel文件的页面设置：页面垂直居中*/'
								+ '/*LODOP.SET_SAVE_MODE("QUICK_SAVE",true);快速生成（无表格样式,数据量较大时或许用到）*/ '
								+ 'LODOP.SAVE_TO_FILE("新文件名.xls");'
								+ '};'
								+ 'function printAllInfo(){'
								+ 'LODOP=getLodop(document.getElementById(\'LODOP_OB\'),document.getElementById(\'LODOP_EM\'));'
								+ 'LODOP.PRINT_INIT("打印控件功能演示_Lodop功能_预览打印表格");'
								+ 'LODOP.ADD_PRINT_TABLE("2%","1%","96%","98%",document.getElementById("allInfoTable").innerHTML);'
								+ 'LODOP.SET_PRINT_STYLE("HOrient",3);'
								+ 'LODOP.SET_PRINT_STYLE("VOrient",3);'
								+ 'LODOP.SET_PRINT_PAGESIZE(0,0,0,"A4");'
								+ 'LODOP.PREVIEW();};'
								+ 'function SaveAsWord(intWriteMode,strText) {'
								+ 'LODOP=getLodop(document.getElementById(\'LODOP_OB\'),document.getElementById(\'LODOP_EM\')); '
								+ 'var strFilename = prompt("请输入文件名","file1");if(strFilename==""||strFilename==null)return;'
								+ 'strFilename="C:/"+strFilename;if(strFilename.indexOf(".doc") == -1)strFilename+=".doc";'
								+ 'var strResult=LODOP.WRITE_FILE_TEXT(intWriteMode,strFilename,strText);'
								+ '	if (strResult=="ok") alert("导出成功！\\n文件为:"+strFilename);else alert("导出失败");'
								+ '};'
								+ '</script>',
						/**
						 * @property headerTpl
						 * @type {Object/Array} values The markup used to create
						 *       the headings row. By default this just uses
						 *       <th> elements, override to provide your own
						 */
						headerTpl : [ '<tpl for=".">',
								'<th width="{width}">{text}</th>', '</tpl>' ],

						/**
						 * @property bodyTpl
						 * @type {Object/Array} values The XTemplate used to
						 *       create each row. This is used inside the
						 *       'print' function to build another XTemplate, to
						 *       which the data are then applied (see the
						 *       escaped dataIndex attribute here - this ends up
						 *       as "{dataIndex}")
						 */
						bodyTpl : [
								'<tpl for=".">',
								'<tpl if="values.dataIndex">',
								'<td align="center">\{{[Ext.String.createVarName(values.dataIndex)]}\}</td>',
								'<tpl else>',
								'<td align="center">\{{[Ext.String.createVarName(values.id)]}\}</td>',
								'</tpl>', '</tpl>' ]
					}
				});
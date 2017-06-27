/**
 * @class Ext.ux.grid.StatementPrinter
 * @author QIQI
 * Help customer to print the special settlement statement for 
 * natural gas toll system
 * 
 * Usage:
 * 
 * 1 - Add Ext.Require Before the Grid code
 * Ext.require([
 *   'Ext.ux.grid.StatementPrinter',
 * ]);
 * 
 * 2 - Declare the Grid 
 * var grid = Ext.create('Ext.grid.Panel', {
 *   columns: //some column model,
 *   store   : //some store
 * });
 * 
 * 3 - Print!
 * Ext.ux.grid.Printer.mainTitle = 'Your Title here'; //optional
 * Ext.ux.grid.Printer.print(grid);
 * 
 */
Ext.define("Ext.ux.grid.StatementPrinter", {

    requires: 'Ext.XTemplate',

    statics: {

        print: function (records) {
            //We generate an XTemplate here by using 2 intermediary XTemplates - one to create the header,
            //the other to create the body (see the escaped {} below)

            l = records.length;

            var i = 0;
            this.content = '';
            var myDate = new Date();
            var paperMaker = NGTS.GLOBAL.ACCOUNT.account.name;
            var statementStart = '<div class="SettlementStatement">';
            var titlePart = '<div class="titlePadding"></div>';
            var paymentHearderPart = '<div class="paymentHeaderPadding"></div>';
            var remarkPart = '<div class="remark"></div>';
            var spcingPart = '<div class="spacing"></div>';
            var statementEnd = '</div>';

            for (var i = 0; i < l; i++) {
                recordObj = records[i].data;
                paymentTime = recordObj.paymentTime;
                dateOfFillingObj = {
                    year: paymentTime.split('/')[0],
                    month: paymentTime.split('/')[1],
                    day: paymentTime.split('/')[2]
                };
                dateOfFillingPart = Ext.create('Ext.XTemplate', this.dateOfFillingTpl).apply(dateOfFillingObj);

                cusInfoObj = {
                    cusName: recordObj.name,
                    cusAddress: recordObj.address,
                    cusAccountNumber: recordObj.accountNumber
                };
                cusInfoPart = Ext.create('Ext.XTemplate', this.cusInfoTpl).apply(cusInfoObj);

                dateArray = recordObj.meterReadingTime.split('/');
                paymentInfoObj = {
                    year: dateArray[0],
                    month: dateArray[1],
                    day: dateArray[2],
                    laFigure: recordObj.laFigure,
                    toFigure: recordObj.toFigure,
                    priceType: recordObj.gasType,
                    amount: recordObj.amount,
                    price: recordObj.price,
                    totalMoney: recordObj.s_money
                }
                paymentInfoPart = Ext.create('Ext.XTemplate', this.paymentInfoTpl).apply(paymentInfoObj);

                overdueFineObj = {
                    overdueFine: recordObj.overdueFine,
                    remark: recordObj.remark
                };
                overdueFinePart = Ext.create('Ext.XTemplate', this.overdueFineTpl).apply(overdueFineObj);

                totalPayInfoObj = {
                    thousand: '零',
                    hundred: '零',
                    ten: '零',
                    one: '零',
                    pointOne: '零',
                    cent: '零',
                    wholeTotal: recordObj.totalMoney
                }

                totalPayInfoObj = this.convertWholeToCapital(totalPayInfoObj, recordObj.totalMoney);
                totalPayInfoPart = Ext.create('Ext.XTemplate', this.totlePayInCapitalTpl).apply(totalPayInfoObj);


                operatorObj = {
                    cashier: recordObj.cashier,
                    ssMaker: paperMaker
                };
                operatorPart = Ext.create('Ext.XTemplate', this.operatorTpl).apply(operatorObj);


                aStatement = statementStart + titlePart + dateOfFillingPart + cusInfoPart + paymentHearderPart + paymentInfoPart + overdueFinePart + remarkPart + totalPayInfoPart + operatorPart + spcingPart+statementEnd;
                
                this.content = this.content + aStatement;

            };

            //get Styles file relative location, if not supplied
            if (this.stylesheetPath === null) {
                var scriptPath = Ext.Loader.getPath('Ext.ux.grid.StatementPrinter');
                this.stylesheetPath = scriptPath.substring(0, scriptPath.indexOf('StatementPrinter.js'));
            }

            

            //Here because inline styles using CSS, the browser did not show the correct formatting of the data the first time that loaded
            var htmlBodyTpl = [
                '<body class="' + Ext.baseCSSPrefix + 'ux-grid-printer-body">',
                //'<div class="' + Ext.baseCSSPrefix + 'ux-grid-printer-noprint ' + Ext.baseCSSPrefix + 'ux-grid-printer-links">',
                //'<a class="' + Ext.baseCSSPrefix + 'ux-grid-printer-linkprint" href="javascript:void(0);" onclick="window.print();">' + this.printLinkText + '</a>',
                //'<a class="' + Ext.baseCSSPrefix + 'ux-grid-printer-linkclose" href="javascript:void(0);" onclick="window.close();">' + this.closeLinkText + '</a>',
                '</div>',
                	this.content,
                '</body>',
                '</html>'];

            data = {};
            
//            this.cssText = this.getCssContent();
            
            var htmlHead =  '<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">' + 
            '<html xmlns="http://www.w3.org/1999/xhtml">' + 
            '<head>'+
            '<meta content="text/html; charset=UTF-8" http-equiv="Content-Type" />'+
//            '<link href="' + this.stylesheetPath + 'statementPrinterCss/print.css" rel="stylesheet" type="text/css" />',
            //'<link href="' + this.stylesheetPath + 'gridPrinterCss/print.css" rel="stylesheet" type="text/css" />',
            '<title>个人简历</title>'+
            '<style type="text/css">' +
            this.cssText +
            '</style>' +
            '</head>';

            
            var htmlBody = Ext.create('Ext.XTemplate', htmlBodyTpl).apply(data);
            var html = htmlHead + htmlBody;
            
            //open up a new printing window, write to it, print it and close
            var win = window.open('', 'printgrid');

            //document must be open and closed
            win.document.open();
            win.document.write(html);
            //win.document.close();
            
            if (this.printAutomatically) {
                win.print();
            }


            //Another way to set the closing of the main
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
         * @type String
         * The path at which the print stylesheet can be found (defaults to 'ux/grid/gridPrinterCss/print.css')
         */
        stylesheetPath: './statementPrinterCss/print.css',

        /**
         * @property printAutomatically
         * @type Boolean
         * True to open the print dialog automatically and close the window after printing. False to simply open the print version
         * of the grid (defaults to false)
         */
        printAutomatically: true,

        /**
         * @property closeAutomaticallyAfterPrint
         * @type Boolean
         * True to close the window automatically after printing.
         * (defaults to false)
         */
        closeAutomaticallyAfterPrint: true,

        /**
         * Text show on print link
         * @type String
         */
        printLinkText: '打印',

        /**
         * Text show on close link
         * @type String
         */
        closeLinkText: '关闭',

        /**
         * @property headerTpl
         * @type {Object/Array} values
         * The markup used to create the headings row. By default this just uses <th> elements, override to provide your own
         */
        

        cssText: ".SettlementStatement{padding: 0;margin-left: auto;margin-right: auto;width: 598.32pt;height: 254.9pt;}.SettlementStatement .lable{height: 100%;float: left;text-align: center;}.SettlementStatement .titlePadding{width: 100%;height: 20pt;}.SettlementStatement .dateOfFilling{width: 100%;height: 24pt;}.SettlementStatement .dateOfFilling .year{width: 40.54pt;margin-left: 20pt;}.SettlementStatement .dateOfFilling .month{width: 24.34pt;margin-left: 11.73pt;}.SettlementStatement .dateOfFilling .day{width: 20.8pt;margin-left: 15.336pt;}.SettlementStatement .dateOfFilling .SSNumber.SettlementStatement .cusInfo{width: 100%;height: 27pt;}.SettlementStatement .cusInfo .cusName{width: 61.344pt;margin-left: 55.336pt;}.SettlementStatement .cusInfo .address{width: 207.432pt;margin-left: 27pt;font-size: 0.9em;}.SettlementStatement .cusInfo .accountNumber{width: 81.072pt;margin-left: 63pt;}.SettlementStatement .paymentHeaderPadding{width: 100%;height: 27.75pt;}.SettlementStatement .paymentInfo{width: 100%;height: 26.25pt;}.SettlementStatement .paymentInfo .year{width: 40.536pt;margin-left: 20pt;}.SettlementStatement .paymentInfo .month{width: 24.336pt;margin-left: 11.736pt;}.SettlementStatement .paymentInfo .day{width: 10pt;margin-left: 15.336pt;}.SettlementStatement .paymentInfo .laFigure{width: 50.256pt;margin-left: 30pt;}.SettlementStatement .paymentInfo .toFigure{width: 49.536pt;margin-left: 0pt;}.SettlementStatement .paymentInfo .type{width: 53.64pt;margin-left: 5pt;font-size: 0.9em;}.SettlementStatement .paymentInfo .amount{width: 54pt;margin-left: 0pt;}.SettlementStatement .paymentInfo .price{width: 63pt;margin-left: 0pt;}.SettlementStatement .paymentInfo .totalMoney{width: 81.072pt;margin-left: -10pt;}.SettlementStatement .overdueFine{width: 100%;height: 27.75pt;}.SettlementStatement .overdueFine .value{width: 351.504pt;margin-left: 180pt;text-align: left !important;padding-top: 5pt;}.SettlementStatement .remark{width: 100%;height: 34pt;}.SettlementStatement .totalPay{width: 100%;height: 29.35pt;}.SettlementStatement .totalPay .thousand{width: 20.74pt;margin-left: 120pt;}.SettlementStatement .totalPay .hundred{width: 27.76pt;margin-left: 16.2pt;}.SettlementStatement .totalPay .ten{width: 27.07pt;margin-left: 14pt;}.SettlementStatement .totalPay .one{width: 16.632pt;margin-left: 22pt;}.SettlementStatement .totalPay .pointOne{width: 35.136pt;margin-left: 13.536pt;}.SettlementStatement .totalPay .cent{width: 28.8pt;margin-left: 14.4pt;}.SettlementStatement .totalPay .wholeTotal{width: 65.736pt;margin-left: 75pt;}.SettlementStatement .operator{width: 100%;height: 20.25pt;}.SettlementStatement .operator .cashier{width: 63.072pt;margin-left: 268.44pt;}.SettlementStatement .operator .maker{width: 81.072pt;margin-left: 80.6pt;}.SettlementStatement .spacing{width: 100%;/* 调整两个结算单之间的间隔 */height: 45pt;}",
//        cssText : "",
        dateOfFillingTpl: [
            '<div class="dateOfFilling">',
            '<div class="year lable">{year}</div>',
            '<div class="month lable">{month}</div>',
            '<div class="day lable">{day}</div>',
            '</div>'],
        cusInfoTpl: [
            '<div class="cusInfo">',
            '<div class="cusName lable">{cusName}</div>',
            '<div class="address lable">{cusAddress}</div>',
            '<div class="accountNumber lable">{cusAccountNumber}</div>',
            '</div>'],
        paymentInfoTpl: [
            '<div class="paymentInfo">',
            '<div class="year lable">{year}</div>',
            '<div class="month lable">{month}</div>',
            '<div class="day lable">{day}</div>',
            '<div class="laFigure lable">{laFigure}</div>',
            '<div class="toFigure lable">{toFigure}</div>',
            '<div class="type lable">{priceType}</div>',
            '<div class="amount lable">{amount}</div>',
            '<div class="price lable">{price}</div>',
            '<div class="totalMoney lable">{totalMoney}</div>',
            '</div>'],
        overdueFineTpl: ['<div class="overdueFine">',
            '<div class="value lable">{overdueFine}{remark}</div>',
            '</div>'],
        totlePayInCapitalTpl: [
            '<div class="totalPay">',
            '<div class="thousand lable">{thousand}</div>',
            '<div class="hundred lable">{hundred}</div>',
            '<div class="ten lable">{ten}</div>',
            '<div class="one lable">{one}</div>',
            '<div class="pointOne lable">{pointOne}</div>',
            '<div class="cent lable">{cent}</div>',
            '<div class="wholeTotal lable">{wholeTotal}</div>',
            '</div>'],

        operatorTpl: [
            '<div class="operator">',
            '<div class="cashier lable">{cashier}</div>',
            '<div class="maker lable">{ssMaker}</div>',
            '</div>'],

        convertANumberToCapital: function (number) {
            var result = '';
            switch (number) {
                case '0':
                    result = '零';
                    break;
                case '1':
                    result = '壹';
                    break;
                case '2':
                    result = '贰';
                    break;
                case '3':
                    result = '叁';
                    break;
                case '4':
                    result = '肆';
                    break;
                case '5':
                    result = '伍';
                    break;
                case '6':
                    result = '陆';
                    break;
                case '7':
                    result = '柒';
                    break;
                case '8':
                    result = '捌';
                    break;
                case '9':
                    result = '玖';
                    break;
                default:
                    result = '零';
                    break;
            };
            return result;
        },
        convertWholeToCapital: function (resultObj, number) {
            var charArray = number.split('');
            n = charArray.length;
            for (var i = n - 1; i >= 0; i--) {
                if (i == n - 1) {
                    resultObj.cent = this.convertANumberToCapital(charArray[i]);
                }
                if (i == n - 2) {
                    resultObj.pointOne = this.convertANumberToCapital(charArray[i]);
                }
                if (i == n - 4) {
                    resultObj.one = this.convertANumberToCapital(charArray[i]);
                }
                if (i == n - 5) {
                    resultObj.ten = this.convertANumberToCapital(charArray[i]);
                }
                if (i == n - 6) {
                    resultObj.hundred = this.convertANumberToCapital(charArray[i]);
                }
                if (i == n - 7) {
                    resultObj.thousand = this.convertANumberToCapital(charArray[i]);
                }
            }
            return resultObj;
        }
        //load css file dynamically but only on IE
//        ,
//        getCssContent: function(){
//        	var fso=new ActiveXObject(Scripting.FileSystemObject);
//        	var f=fso.opentextfile(this.stylesheetPath,1, false); 
//        	text = f.ReadAll();
//        	f.close();
//        	return text;
//        }


    }
});
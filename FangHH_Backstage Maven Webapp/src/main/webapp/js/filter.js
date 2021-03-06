angular
	.module('manageBuildingFilter', [])
	.filter('exchangeNum', function() {
		var dicCode = {
			"1": "一",
			"2": "两",
			"3": "三",
			"4": "四",
			"5": "五",
			"6": "六",
			"7": "七",
			"8": "八",
			"9": "九",
			//门店认证
			"06110200": "审核通过",
			"06110300": "审核未通过",
			//用户认证
			"22000200": "已经申请认证",
			"22000100": "未申请认证",

			// 活动
			'02020500': '捡漏',
			'02020200': '团购',
			'02020600': '特惠',

			//楼盘
			"01200600": '待完善',
			"01200100": '待上架',
			"01200300": '已上架',
			"01200500": '已下架',
			"13020200": '未通过',
			"13020100": '审核通过',
			"13020200": '审核未通过',
			"13020300": '待审核',
			"01200200": '已申请上架'
		}
		return function(code) {
			// if (code == null || code == '') {
			// 	return "无";
			// }
			if(dicCode[code] == null) {
				// console.error('字典码 ' + code + ' 不存在');
				return "无";
			}
			return dicCode[code];
		}
	});
	// .filter('exchangeNull', function() {
	// 	return function(data) {
	// 		if (data == null) {
	// 			return '无';
	// 		}
	// 		else {
	// 			return data;
	// 		}
	// 	}
	// })
	// .filter('exchangeAll', function() {
	// 	return function(data) {
	// 		if (data == '无') {
	// 			return '全部';
	// 		}
	// 		else {
	// 			return data;
	// 		}
	// 	}
	// })
	// .filter('exchangeEmpty', function() {
	// 	return function(data) {
	// 		if (data != '') {
	// 			return data;
	// 		}
	// 	}
	// })
	// .filter('exchangePercentage', function() {
	// 	return function(data) {
	// 		if (data == null) {
	// 			return '0';
	// 		}
	// 		else if(!isNaN(data)) {
	// 			return data*100;
	// 		}
	// 		else {
	// 			return data;
	// 		}
	// 	}
	// })
	// .filter('exchangeDate', function() {
	// 	return function(data) {
	// 		if (data == null) {
	// 			return '';
	// 		} else {
	// 			var myDate =new Date(data);
	// 			return myDate.getMonth()+1 +"月"+ myDate.getDate()+"日";
	// 		}
	// 	}
	// });
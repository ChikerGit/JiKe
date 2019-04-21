/**
 * jQuery日期插件
 * 倒计时
 */
 (function($){
	/** 添加对象方法 */
	$.fn.extend({
		downCount : function(targetDate, prefix, suffix){ // 倒计时方法
			/** 对前缀与后缀进行判断 */
			prefix = prefix ? prefix : "";
			suffix = suffix ? suffix : "";
			/** 把目标时间转化成毫秒数 */
			var targetMillSeconds = Date.parse(targetDate.replace(/-/g, "/"));
			/** 创建内置函数Date获取当前时间毫秒数 */
			var currentMillSeconds = new Date().getTime();
			/** 如果当前时间毫秒数小于目标时间毫秒数 */
			if (currentMillSeconds < targetMillSeconds)
			{
				/** 计算出相差的秒数 */
				var seconds = Math.floor((targetMillSeconds - currentMillSeconds) / 1000);
				/** 计算出相差的分钟 */
				var minutes = Math.floor(seconds / 60);
				/** 计算出相差的小时 */
				var hours = Math.floor(minutes / 60);

				/** 定义数组拼接最终要显示的结果 */
				var res = new Array();

				/** 还剩<font>0</font><font>0</font><strong>:</strong>
						<font>0</font><font>0</font><strong>:</strong>
						<font>0</font><font>0</font>结束 */

				res.push($.calc(hours));
				res.push($.calc(minutes - (hours * 60)));
				res.push($.calc(seconds - (minutes * 60)));

				/** 添加innerHTML */
				this.html(prefix + res.join("<strong>:</strong>") + suffix);
				/** 声明当前jquery对象为局部变量 */
				var t = this;

				/** 开启延迟定时器 */
				setTimeout(function(){
					t.downCount(targetDate, prefix, suffix);
				}, 1000);
			}else{
				this.html("<font>0</font><font>0</font><strong>:</strong><font>0</font><font>0</font><strong>:</strong><font>0</font><font>0</font>");
			}
		}
	});

	/** 添加静态方法 */
	$.extend({
		/** 计算方法 */
		calc : function(str){
			/** 判断 */
			str = str > 9 ? str + "" : "0" + str;
			/** 得到数组 */
			var arr = str.split("");
			/** 定义最终返回的字符串 */
			var res = "";
			/** 返回数组 */
			for (var i in arr){
				res += "<font>" + arr[i] + "</font>";
			}
			/** 拼结果返回 */
			return res;
		}
	});
 }(jQuery));
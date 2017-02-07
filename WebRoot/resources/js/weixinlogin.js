//判断是否在微信浏览其中
if(myUtils.isWeiXinBrowse()){
//微信授权登录
//  if(!sessionStorage.getItem("weixinlogin")){
//	  sessionStorage.setItem("weixinlogin",1);
//	  //location.replace("https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx6482f21128769e54&redirect_uri=http://"+location.host+"/weixin/authorization/baselogin&response_type=code&scope=snsapi_base&state="+location.href+"#wechat_redirect");
//	  location.replace("/weixin/authorize");
//	  }else{
//	  	//location.replace("/user/login");
//	  }
				
						//请求jsapi
						$.ajax({
							url:"/weixin/js/connection?url="+encodeURIComponent(location.href.split('#')[0]),
							type:"GET",
							success:function(dd){
							console.log( $.parseJSON(dd));
							var appid=$.parseJSON(dd).appid;
							var timeStamp=$.parseJSON(dd).timestamp;
							var nonceStr=$.parseJSON(dd).noncestr;
							var signature=$.parseJSON(dd).signature;
							//time_stamp=timeStamp;
							//配置jsapi
							//alert(nonceStr)
							wx.config({
						    debug: false, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
						    appId: appid, // 必填，公众号的唯一标识
						    timestamp: timeStamp, // 必填，生成签名的时间戳
						    nonceStr: nonceStr, // 必填，生成签名的随机串
						    signature: signature,// 必填，签名，见附录1
						    jsApiList: [
						                'checkJsApi',
						                'onMenuShareTimeline',
						                'onMenuShareAppMessage',
						                'onMenuShareQQ',
						                'onMenuShareWeibo',
						                'onMenuShareQZone',
						                'hideMenuItems',
						                'showMenuItems',
						                'hideAllNonBaseMenuItem',
						                'showAllNonBaseMenuItem',
						                'translateVoice',
						                'startRecord',
						                'stopRecord',
						                'onVoiceRecordEnd',
						                'playVoice',
						                'onVoicePlayEnd',
						                'pauseVoice',
						                'stopVoice',
						                'uploadVoice',
						                'downloadVoice',
						                'chooseImage',
						                'previewImage',
						                'uploadImage',
						                'downloadImage',
						                'getNetworkType',
						                'openLocation',
						                'getLocation',
						                'hideOptionMenu',
						                'showOptionMenu',
						                'closeWindow',
						                'scanQRCode',
						                'chooseWXPay',
						                'openProductSpecificView',
						                'addCard',
						                'chooseCard',
						                'openCard'
						              ] // 必填，需要使用的JS接口列表，所有JS接口列表见附录2
						});  
						}});
						

}
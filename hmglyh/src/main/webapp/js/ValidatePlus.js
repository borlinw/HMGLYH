$.extend($.fn.validatebox.defaults.rules, {
    CHS: {
        validator: function (value, param) {
            return /^[\u0391-\uFFE5]+$/.test(value);
        },
        message: '请输入汉字'
    },
    ZIP: {
        validator: function (value, param) {
            return /^[1-9]\d{5}$/.test(value);
        },
        message: '邮政编码不存在'
    },
    QQ: {
        validator: function (value, param) {
            return /^[1-9]\d{4,10}$/.test(value);
        },
        message: 'QQ号码不正确'
    },
    mobile: {
        validator: function (value, param) {
            return /(^[0-9]{3,4}\-[0-9]{7,8}$)|(^0{0,1}18[0-9]{9}$)|(^0{0,1}1[3-5][0-9]{9}$)/.test(value);
        },
        message: '手机号码不正确'
    },
    loginName: {
        validator: function (value, param) {
            return /^[\u0391-\uFFE5\w]+$/.test(value);
        },
        message: '登录名称只允许汉字、英文字母、数字及下划线。'
    },
    safepass: {
        validator: function (value, param) {
            return safePassword(value);
        },
        message: '密码由字母和数字组成，至少6位'
    },
    equalTo: {
        validator: function (value, param) {
            return value == $(param[0]).val();
        },
        message: '两次输入的字符不一至'
    },
    number: {
        validator: function (value, param) {
            return /^\d+$/.test(value);
        },
        message: '请输入数字'
    },
    numberFloat : {
    	validator : function(value,param){
    		return /^((([1-9]{1}[0-9]{0,100})|(0{1}))(\.\d{1,3})?)$/.test(value);
	    },
	    message: '请输入数字'
    },
    numberDouble : {
    	validator : function(value,param){
    		return /^((([1-9]{1}[0-9]{0,4})|(0{1}))(\.\d{1,2})?)$/.test(value);
	    },
	    message: '请输入数字'
    },
    numberFloatXY : {
    	validator : function(value,param){
    		return /^(([1-9]{1}[0-9]{1,2})\.\d{6,8}?)$/.test(value);
	    },
	    message: '请输入数字'
    },
    numberTwo : {
    	validator : function(value,param){
    		return /^(-|\+)?\d+$/.test(value);
	    },
	    message: '请输入数字（正负数均可）'
    },
    numberFloatTwo : {
    	validator : function(value,param){
    		return /^((([1-9]{1}[0-9]{0,100})|(0{1}))(\.\d{1,8})?)$/.test(value);
	    },
	    message: '请输入数字'
    },
    idcard: {
        validator: function (value, param) {
            return idCard(value);
        },
        message:'请输入正确的身份证号码'
    },
    maxLength: {   
        validator: function(value, param){   
            return value.length <= param[0];   
        },   
        message: '长度过长'  
    },
    max : {
    	validator: function(value, param){   
            return value > param[0];   
        },   
        message: '数值过大'
    },
    Cpai: {
        validator: function (value, param) {
            return /^[\u4e00-\u9fa5]{1}[A-Z]{1}[A-Z_0-9]{5}$/.test(value);
        },
        message: '请输入正确的车牌号（字母大写）'
    },
    whlyz: {   
    	validator: function(value, param){   
    		return value >= 0 && value <=100;   
    	},   
    	message: '请输入一个0~100之间的数字以充当完好率。'  
    },
    email:{
    	validator: function (value, param) {
    		return /^(\w)+(\.\w+)*@(\w)+((\.\w{2,3}){1,3})$/.test(value);
    	},
    	message:'请输入正确Email'
    }

});
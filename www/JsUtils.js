function JsUtils(){

}

JsUtils.prototype.base64Encode=function(content,callback,fail){

    var t=new Date().getTime();
    cordova.exec(onSuccess, onFailed, "JsUtils", "base64Encode", [content]);

    function onSuccess(msg){
        trace("base64Encode onSuccess:");
        trace("spent time:"+(new Date().getTime()-t));
        if(callback!=null) callback(msg);
    }

    function onFailed(msg){
        trace("base64Encode   onFailed:"+msg);
        if(fail!=null) fail(msg);
    }

}

JsUtils.prototype.base64Decode=function(content,callback,fail){

    var t=new Date().getTime();
    cordova.exec(onSuccess, onFailed, "JsUtils", "base64Decode", [content]);

    function onSuccess(msg){
        trace("base64Decode onSuccess:");
        trace("spent time:"+(new Date().getTime()-t));
        if(callback!=null) callback(msg);
    }

    function onFailed(msg){
        trace("base64Decode   onFailed:"+msg);
        if(fail!=null) fail(msg);
    }

}
module.exports=JsUtils;
function JsUtils(){

}

JsUtils.base64Encode=function(content,callback,fail){

    var t=new Date().getTime();
    cordova.exec(onSuccess, onFailed, "JsUtils", "base64Encode", [content]);

    function onSuccess(msg){
       
        if(callback!=null) callback(msg);
    }

    function onFailed(msg){
        
        if(fail!=null) fail(msg);
    }

}

JsUtils.base64Decode=function(content,callback,fail){

    cordova.exec(onSuccess, onFailed, "JsUtils", "base64Decode", [content]);

    function onSuccess(msg){
      
        if(callback!=null) callback(msg);
    }

    function onFailed(msg){
       
        if(fail!=null) fail(msg);
    }

}
module.exports=JsUtils;
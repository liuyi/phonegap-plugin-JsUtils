package com.ourbrander.pgPlugin;

import java.io.UnsupportedEncodingException;

 
 
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;
 

import android.util.Base64;

public class JsUtils extends CordovaPlugin {
	
	JsUtils instance=this;
	JSONArray args=null;
	@Override
	public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
		this.args=args;
		if(action.equals("base64Encode")){
		
			 //
			
			 cordova.getThreadPool().execute(new Runnable() {
		            public void run() {
		            	try {
							instance.base64Encode(instance.args.getString(0),callbackContext);
						} catch (JSONException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							
						}
		               // callbackContext.success(); // Thread-safe.
		            }
		        });
		        return true;
			 
		}else if(action.equals("base64Decode")){
			 cordova.getThreadPool().execute(new Runnable() {
		            public void run() {
		            	try {
							instance.base64Decode(instance.args.getString(0),callbackContext);
						} catch (JSONException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							
						}
		               // callbackContext.success(); // Thread-safe.
		            }
		        });
		        return true;
		}
		
		 
	    return false;
	}
	
	public void base64Encode(String content, CallbackContext callbackContext){
		
		String encodeContent=Base64.encodeToString(content.getBytes(), Base64.NO_WRAP);
		callbackContext.success(encodeContent);
		/*
		JSONObject jsonData = new JSONObject();
		try {
			jsonData.put("data", encodeContent);
			PluginResult result = new PluginResult(PluginResult.Status.OK,jsonData);
			//result.setKeepCallback(true);
			callbackContext.sendPluginResult(result);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

		
	}
	
	
public void base64Decode(String content, CallbackContext callbackContext){
		
		String decodeContent="";
		byte[] b=Base64.decode(content.getBytes(),Base64.NO_WRAP);
		try {
			decodeContent=new String(b, "UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			decodeContent="";
			e1.printStackTrace();
		}
		//JSONObject jsonData = new JSONObject();
		//try {
			//jsonData.put("data", decodeContent);
			//PluginResult result = new PluginResult(PluginResult.Status.OK,jsonData);
			//result.setKeepCallback(true);
			callbackContext.success(decodeContent);
		//} catch (JSONException e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
		//}

		
	}
}

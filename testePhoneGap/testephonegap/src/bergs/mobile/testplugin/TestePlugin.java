package bergs.mobile.testplugin;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

//import com.phonegap.*;
//import android.os.Bundle;

import com.phonegap.api.Plugin;
import com.phonegap.api.PluginResult;

public class TestePlugin extends Plugin {	
	public static final int REQUEST_CODE = 0x0ba7c0de;

	public String callback;

	/**
	 * Constructor.
	 */
	public TestePlugin() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * Executes the request and returns PluginResult.
	 *
	 * @param action        The action to execute.
	 * @param args          JSONArray of arguments for the plugin.
	 * @param callbackId    The callback id used when calling back into JavaScript.
	 * @return              A PluginResult object with a status and message.
	 */	
	 public PluginResult execute(String action, JSONArray args, String callbackId) {
		 this.callback = callbackId;

		 Integer arg1;
		 Integer arg2;
		 
		 // Valida Argumentos da Operação Aritmética
		 JSONObject obj = args.optJSONObject(0);
         if (obj != null) {
        	 arg1 = obj.optInt("arg1");
             arg2 = obj.optInt("arg2");	                
             	                
             if (arg1 == null || arg2 == null) {
            	 return new PluginResult(PluginResult.Status.ERROR, "Argumentos não definidos.");                                            
             }	                	                               
         } else {
        	 return new PluginResult(PluginResult.Status.ERROR, "Argumentos não definidos.");                    
         }
		 
         // Seleciona Operação a ser Realizada
         JSONObject objResult = new JSONObject();               	   
	     if (action.equals("add")) {   	 
             try {
            	 objResult.put("result", arg1+arg2);
             } catch(JSONException e) {
            	 return new PluginResult(PluginResult.Status.JSON_EXCEPTION);
             }
             return new PluginResult(PluginResult.Status.OK, objResult);             
	     }
	     else if (action.equals("sub")) {	 
	    	 try {
            	 objResult.put("result", arg1-arg2);
             } catch(JSONException e) {
            	 return new PluginResult(PluginResult.Status.JSON_EXCEPTION);
             }
             return new PluginResult(PluginResult.Status.OK, objResult);
         } else {
	         return new PluginResult(PluginResult.Status.INVALID_ACTION);
	     }	     	     
	 }   
}

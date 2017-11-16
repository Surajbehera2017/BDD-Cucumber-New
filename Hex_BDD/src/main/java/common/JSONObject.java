package common;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONObject extends org.json.simple.JSONObject
{
	private org.json.simple.JSONObject obj;
	
	public JSONObject(String objectString)
	{
		try { obj=(org.json.simple.JSONObject) new JSONParser().parse(objectString); }
		catch(ParseException pe){ System.out.println("error occured while creating object."); }
	}
	public JSONObject(){ obj=new JSONObject("{}"); }
	public JSONObject(org.json.simple.JSONObject object){ obj=object; }	
	public JSONObject(Object object){ obj=(org.json.simple.JSONObject) object; }
	
	public JSONObject put(String key,String value){ obj.put(key,value); return this; }
	public JSONObject put(String key,int value){ obj.put(key,value); return this; }
	public JSONObject put(String key,boolean value){ obj.put(key,value); return this; }
    public JSONObject put(String key,JSONObject value)
    {
        obj.put(key,value);
        System.out.println("onset : "+obj.get(key));
        return this; }
	public JSONObject put(String key,Object value){ obj.put(key,value); return this; }
	
	public String getS(String key)
	{
		Object o=obj.get(key);
		if(o!=null)
			return o.toString();
		else
			return null;
	}
	
	public Integer getI(String key)
	{
		String s=getS(key);
		if(s!=null)
			return Integer.parseInt(s);
		else
			return null;
	}
	
	public Boolean getB(String key)
	{
		String s=getS(key);
		if(s!=null)
			return Boolean.parseBoolean(s);
		else
			return null;
	}

	public JSONObject get(String key){ return new JSONObject(obj.get(key)); }

	@Override
	public String toString() {
	    System.out.println("ts called");
		return this.toJSONString();
	}
}

/**
 * 
 */

function createXHR()
{
	if(window.XMLHttpRequest)
	{
		return new XMLHttpRequest();
	}
	else if(window.ActiveXObject)
	{
		return new ActiveXObject("Microsoft.XMLHTTP"); 
	}
};

var xhr = null;
var arr = new Array();

function sendRequest(method,url,callback,params)
{					// ("GET","getResponse.txt",fromServer,null)

	//alert("TEST");
	
	var httpMethod = method.toUpperCase();
	if(httpMethod!="GET" && httpMethod!="POST")
	{
		httpMethod="GET";
	}
	
	var httpParams = (params==null || params=="") ? null : params;
	var httpUrl = url;
	
	if(httpMethod=="GET" && httpParams!=null)
	{
		httpUrl+="?"+httpParams;
	}
	
//	arr.push("전송방식"+httpMethod);
//	arr.push("서버파일"+httpUrl);
//	arr.push("데이터"+httpParams);
//	alert(arr.join("\n"));
	
	xhr = createXHR();
	
	xhr.open(httpMethod,httpUrl,true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send(httpMethod=="POST"?httpParams:null);
	
	xhr.onreadystatechange=callback;
	
};
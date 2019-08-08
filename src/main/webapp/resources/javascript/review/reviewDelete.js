/**
 * 
 */

function deleteToServer(bunho,root)
{
	//alert(bunho+"\n"+root);
	var url = root+"/reply/replyDelete.do";
	var params = "bunho="+bunho;
	
	sendRequest("POST",url,deleteFromServer,params);
}

function deleteFromServer()
{
	if(xhr.readyState==4 && xhr.status==200)
	{
		//alert(xhr.responseText);
		deleteReplyProcess();
	}
}

function deleteReplyProcess()
{
	var bunho=xhr.responseText;
	
	var listAllDiv = document.getElementById("listAllDiv");
	var deleteNode = document.getElementById(bunho);
	
	listAllDiv.removeChild(deleteNode);
}
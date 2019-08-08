/**
 * 
 */

var check = null;
var root = null;
var bunho = null;

function selectToServer(inputBunho,inputRoot)
{
	bunho = inputBunho;
	root = inputRoot;
	var url = root+"/reply/replySelect.do";
	var params = "bunho="+bunho;
	//alert("url: "+url+" "+"params: "+params);
	sendRequest("GET",url,selectFromServer,params);
}

function selectFromServer()
{
	if(xhr.readyState==4 && xhr.status==200)
	{
		//alert(xhr.responseText);
		selectProcess();
	}
}

function selectProcess()
{
	var str = xhr.responseText.split(",");
	var bunho = str[0].trim();
	var selectReply = str[1].trim();
	
	var listAllDiv = document.getElementById("listAllDiv");
	
	if(check==true)
	{
		listAllDiv.removeChild(document.getElementById("selectNode"));
		check=false;
	}
	
	var divNode = document.createElement("div");
	divNode.className = "replyDiv";
	divNode.id="selectNode";
	
	var inputNode = document.createElement("input");
	inputNode.type="text";
	inputNode.value=selectReply;
	inputNode.setAttribute("id", "newReply");
	
	var buttonNode = document.createElement("input");
	buttonNode.type="button";
	buttonNode.value="수정";
	buttonNode.setAttribute("id", "updatebutton");
	buttonNode.setAttribute("onClick", "UpdateToServer("+bunho+")");
	
	var cancelNode = document.createElement("input");
	cancelNode.type="button";
	cancelNode.value="취소";
	cancelNode.setAttribute("onClick", "updateCancel()");
	
	divNode.appendChild(inputNode);
	divNode.appendChild(buttonNode);
	divNode.appendChild(cancelNode);
	
	var next = document.getElementById(bunho).nextSibling;
	var selectNode = getNextSibling(next);
	
	listAllDiv.insertBefore(divNode, selectNode);
	check = true;
	
}

function updateCancel() 
{
	var listAllDiv = document.getElementById("listAllDiv");
	
	listAllDiv.removeChild(document.getElementById("selectNode"));
	check=false;
	
}

function UpdateToServer()
{
	var newReply = document.getElementById("newReply").value;
	var url = root+"/reply/replyUpdate.do"
	var params = "newReply="+newReply+"&bunho="+bunho;
	
	if(newReply==null || newReply=="")
	{
		alert("댓글 내용을 입력하세요");
		document.getElementById("newReply").focus();
		return false;
	}
	
	//alert(newReply+","+url+","+params);
	
	sendRequest("GET", url, UpdateFromServer, params);
}

function UpdateFromServer()
{
	if(xhr.readyState==4 && xhr.status==200)
	{
		//alert(xhr.responseText);
		updateProcess();
	}
}

function updateProcess()
{
	var newReply = xhr.responseText;
	
	var listAllDiv = document.getElementById("listAllDiv");
	
	listAllDiv.removeChild(document.getElementById("selectNode"));
	check=false;
	
	var updateNode = document.getElementById(bunho);
	var updateSpanNode = updateNode.getElementsByTagName("span");
	updateSpanNode[1].innerHTML=newReply;
	
}

function getNextSibling(node)
{
	if(node.nodeType==1){
		return node;
	}
	if(node.nodeType==3){
		return node.nextSibling;
	}
}


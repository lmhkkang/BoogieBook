/**
 *  쓰고, 읽기
 */

var root=null;
var rate=null;
function writeToServer(requestRoot,id,book_id)
{
	root=requestRoot;
	//alert("OK");

	root = requestRoot;
	var review_content = document.getElementById("review_content").value;
	
	radio_chk();
	
	//alert(review_content+","+rate);
	
	if(review_content==null || review_content=="")
	{
		alert("리뷰 내용을 입력하세요");
		document.getElementById("review_content").focus();
		return false;
	}
	
	if(id==null || id=="")
	{
		alert("로그인 후 이용해주세요");
		return false;
	}
	
	var url = root+"/review/reviewWrite.do";
	var params = "rate="+rate+"&review_content="+review_content+"&id="+id+"&book_id="+book_id;
	
	//alert(url+"\n"+params);
	
	sendRequest("GET",url,writeFromServer,params);
}

function writeFromServer()
{
	if(xhr.readyState==4 && xhr.status==200)
	{
		writeReviewProcess();
	}
}


function writeReviewProcess()
{
	var result = xhr.responseText.split(",");
	var id = result[0].trim();
	var book_id = result[1].trim();
	var content = result[2].trim();
	var rate = result[3].trim();
	var date = new Date();
	date = date.format('yyyy-MM-dd HH:mm:ss');
	
	//alert(id+","+book_id+","+content+","+rate+","+date);
	
	document.getElementById("review_content").value="";
	
	var listDiv = document.getElementById("listAllDiv");
	
	var review_list_form = document.createElement("div");
	review_list_form.className = "review_list_form";
	
	var review_list_top = document.createElement("div");
	review_list_top.className = "review_list_top";
	
	var review_list_id = document.createElement("div");
	review_list_id.className = "reviw_list_id";
	review_list_id.innerHTML=id;
	review_list_id.setAttribute("style","font-size: 1.1em;");
	
	var reviw_list_date = document.createElement("div");
	reviw_list_date.className = "reviw_list_date";
	reviw_list_date.innerHTML=date;
	reviw_list_date.setAttribute("style","color:#CCCCCC; font-size: 0.9em;");
	
	var reviw_list_rate = document.createElement("div");
	reviw_list_rate.className = "reviw_list_rate";
	reviw_list_rate.innerHTML=rate;
	
	var rate_img = document.createElement("img");
	rate_img.setAttribute("src",root+"/resources/images/mark/"+rate+".PNG");
	
	reviw_list_rate.insertBefore(rate_img,reviw_list_rate.childNodes[0]);

	review_list_top.appendChild(review_list_id);
	review_list_top.appendChild(reviw_list_date);
	review_list_top.appendChild(reviw_list_rate);
	
	
	var review_list_bottom = document.createElement("div");
	review_list_bottom.className = "review_list_bottom";
	
	var review_list_content = document.createElement("div");
	review_list_content.className = "review_list_content";
	review_list_content.innerHTML=content;
	
	review_list_bottom.appendChild(review_list_content);	
	
	review_list_form.appendChild(review_list_top);
	review_list_form.appendChild(review_list_bottom);
	
	
	listDiv.insertBefore(review_list_form,listDiv.childNodes[0]);
	
	
}

function radio_chk() {
    //라디오 버튼 Name 가져오기
    var radio_btn = document.getElementsByName("rate_group");

    //라디오 버튼이 체크되었나 확인하기 위한 변수
    var radio_btn_check = 0;
    for(var i = 0; i<radio_btn.length; i++){
        //만약 라디오 버튼이 체크가 되어있다면 true
        if(radio_btn[i].checked==true){
            //라디오 버튼 값
            //alert(radio_btn[i].value);
            rate = radio_btn[i].value;
            radio_btn_check++;
        }
    }
    
    if(radio_btn_check==0){
        alert("평점을 선택해주세요");
        return;
    }
}

Date.prototype.format = function (f) {

    if (!this.valueOf()) return " ";



    var weekKorName = ["일요일", "월요일", "화요일", "수요일", "목요일", "금요일", "토요일"];

    var weekKorShortName = ["일", "월", "화", "수", "목", "금", "토"];

    var weekEngName = ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"];

    var weekEngShortName = ["Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"];

    var d = this;



    return f.replace(/(yyyy|yy|MM|dd|KS|KL|ES|EL|HH|hh|mm|ss|a\/p)/gi, function ($1) {

        switch ($1) {

            case "yyyy": return d.getFullYear(); // 년 (4자리)

            case "yy": return (d.getFullYear() % 1000).zf(2); // 년 (2자리)

            case "MM": return (d.getMonth() + 1).zf(2); // 월 (2자리)

            case "dd": return d.getDate().zf(2); // 일 (2자리)

            case "KS": return weekKorShortName[d.getDay()]; // 요일 (짧은 한글)

            case "KL": return weekKorName[d.getDay()]; // 요일 (긴 한글)

            case "ES": return weekEngShortName[d.getDay()]; // 요일 (짧은 영어)

            case "EL": return weekEngName[d.getDay()]; // 요일 (긴 영어)

            case "HH": return d.getHours().zf(2); // 시간 (24시간 기준, 2자리)

            case "hh": return ((h = d.getHours() % 12) ? h : 12).zf(2); // 시간 (12시간 기준, 2자리)

            case "mm": return d.getMinutes().zf(2); // 분 (2자리)

            case "ss": return d.getSeconds().zf(2); // 초 (2자리)

            case "a/p": return d.getHours() < 12 ? "오전" : "오후"; // 오전/오후 구분

            default: return $1;

        }

    });

};



String.prototype.string = function (len) { var s = '', i = 0; while (i++ < len) { s += this; } return s; };

String.prototype.zf = function (len) { return "0".string(len - this.length) + this; };

Number.prototype.zf = function (len) { return this.toString().zf(len); };

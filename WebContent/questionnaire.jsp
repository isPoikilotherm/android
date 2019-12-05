<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.List"%>
<%@page import="yang.vo.OneselectVO"%>
<%@page import="yang.vo.ManyselectVO"%>
<%@page import="yang.vo.ScoringVO"%>
<%@page import="yang.vo.ShortanswerVO"%>
	<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<title>答题页面</title>
		<script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js" type="text/javascript"></script>
	</head>
	<body style="background-color: green;">
		<div id="headContent" style=" height: 100px;">
	
		<center id="questionName">${name}</center>
		</br>
		<span id="questionDiretion">${direction }</span>
		</br>
		
		<span style="float: right;";>${time}</span>	
		</div>
		<div
		style="height: 20px;width: 100%">
	</div>
		<!-- <div id="time"
			style=" width: 200px; height: 60px; float: right;">
				
		</div> -->
		<div
		style="height: 20px;width: 100%">
	</div>

	<div id="bodyContent"
		style="margin-left: 5%; width: 100%; height: auto;">
		<div id="oneSelect"
		style=" width: 100%;">
			<div id="oneSelectName"
			style=" width: 100%;">
			
			<c:if test="${oVos_size!=0}">
				<span>单选题</span>
				</c:if>
				
			</div>
			<div id="oneSelectContent">			
				<table>				
					<%
						int i = 0;
					%>
					<c:forEach items="${list_oVos}" var="one">
					<%
						i++;
					%>
					<tr>
						<td><%=i%> ${one.question_name}</td>
					</tr>
					
					<tr>
						<td><label><input id="oneselect" name="${one.question_id}" type="radio" value="a" />A:
						</label>  ${one.option_a}</td>
					</tr>
					<tr>
						<td><label><input  id="oneselect" name="${one.question_id}" type="radio" value="b" />B:
						</label>  ${one.option_b}</td>
					</tr>
					<tr>
						<td><label><input  id="oneselect" name="${one.question_id}" type="radio" value="c" />C:
						</label> ${one.option_c}</td>
					</tr>
					<tr>
						<td><label><input  id="oneselect" name="${one.question_id}" type="radio" value="d" />D:
						</label> ${one.option_d}</td>
					</tr>				
					</c:forEach>
				</table>
			</div>
		</div>



		 <div id="manySelect">
			<div id="manySelectName">
			
			<c:if test="${mVos_size!=0}">
				<span>多选题</span>
				</c:if>
				
			</div>
			
			<div id="manySelectContent">
				<table>					
					<%
						int n = 0;
					%>
					<c:forEach items="${list_mVos}" var="many">
					<%
						n++;
					%>					
					<tr>					
						<td><%=n%> ${many.question_name }</td>
					</tr>
					<tr>
						<td><label><input name="${many.question_id}" type="checkbox" value="a" />A:
						</label>${many.option_a}</td>
					</tr>
					<tr>
						<td><label><input name="${many.question_id}"  type="checkbox" value="b" />B:
						</label> ${many.option_b}</td>
					</tr>
					<tr>
						<td><label><input name="${many.question_id}"  type="checkbox" value="c" />C:
						</label> ${many.option_c}</td>
					</tr>
					<tr>
						<td><label><input name="${many.question_id}" type="checkbox" value="d" />D:
						</label> ${many.option_d}</td>
					</tr>
					</c:forEach>
				</table>
			</div>

		</div>
		
		<div id="scoring">
			<div id="scoringName">
			<c:if test="${scVos_size!=0}">
				<span>打分題</span>
				</c:if>
				
			</div>
			<div id="scoringContent">
				<table>
					
					<%
						int a = 0;
					%>
					<c:forEach items="${list_scVos}" var="scoring">
					<%
						a++;
					%>
					
					<tr>
						<td><%=a%> ${scoring.question_name }</td>
					</tr>
					<tr>
						<td><label><input id="scoring" name="${scoring.question_id}" type="radio" value="1" />A:
						</label> 1分</td>
					</tr>
					<tr>
						<td><label><input id="scoring" name="${scoring.question_id}" type="radio" value="2" />B:
						</label> 2分</td>
					</tr>
					<tr>
						<td><label><input id="scoring" name="${scoring.question_id}" type="radio" value="3" />C:
						</label> 3分</td>
					</tr>
					<tr>
						<td><label><input id="scoring" name="${scoring.question_id}" type="radio" value="4" />D:
						</label> 4分</td>
					</tr>
					<tr>
						<td><label><input  id="scoring" name="${scoring.question_id}" type="radio" value="5" />D:
						</label> 5分</td>
					</tr>
					
					</c:forEach>
				</table>
			</div>
		</div>
		
		
		<div id="shortanswer">
			<div id="shortanswerName">
			<c:if test="${shVos_size!=0}">
				<span>简答題</span>
				</c:if>
				
			</div>
			<div id="shortanswerContent">
				<table>
					
					<%
						int b = 0;
					
					%>
					<c:forEach items="${list_shVos}" var="shortanswer">
					<%
						b++;
					%>
					
					<tr>
						<td><%=b%> ${shortanswer.question_name }</td>
					</tr>
					<tr>
						<td><textarea id="${shortanswer.question_id}" name="textarea" > </textarea></td>
					</tr>
					
					</c:forEach>
				</table>
			</div>
		</div> 
		
		
		
	</div>
	<div  style="margin-left: 100px; width: auto; height: auto;">
	<button onclick="sub()">提 交</button>
	</div>
	

	</body>
	<script type="text/javascript">
	
	var data =[]
	var data1 =[]
	var data2=[]
	var data3=[]
		$(document).ready(function() {
			
			$('input[id=oneselect]').click(function() {
				var questionId = $(this)[0].name;
				var answer = $(this).val();
				var question = {
					questionId:questionId,
					answer:answer
				}
				if(data.length!=0){
					
					for(var i = 0 ; i<data.length;i++){
						if(data[i].questionId == questionId){
							data[i].answer = answer;
							//console.log(data)
							return;
						}else if(i!=data.length-1){
							continue;
						}else{
							data.push(question);
							
						}
					}
				}else{
					data.push(question);
				}
				//console.log(data)
			});
		});
		
		
		$(document).ready(function() {
			
			$('input[id=scoring]').click(function() {
				var questionId = $(this)[0].name;
				var answer = $(this).val();
				var question = {
					questionId:questionId,
					answer:answer
				}
				if(data1.length!=0){
					for(var i = 0 ; i<data1.length;i++){
						if(data1[i].questionId == questionId){						
							data1[i].answer = answer;
							//console.log(data1)
							return;
						}else if(i!=data1.length-1){
							continue;
						}else{
							data1.push(question);							
						}
					}
				}else{
					data1.push(question);
				}
				
			});
		});
		
		$('input[type = checkbox]').click(function() {
			//console.log($(this))
			var name = $(this)[0].name;
			var obj=document.getElementsByName(name);
			var check_val=[];
			for(k in obj){
				if(obj[k].checked)
					check_val.push(obj[k].value);
			}						
			var question={
					questionId:name,
					answer:check_val
			}
			if(data2.length!=0){
				for(var i = 0; i<data2.length;i++){
					if(data2[i].questionId == name){						
						data2[i].answer = check_val;
						//console.log(data2)
						return;
					}else if(i!=data2.length-1){
						continue;
					}else{
						data2.push(question);							
					}
				}
				}else{
					data2.push(question);
				}
			
			
		});
		
		
		
		 $('textarea').on('input propertychange',function(){
	            var questionId = $(this)[0].id;
	            var answer = $(this).val();
	            var question = {
						questionId:questionId,
						answer:answer
					}
	            if(data3.length!=0){
					for(var i = 0 ; i<data3.length;i++){
						if(data3[i].questionId == questionId){						
							data3[i].answer = answer;
							//console.log(data1)
							return;
						}else if(i!=data3.length-1){
							continue;
						}else{
							data3.push(question);							
						}
					}
				}else{
					data3.push(question);
				}
	            console.log(data3)
	            
		 });
		
		
		
		function sub(){
			 
			var questionnaire={
				oneselect:data,
				manyselect:data2,
				scoring:data1,
				shortanswer:data3	
			}
			
			 
			if (data.length<${oVos_size}) {
				alert("您还有单选题未作答，请全部作答后再提交，谢谢！");				
			}else if(data2.length<${mVos_size}) {
				alert("您还有多选题未作答，请全部作答后再提交，谢谢！");	
			}else if (data1.length<${scVos_size}) {
				alert("您还有打分题未作答，请全部作答后再提交，谢谢！");	
			}else if (data3.length<${shVos_size}) {
				alert("您还有简答题未作答，请全部作答后再提交，谢谢！");	
			}else {
				$.ajax({
		             type: "GET",
		             url: "saveresult",
		             data:{"data":JSON.stringify(questionnaire)},
		             dataType: "json",
		             success: function(data){
		                  if (data.stats=="ok"){
		                	 window.location.href="saveproject.jsp";
		                  }else{
		                	  alert("提交失败");
		                  }
		             }
		        
		         }); 
			}
	     
		}
		
		
		
	</script>
</html>




















</html>
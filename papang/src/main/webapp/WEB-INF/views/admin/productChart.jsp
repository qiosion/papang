<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<script src="https://www.gstatic.com/charts/loader.js"></script>

<script>
	//구글 시각화 API를 로딩하는 메소드

	google.charts.load('current', {
		packages : [ 'corechart' ]
	});

	// 구글 시각화 API가 로딩이 완료되면,

	// 인자로 전달된 콜백함수를 내부적으로 호출하여 차트를 그리는 메소드

	// 화면이 실행될때 함께 실행된다.

	google.charts.setOnLoadCallback(columnChart1);

	// 묶은 세로 막대형 차트 1

	function columnChart1() {

		// 버튼 클릭 시 ajax를 사용하여 서버로부터 json 배열 객체를 가져왔다고 가정함

		var arr = [ [ '월', '매출액' ] ];

		$.ajax({
			url : '../orderinfoselect',
			type : 'GET',
			//contentType:'application/json;charset=utf-8',
			dataType : 'json',
			async : false,
			error : function(xhr, status, msg) {
				alert("상태값 :" + status + " Http에러메시지 :" + msg);
			},
			success : function(data) {
				$.each(data, function(idx, val) {
					var a = [];
					a.push(val.order_date);
					a.push(val.order_sum * 1);
					arr.push(a);
				})

			}
		});

		// 실 데이터를 가진 데이터테이블 객체를 반환하는 메소드

		var dataTable = google.visualization.arrayToDataTable(arr);

		// 옵션객체 준비

		var options = {

			title : '장터 월별 매출현황',

			hAxis : {

				title : '',

				titleTextStyle : {

					color : 'red'

				}

			}

		};

		// 차트를 그릴 영역인 div 객체를 가져옴

		var objDiv = document.getElementById('column_chart_div1');

		// 인자로 전달한 div 객체의 영역에 컬럼차트를 그릴수 있는 차트객체를 반환

		var chart = new google.visualization.ColumnChart(objDiv);

		// 차트객체에 데이터테이블과 옵션 객체를 인자로 전달하여 차트 그리는 메소드

		chart.draw(dataTable, options);

	} // drawColumnChart1()의 끝

	// 버튼 동작

	$(document).ready(function() {

		columnChartlist();

	});
	function columnChartlist() {
		$.ajax({
			url : '../orderinfoselect2',
			type : 'GET',
			//contentType:'application/json;charset=utf-8',
			dataType : 'json',
			async : false,
			error : function(xhr, status, msg) {
				alert("상태값 :" + status + " Http에러메시지 :" + msg);
			},
			success : columnChartlistResult
		});
	}

	function columnChartlistResult(data) {

		$("#dataTable tbody").empty();
		$.each(data, function(idx, item) {
			$('<tr>').append($('<td>').html(item.order_date)).append(
					$('<td>').html(item.order_sum))
					.appendTo('#dataTable tbody');
		});

		$('#dataTable').DataTable();
	}
</script>
<h1 class="mt-4">장터 매출 현황</h1>
<div id="column_chart_div1" style="width: 100%; height: 500px;"></div>

<div class="card mb-4">
	<div class="card-header">
		<i class="fas fa-table mr-1"></i> 일별 매출 현황
	</div>
	<div class="card-body">

		<div class="table-responsive">

			<table class="table table-bordered" id="dataTable" width="100%"
				cellspacing="0">
				<thead>
					<tr>
						<th>거래 일</th>
						<th>매출 합계</th>
					</tr>
				</thead>
				<tbody></tbody>
			</table>
		</div>
	</div>
</div>


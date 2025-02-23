package co.company.papang.impl;

import java.util.List;
import java.util.Map;

import co.company.papang.vo.AlarmVO;
import co.company.papang.vo.BannerVO;
import co.company.papang.vo.MemberVO;
import co.company.papang.vo.NqVO;
import co.company.papang.vo.Order_infoVO;
import co.company.papang.vo.ProductVO;
import co.company.papang.vo.ReportVO;
import co.company.papang.vo.Report_info;
import co.company.papang.vo.SitterVO;
import co.company.papang.vo.Sitter_monthVO;
import co.company.papang.vo.Sitter_revVO3;
import co.company.papang.vo.WarehousingVO;

public interface JyMapper {
	// 怨듭��벑濡�
	public int insertNq(NqVO nqVO);

	// 怨듭� �쟾泥� 議고쉶
	public List<NqVO> getListNq(NqVO nqVO);

	// �떒嫄댁“�쉶
	public NqVO getNq(NqVO nqVO);

	// �닔�젙
	public int updateNq(NqVO vo);

	// �궘�젣
	public int deleteNq(NqVO vo);

	// 회원 전체 조회
	public List<Map<String,Object>> getListMember(MemberVO vo);

	// 회원 권한 수정
	public int updateMember(MemberVO vo);

	// 맴버 탈퇴
	public int deleteMember(MemberVO vo);

	// 시터 등록
	public int insertSitter(SitterVO vo);

	// 시터 삭제
	public int deleteSitter(SitterVO vo);

	// 시터 단건 조회
	public SitterVO getSitter(SitterVO vo);

	// 시터 수정
	public int updateSitter(SitterVO vo);

	// 시터권한 알림
	public int insertSitterAlarm(MemberVO vo);

	// 배너등록
	public int insertBanner(BannerVO vo);

	// 배너조회
	public List<BannerVO> getbannerlist(BannerVO vo);

	// 배너 단건
	public BannerVO getBanner(BannerVO vo);

	// 배너 수정
	public int updateBanner(BannerVO vo);
	
	//배너 삭제
	public int deleteBanner(BannerVO vo);
	
	//배너 상태 수정
	public int updateBannerstatus(BannerVO vo);
	
	//상품 이름,번호
	public List<ProductVO> getprono(ProductVO vo);
	
	//입고 등록
	public int Wareinsert(WarehousingVO vo);
	
	//입출고 조회
	public List<Map<String,Object>> warehousinglist(WarehousingVO vo);
	
	//상품 수량 입고 수정
	public int updateprocnt(WarehousingVO vo);
	
	//알람 갯수
	public List<AlarmVO> getacount(AlarmVO vo);
	
	//알람 읽음 처리
	public int updateAstatus(AlarmVO vo);
	
	//신고 등록
	public int insertReport(ReportVO vo);
	
	//신고 조회
	public List<ReportVO> reportselect(ReportVO vo);
	
	//제재내역 조회
	public List<Map<String,Object>> reportinfoselect(Report_info vo); 
	
	//신고 단건 조회
	public List<Map<String,Object>> reportselectone(ReportVO vo);
	
	//제재 처리 등록
	public int reportinfoinsert(Report_info vo); 
	
	//멤버 활동정지 업데이트
	public int updatestatus(Report_info vo);
	
	//답변 업데이트
	public int updaterepoans(Report_info vo);
	
	//제재 알림 
	public int insertreportAlarm(Report_info vo);
	
	//월별 매출 현황 
	public List<Order_infoVO> orderinfoselect(Order_infoVO vo);
	
	//일별 매출 현황
	public List<Order_infoVO> orderinfoselect2(Order_infoVO vo);
	
	//시터 월별 매출 현황
	public List<Map<String,Object>> sitterinfoselect(Sitter_revVO3 vo);
	
	//시터 일별 매출 현황
	public List<Sitter_revVO3> sitterinfoselect2(Sitter_revVO3 vo);
	
	//성비 차트 
	public List<Map<String,Object>> gendercount();
	
	//월급 조회
 	public  List<Map<String,Object>> monthpay(Sitter_revVO3 vo);
 	
 	//월급 단건
 	public  List<Map<String,Object>> monthpayone(Sitter_revVO3 vo);
 	
 	//월급 주는거
 	public int monthinsert(Sitter_monthVO vo);
 	
 	//월금 알림
 	public int insertmonthAlarm(Sitter_monthVO vo);
 	
 	//월급 단건
 	public  List<Map<String,Object>> resultmonthpayone(Sitter_revVO3 vo);
 	
 	//총액
 	public String allsum();
 	
 	//월급날 조회
 	public String rownum();
 	
 	//월급날 수정
 	public int uppayday(SitterVO vo);
 	
 	//월급날 알림 등록
 	public int insertpayAlarm(SitterVO vo);
 	
 	public List<SitterVO> sit_mbr(SitterVO vo);
 	
}

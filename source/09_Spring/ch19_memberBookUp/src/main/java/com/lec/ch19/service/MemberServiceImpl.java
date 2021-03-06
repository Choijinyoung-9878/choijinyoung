package com.lec.ch19.service;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import com.lec.ch19.dao.MemberDao;
import com.lec.ch19.dto.Member;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDao memberDao;
	@Autowired
	private JavaMailSender mailSender;
	
	@Override
	public int idConfirm(String mid) {
		return memberDao.idConfirm(mid);
	}

	@Override
	public int joinMember(final Member member, HttpSession httpSession) {
		int result = memberDao.joinMember(member);
		if(result == 1) {
			httpSession.setAttribute("mid", member.getMid());  // 세션에 mid 추가
			MimeMessagePreparator message = new MimeMessagePreparator() {
				String content = "<div style=\"width:500px; margin:0 auto; text-align: center;\">\n" + 
						"	<h1 style=\"color:lightgreen;\">"+member.getMname()+" 님 회원가입 감사합니다.</h1>\n" + 
						"	<div>\n" + 
						"		<p>아무개 사이트에서만 쓰실 수 있는 감사쿠폰을 드립니다.</p>\n" + 
						"		<p>\n" + 
						"			<img src=\"http://localhost:8090/ch19/img/coupon.jpg\"/>\n" + 
						"		</p>\n" + 
						"	</div>\n" + 
						"	<div>\n" + 
						"		<p style=\"color:red;\">빨간 글씨 부분</p>\n" + 
						"		<p style=\"color:blue;\">파란 글씨 부분</p>\n" + 
						"		<img src=\"https://t1.daumcdn.net/daumtop_chanel/op/20200723055344399.png\">\n" + 
						"	</div>\n" + 
						"	<p>서울시 어떤구 XX로 00 **빌딩 402</p>\n" + 
						"</div>\n" + 
						"	";
				@Override
				public void prepare(MimeMessage mimeMessage) throws Exception {
					mimeMessage.setRecipient(Message.RecipientType.TO,new InternetAddress(member.getMmail()));
					mimeMessage.setFrom(new InternetAddress("chlwlsdud43@gmail.com"));
					mimeMessage.setSubject(member.getMname()+ " 님 회원가입 감사합니다.");
					mimeMessage.setText(content, "utf-8","html");
				}
			};
			mailSender.send(message);  // 메일 발송
		} 
		return result;
	}

	@Override
	public String loginCheck(String mid, String mpw, HttpSession httpSession) {
		String result = "로그인 성공";
		Member member = memberDao.getDetailMember(mid);
		if(member == null) {
			result = "유효하지 않은 아이디입니다";
		} else if( !mpw.equals(member.getMpw())) {
			result = "비밀번호를 확인해주세요";
		} else {
			httpSession.setAttribute("member", member);
			httpSession.setAttribute("mid", mid);
		}
		return result;
	}

	@Override
	public Member getDetailMember(String mid) {
		return memberDao.getDetailMember(mid);
	}

	@Override
	public int modifyMember(Member member) {
		return memberDao.modifyMember(member);
	}

}

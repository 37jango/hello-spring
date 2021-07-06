package hellow.hellospring.controller;

import hellow.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired //스프링 컨테이너에서
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}

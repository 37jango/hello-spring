package hellow.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController{

	@GetMapping("hello")
	public String hello (Model model) {
		model.addAttribute("data", "hello!!!");
		return "hello";
	}
		// 위의 return "hello"에서 hello
		// 'resources:templates/ + {ViewName} + .html로 바뀌게 됨
		// 즉, hello.html로 연결 가능케 함

	@GetMapping("hello-mvc")
	public String helloMvc(@RequestParam("name") String name, Model model) {
		model.addAttribute("name", name);
		return "hello-template";
	}

	//
	@GetMapping("hello-string")
	@ResponseBody
	public String helloString(@RequestParam("name") String name){
		return "hello " + name; // "hello spring" (if name == "spring")
		// 이 문자 그대로 내려간다 --> 소스를 보면 html tag가 없다.
	}

	@GetMapping("hello-api")
	@ResponseBody
	public Hello helloApi(@RequestParam("name") String name){
		Hello hello = new Hello();
		hello.setName(name);
		return hello;
		// JSON으로 넘기려면 @ResponseBody 어노테이션 추가 후 return으로
		// 객체를 넘기면 된다. -> {key : value}형태
	}

	static class Hello{
		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}
}
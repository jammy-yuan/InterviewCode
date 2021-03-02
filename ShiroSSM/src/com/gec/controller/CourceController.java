package com.gec.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller()
@RequestMapping("/Cource")
public class CourceController {
	
	//{ps} permisson: cource:viewAdd
	@RequestMapping(
		value="/viewAdd",
		produces="text/html;charset=UTF-8"
	)
	@ResponseBody
	//@RequiresPermissions("cource:viewAdd")
	public String viewAdd(){
		print();
		return getHTML("/Cource/viewAdd");
	}

	@RequestMapping(
		value="/viewList",
		produces="text/html;charset=UTF-8"
	)
	@ResponseBody
	//@RequiresPermissions("cource:viewList")
	public String viewList(){
		print();
		return getHTML("/Cource/viewList");
	}
	
	@RequestMapping(
		value="/viewInfo",
		produces="text/html;charset=UTF-8"
	)
	@ResponseBody
	//@RequiresPermissions("cource:viewInfo")
	public String viewInfo(){
		print();
		return getHTML("/Cource/viewInfo");
	}
	
	@RequestMapping(
		value="/delete",
		produces="text/html;charset=UTF-8"
	)
	@ResponseBody
	//@RequiresPermissions("cource:delete")
	public String delete(){
		print();
		return getHTML("/Cource/delete");
	}
	
	@RequestMapping(
		value="/save",
		produces="text/html;charset=UTF-8"
	)
	@ResponseBody
	//@RequiresPermissions("cource:save")
	public String save(){
		print();
		return getHTML("/Cource/save");
	}

	private void print() {
		System.out.println("{COURCE}");
	}

	private String getHTML(String title){
		String html = "<style>"+
		"body{ background:#333; color:#DDD; }"+
		"</style>";
		html += "<h1>"+ title +"</h1>";
		return html;
	}

}



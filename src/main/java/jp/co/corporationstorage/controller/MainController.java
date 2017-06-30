package jp.co.corporationstorage.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.corporationstorage.dto.FormDto;
import jp.co.corporationstorage.form.Form;


@Controller
public class MainController {

	private List<FormDto> messageList = new ArrayList<FormDto>();

	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public String TestMessage(Model model) {
		System.out.println("TestMessageは呼び出されてます");
		String testMessage = ("ConectionTest");
		model.addAttribute("message", testMessage);
		Form form = new Form();
		model.addAttribute("messageForm", form);
		return "message";
	}


	@RequestMapping(value = "/show", method = RequestMethod.POST)
	public String MessageList(@Valid @ModelAttribute Form form, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("title", "エラー");
			model.addAttribute("message", "以下のエラーを解決してちょ");
		}
		else {
			FormDto dto = new FormDto();
			BeanUtils.copyProperties(form, dto);
			messageList.add(dto);
			model.addAttribute("message", form.getName());
		}
		model.addAttribute("messageList", messageList);
		model.addAttribute("messageForm", form);
		return "message";
	}
}

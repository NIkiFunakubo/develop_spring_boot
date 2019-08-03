package com.example.powerwords.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ErrorController {

	private static Logger logger = LoggerFactory.getLogger(ErrorController.class);
	
	@ExceptionHandler(Throwable.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ModelAndView exception(final Throwable throwable,final ModelAndView mav) {
		logger.error("処理中にアプリケーション内でエラーが発生しました",throwable);
		String errorMessage = (throwable != null ? throwable.getMessage() :"Unknown Error");
		mav.addObject("errorMessage",errorMessage);
		mav.setViewName("error");
		return mav;
	}
}

package com.faik.exception;

import java.io.File;
import java.lang.reflect.Field;
import java.security.PublicKey;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExecptionHandler {



	private List<String> addMapValue(List<String> list, String newValue){
		list.add(newValue);
		return list;
	}
	
	//Spring validation'dan gelen hataları adam akıllı yönetmek
	//Bu hata geldiği zaman buraya sokar
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<ApiError> handleMethodArgumentException(MethodArgumentNotValidException ex){
		Map<String, List<String>> errorsMap = new HashMap<>(); 
		
		for (ObjectError objError: ex.getBindingResult().getAllErrors()) {
			String FieldName =  ((FieldError)objError).getField();
			if(errorsMap.containsKey(FieldName)) {
												// bir önceki hata mesajının üstüne bu mesajı ekliyoruz
				errorsMap.put(FieldName,addMapValue(errorsMap.get(FieldName), objError.getDefaultMessage()));
			}else {
												// yeni bir hata mesajı ekliyoruz
				errorsMap.put(FieldName,addMapValue(new ArrayList<>(), objError.getDefaultMessage()));
			}
		}
		return ResponseEntity.badRequest().body(createApiError(errorsMap));
	}
	private <T> ApiError<T> createApiError(T  errors) {
		ApiError<T> apiError = new ApiError<T>();
		apiError.setId(UUID.randomUUID().toString());
		apiError.setErrorTime(new Date(0));
		apiError.setErrors(errors);
		
		return apiError;
	}
}



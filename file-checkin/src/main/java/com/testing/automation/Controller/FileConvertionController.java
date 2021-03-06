package com.testing.automation.Controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.RequestBodySpec;
import org.springframework.web.reactive.function.client.WebClient.RequestHeadersSpec;
import org.springframework.web.reactive.function.client.WebClient.UriSpec;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.testing.automation.BeanPOJOSimple.SingleFile;

import reactor.core.publisher.Mono;

@RestController
public class FileConvertionController {
	
	/*
	 * @Autowired FileConvertion fileConvertion;
	 * 
	 * SingleFile singleFile=null; Mono<String> response1=null; final String Path
	 * ="C://Testing";
	 * 
	 * @PostMapping("/hhsk") public void output() { List<String> list=new
	 * ArrayList<>(); WebClient client = WebClient.builder()
	 * .baseUrl("http://10.54.157.105:61205") .defaultCookie("cookieKey",
	 * "cookieValue") .defaultHeader(HttpHeaders.CONTENT_TYPE,
	 * MediaType.APPLICATION_JSON_VALUE)
	 * .defaultUriVariables(Collections.singletonMap("url",
	 * "http://10.54.157.105:61205")) .build(); UriSpec<RequestBodySpec> uriSpec =
	 * client.post(); RequestBodySpec bodySpec = uriSpec.uri( uriBuilder ->
	 * uriBuilder.pathSegment("/doc-mgmt/api/v1/checkin").build()); try { File file
	 * = new File(Path); File filesList[] = file.listFiles(); ObjectMapper obj=new
	 * ObjectMapper(); for(File f: filesList) { singleFile = new SingleFile();
	 * 
	 * String encoder = fileConvertion.fileEncoder(f);
	 * 
	 * singleFile.setContentStream(encoder); singleFile.setName(f.getName());
	 * singleFile.setComments("First Commit");
	 * singleFile.setMimeType("application/"+f.getName().substring(f.getName().
	 * lastIndexOf(".")+1)); singleFile.setVersion("0.1");
	 * singleFile.setAbsolutePath(f.getAbsolutePath());
	 * singleFile.setDescription("Test file"); String Json=
	 * obj.writeValueAsString(singleFile); RequestHeadersSpec<?> headersSpec =
	 * bodySpec.bodyValue(Json); response1 = headersSpec.exchangeToMono(response ->
	 * { if (response.statusCode() .equals(HttpStatus.OK)) { return
	 * response.bodyToMono(String.class); } else if (response.statusCode()
	 * .is4xxClientError()) { return Mono.just("Error response"); } else { return
	 * response.createException() .flatMap(Mono::error); } }); String result1 =
	 * response1.block(); list.add(result1); } for(String s:list)
	 * System.out.println(s);
	 * 
	 * } catch (JsonProcessingException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } }
	 */

}

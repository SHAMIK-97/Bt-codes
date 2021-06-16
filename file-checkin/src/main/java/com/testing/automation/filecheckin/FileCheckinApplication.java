package com.testing.automation.filecheckin;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.RequestBodySpec;
import org.springframework.web.reactive.function.client.WebClient.RequestHeadersSpec;
import org.springframework.web.reactive.function.client.WebClient.UriSpec;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.testing.automation.BeanPOJO.*;
import com.testing.automation.BeanPOJOSimple.SingleFile;
import com.testing.automation.Controller.FileConvertion;

import reactor.core.publisher.Mono;

@SpringBootApplication
@ComponentScan(basePackages = "com.testing.automation.Controller")
public class FileCheckinApplication {
	
	@Autowired
	FileConvertion fileConvertion;
	
	SingleFile singleFile=null;
	Mono<String> response1=null;
	final String Path ="C://Testing"; 
	
	public static void main(String[] args) {
		SpringApplication.run(FileCheckinApplication.class, args);
		 
	}
	
	@Bean
	public void output() {
		List<String> list=new ArrayList<>();
		WebClient client = WebClient.builder()
				  .baseUrl("http://10.54.157.105:61205")
				  .defaultCookie("cookieKey", "cookieValue")
				  .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE) 
				  .defaultUriVariables(Collections.singletonMap("url", "http://10.54.157.105:61205"))
				  .build();
		UriSpec<RequestBodySpec> uriSpec = client.post();
		RequestBodySpec bodySpec = uriSpec.uri(
				  uriBuilder -> uriBuilder.pathSegment("/doc-mgmt/api/v1/checkin").build()); 
		try {
			File file = new File(Path);
			 File filesList[] = file.listFiles();
			 
			 for(File f: filesList) {
				 singleFile = new SingleFile();
				 
				 String encoder = fileConvertion.fileEncoder(f);
				 
				 String Json= JsonSerializer(f,encoder);
				 RequestHeadersSpec<?> headersSpec = bodySpec.bodyValue(Json);
				  response1 = headersSpec.exchangeToMono(response -> {
					  if (response.statusCode()
					    .equals(HttpStatus.OK)) {
					      return response.bodyToMono(String.class);
					  } else if (response.statusCode()
					    .is4xxClientError()) {
					      return Mono.just("Error response");
					  } else {
					      return response.createException()
					        .flatMap(Mono::error);
					  }
					});
				 	String result1 = response1.block();
				  list.add(result1);
				  }
		for(String s:list)
			System.out.println(s);
			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	private String JsonSerializer(File file1,String encoder1) {
		
		String Json=null;
		try {
			ObjectMapper obj=new ObjectMapper();
			BeanPOJO beanPOJO = new BeanPOJO();
			Info info = new Info();
			DisabledSystemHeaders disabledSystemHeaders = new DisabledSystemHeaders();
			ProtocolProfileBehaviour profileBehaviour= new ProtocolProfileBehaviour();
			disabledSystemHeaders.setAcceptencoding(true);
			profileBehaviour.setDisabledSystemHeaders(disabledSystemHeaders);
			
			SingleFile singleFile= new SingleFile();
			singleFile.setContentStream(encoder1);
			 singleFile.setName(file1.getName());
			 singleFile.setComments("First Commit");
			 singleFile.setMimeType("application/"+file1.getName().substring(file1.getName().lastIndexOf(".")+1));
			 singleFile.setVersion("0.1");
			 singleFile.setAbsolutePath(file1.getAbsolutePath());
			 singleFile.setDescription("Test file");
			 String jSONinitial = obj.writeValueAsString(singleFile);
			 
			 info.set_postman_id("bf1571bb-6430-417c-9125-b92b71dc724f");
			 info.setName("doc-mgmt-service");
			 info.setSchema("https://schema.getpostman.com/json/collecti on/v2.1.0/collecti on.json");
			 beanPOJO.setInfo(info);
			 
			 List<Headers> header=new ArrayList();
			 Headers header2=new Headers();
			 Headers header1=new Headers();
			 header2.setKey("principal");
			 header2.setValue("{\"userId\":\"selva\"}");
			 header2.setType("text");
			 header1.setKey("Content-Type");
			 header1.setValue("application/json");
			 header1.setType("text");
			 header.add(header2);
			 header.add(header1);
			 
			 Body body=new Body();
			 body.setMode("raw");
			 body.setRaw(jSONinitial);
			 body.setOptions(null);
			 String[] array = {"localhost"}; 
			 String[] path= {"doc-mgmt","api","v1","checkin"};
			 Url url=new Url();
			 url.setRaw("https://loalhost:8080/doc-mgmt/api/v1/checkin");
			 url.setProtocol("http");
			 url.setHost(Arrays.asList(array));
			 url.setPort("8080");
			 url.setPath(Arrays.asList(path));
			 
			 Request request=new Request();
			 request.setMethod("POST");
			 request.setHeaders(header);
			 request.setBody(body);
			 request.setUrl(url);
			 
			Item item1=new Item();
			List<Item> item=new ArrayList();
			item1.setName("checkinDocument");
			item1.setProtocolProfileBehaviour(profileBehaviour);
			item1.setRequest(request);
			item1.setResponse(null);
			item.add(item1);
			beanPOJO.setInfo(info);
			beanPOJO.setItem(item);
			ObjectMapper obj1=new ObjectMapper();
			Json=obj1.writeValueAsString(beanPOJO);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Json;
	}
	
	
}

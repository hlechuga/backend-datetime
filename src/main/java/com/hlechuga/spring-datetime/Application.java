package com.hlechuga.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;
import org.springframework.http.HttpStatus;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.ZoneId;
import java.util.Properties;
import java.util.Map;
import java.util.LinkedHashMap;


@SpringBootApplication
@RestController
@RequestMapping(value="/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class Application {
  
  @GetMapping("/datetime")
  public ResponseEntity<?> datetimeresp() {
    ZoneId tz = ZoneId.systemDefault();
    ZonedDateTime now = ZonedDateTime.now(tz);

    Map<String, Object> resp = new LinkedHashMap<>();
    resp.put("date", DateTimeFormatter.ofPattern("yyyy/MM/dd").format(now));
    resp.put("time", DateTimeFormatter.ofPattern("HH:mm:ss").format(now));
    resp.put("timezone", DateTimeFormatter.ofPattern("z Z").format(now));

    return new ResponseEntity<>(resp, HttpStatus.OK);
  }

  public static void main(String[] args) {    
    SpringApplication.run(Application.class, args);
  }
}
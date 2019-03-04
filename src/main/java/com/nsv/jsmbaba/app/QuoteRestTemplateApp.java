package com.nsv.jsmbaba.app;

import com.nsv.jsmbaba.domain.Quote;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.client.RestTemplate;
@Slf4j
public class QuoteRestTemplateApp {

    public static void main(String[] args) {

        RestTemplate restTemplate = new RestTemplate();
        Quote quote = restTemplate.getForObject("https://gturnquist-quoters.cfapps.io/api/random", Quote.class);
        log.info(quote.toString());


    }
}

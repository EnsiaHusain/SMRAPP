package com.stock.market.research.app;

import com.stock.market.research.app.domain.StockMarketData;
import com.stock.market.research.app.dto.StockMarketDataDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.TestPropertySource;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.math.BigDecimal;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@TestPropertySource("classpath:/application.properties")
public class SMRAppControllerIntegrationTest {


    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;


    @Test
    void testUploadBulkDataCSVFile(){
        try {
            MultipartFile   multipartFile = new MockMultipartFile("file","DowJonesData.csv", MediaType.MULTIPART_FORM_DATA_VALUE,
                    new FileInputStream(new File("src/test/resources/DowJonesData.csv")));

            MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
            body.add("file",multipartFile.getResource());

            HttpHeaders requestHeaders = new HttpHeaders();
            requestHeaders.setContentType(MediaType.MULTIPART_FORM_DATA);
            HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, requestHeaders);

            ResponseEntity<Boolean> response = restTemplate.exchange("http://localhost:8080/stock/market/uploadBulkData",HttpMethod.POST,requestEntity,Boolean.class);
            Assertions.assertTrue(response.getBody().booleanValue());
        }catch(IOException exception){
            Assertions.fail();
        }
    }

    @Test
     void testAddNewRecord(){
        StockMarketDataDto stockMarketDataDto = new StockMarketDataDto();
        stockMarketDataDto.setQuarter(100);
        stockMarketDataDto.setStock("AXP");
        stockMarketDataDto.setOpen("$43.30");
        stockMarketDataDto.setHigh("$45.60");
        stockMarketDataDto.setLow("$43.11");
        stockMarketDataDto.setClose("$44.36");
        stockMarketDataDto.setVolume(new Long("45102042"));
        stockMarketDataDto.setPercentChangePrice(new BigDecimal(2.44804));
        stockMarketDataDto.setNextWeeksopen("$44.20");
        stockMarketDataDto.setNextWeeksClose("$46.25");
        stockMarketDataDto.setPercentChangeNextWeeksPrice(new BigDecimal(4.63801));
        stockMarketDataDto.setDaysToNextDividend(23);
        stockMarketDataDto.setPercentReturnNextDividend(new BigDecimal("2.3"));
        stockMarketDataDto.setPercentReturnNextDividend(new BigDecimal(0.405771));
        stockMarketDataDto.setPreviousWeeksVolume(new BigDecimal(239655616));
        stockMarketDataDto.setDate("1/7/2011");

        ResponseEntity<Boolean> responseEntity = this.restTemplate.postForEntity("http://localhost:8080/stock/market/addRecord",stockMarketDataDto, Boolean.class);
        Assertions.assertTrue(responseEntity.getBody().booleanValue());

    }

    @Test
    void testViewStockPredictions(){

        StockMarketDataDto stockMarketDataDto = new StockMarketDataDto();
        stockMarketDataDto.setQuarter(100);
        stockMarketDataDto.setStock("AXP");
        stockMarketDataDto.setOpen("$43.30");
        stockMarketDataDto.setHigh("$45.60");
        stockMarketDataDto.setLow("$43.11");
        stockMarketDataDto.setClose("$44.36");
        stockMarketDataDto.setVolume(new Long("45102042"));
        stockMarketDataDto.setPercentChangePrice(new BigDecimal(2.44804));
        stockMarketDataDto.setNextWeeksopen("$44.20");
        stockMarketDataDto.setNextWeeksClose("$46.25");
        stockMarketDataDto.setPercentChangeNextWeeksPrice(new BigDecimal(4.63801));
        stockMarketDataDto.setDaysToNextDividend(23);
        stockMarketDataDto.setPercentReturnNextDividend(new BigDecimal("2.3"));
        stockMarketDataDto.setPercentReturnNextDividend(new BigDecimal(0.405771));
        stockMarketDataDto.setPreviousWeeksVolume(new BigDecimal(239655616));
        stockMarketDataDto.setDate("1/7/2011");

        ResponseEntity<Boolean> responseEntity1 = this.restTemplate.postForEntity("http://localhost:8080/stock/market/addRecord",stockMarketDataDto, Boolean.class);
        Assertions.assertTrue(responseEntity1.getBody().booleanValue());

        ResponseEntity<List<StockMarketDataDto>> responseEntity2 = this.restTemplate.exchange("http://localhost:8080/stock/market/predictions?stockName=AXP", HttpMethod.GET,null,new ParameterizedTypeReference<List<StockMarketDataDto>>(){});
        Assertions.assertNotNull(responseEntity2.getBody());
        Assertions.assertNotNull(responseEntity2.getBody().size()==1);
    }

}

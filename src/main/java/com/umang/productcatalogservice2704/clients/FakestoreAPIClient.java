package com.umang.productcatalogservice2704.clients;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

/*
Infrastructure/Communication logic
 */
@Component
public class FakestoreAPIClient {
    @Autowired
    private RestTemplate restTemplate;

    public <T> ResponseEntity<T> requestForEntity(HttpMethod httpMethod, String url, @Nullable Object request, Class<T> responseType, Object... uriVariables) throws RestClientException {
        RequestCallback requestCallback = restTemplate.httpEntityCallback(request, responseType);
        ResponseExtractor<ResponseEntity<T>> responseExtractor = restTemplate.responseEntityExtractor(responseType);
        return restTemplate.execute(url, httpMethod, requestCallback, responseExtractor, uriVariables);
    }

    /*
    public Boolean validatesResponse(Response response){
        //check if the response is valid or not
        //if the response is valid return true else return false
        if(response.getBody() != null and response.getStatusCode().equals(HttpStatusCode.valueOf(200))){
            return true;
        }
        }
     */
}

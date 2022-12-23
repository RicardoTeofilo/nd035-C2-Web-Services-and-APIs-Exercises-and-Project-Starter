package com.udacity.pricing;

import com.udacity.pricing.domain.price.Price;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureJsonTesters
public class PricingServiceApplicationTests {

	@Autowired
	private WebTestClient webTestClient;

	@Test
	public void contextLoads() {
	}

	@Test
	public void getPriceSuccess(){

		webTestClient.get()
				.uri(uriBuilder ->
						uriBuilder
						.path("services/price/")
						.queryParam("vehicleIdentificationNumber", "123456ABC")
						.build())
				.exchange()
				.expectStatus().isOk()
				.expectBody(Price.class);
	}


	/**
	 * Test that two calls to the get price service with the same vehicle
	 * identification number will return the same price value
	 */
	@Test
	public void getSamePriceForSameVehicleNumber(){

		String vehicleIdentificationNumber = "123456ABC";

		Price firstPrice = webTestClient.get()
				.uri(uriBuilder ->
						uriBuilder
								.path("services/price/")
								.queryParam("vehicleIdentificationNumber", vehicleIdentificationNumber)
								.build())
				.exchange()
				.expectStatus().isOk()
				.expectBody(Price.class)
				.returnResult()
				.getResponseBody();

		Price secondPrice = webTestClient.get()
				.uri(uriBuilder ->
						uriBuilder
								.path("services/price/")
								.queryParam("vehicleIdentificationNumber", vehicleIdentificationNumber)
								.build())
				.exchange()
				.expectStatus().isOk()
				.expectBody(Price.class)
				.returnResult()
				.getResponseBody();

		assertTrue(firstPrice.getPrice().compareTo(secondPrice.getPrice()) == 0);
	}

}

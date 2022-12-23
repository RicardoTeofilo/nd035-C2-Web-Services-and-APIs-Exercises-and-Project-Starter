package com.udacity.pricing.service;

import com.udacity.pricing.domain.price.Price;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Implements the pricing service to get prices for each vehicle.
 */
public class PricingService {

    /**
     * Changing the logic a little here for this Mocking service.
     * Given that the prices were not really mapping prices to a unique vehicle ID.
     * Now we will use the String vehicleIdentificationNumber which is a unique
     * vehicle identifier. In a real world, this call would fetch data from a trusted location
     * like a governmental agency or official car sales database where the price could be checked.
     * For this mocking service, we are just returning a random value and associating it with
     * the vehicleIdentificationNumber.
     */
    private static final Map<String, Price> PRICES = new HashMap<>();

    /**
     * If a valid vehicleIdentificationNumber ID, gets the price of the vehicle from the stored array.
     * @param vehicleIdentificationNumber unique identifier number of the vehicle the price is requested for.
     * @return price of the requested vehicle
     * @throws PriceException vehicleID was not found
     */
    public static Price getPrice(String vehicleIdentificationNumber) throws PriceException {

        if (PRICES.containsKey(vehicleIdentificationNumber))
            return PRICES.get(vehicleIdentificationNumber);

        Price newPrice = new Price("USD", randomPrice(), vehicleIdentificationNumber);
        PRICES.put(vehicleIdentificationNumber, newPrice);
        return newPrice;
    }

    /**
     * Gets a random price to fill in for a given vehicle ID.
     * @return random price for a vehicle
     */
    private static BigDecimal randomPrice() {
        return new BigDecimal(ThreadLocalRandom.current().nextDouble(1, 5))
                .multiply(new BigDecimal(5000d)).setScale(2, RoundingMode.HALF_UP);
    }

}

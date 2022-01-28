package com.checkout.samples.nas.customersidentifier;// For more information please refer to https://github.com/checkout/checkout-sdk-java

import com.checkout.CheckoutApiException;
import com.checkout.CheckoutArgumentException;
import com.checkout.CheckoutAuthorizationException;
import com.checkout.CheckoutSdk;
import com.checkout.Environment;
import com.checkout.common.Phone;
import com.checkout.customers.four.CustomerRequest;
import com.checkout.four.CheckoutApi;

import java.util.Map;
import java.util.concurrent.ExecutionException;

public class patch {

    public static void main(final String[] args) throws ExecutionException, InterruptedException {

        final CheckoutApi api = CheckoutSdk.fourSdk()
                .staticKeys()
                .publicKey("public_key")
                .secretKey("secret_key")
                .environment(Environment.SANDBOX)
                .build();

        try {
            final CustomerRequest customerRequest = CustomerRequest.builder()
                    .email("")
                    .name("")
                    .phone(Phone.builder().countryCode("").number("").build())
                    .build();

            api.customersClient().update("customerId", customerRequest).get();
        } catch (final CheckoutApiException e) {
            // the API didn't respond with a 2**
            final String requestId = e.getRequestId();
            final int statusCode = e.getHttpStatusCode();
            final Map<String, Object> errorDetails = e.getErrorDetails();
        } catch (final CheckoutArgumentException e) {
            // bad input
        } catch (final CheckoutAuthorizationException e) {
            // invalid authorization
        }

    }

}


package com.checkout.samples.nas.instrumentsid;// For more information please refer to https://github.com/checkout/checkout-sdk-java

import com.checkout.CheckoutApiException;
import com.checkout.CheckoutArgumentException;
import com.checkout.CheckoutAuthorizationException;
import com.checkout.CheckoutSdk;
import com.checkout.Environment;
import com.checkout.common.four.AccountHolder;
import com.checkout.common.four.UpdateCustomerRequest;
import com.checkout.four.CheckoutApi;
import com.checkout.instruments.four.update.UpdateInstrumentCardRequest;
import com.checkout.instruments.four.update.UpdateInstrumentResponse;

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
            final UpdateInstrumentCardRequest updateRequest = UpdateInstrumentCardRequest.builder()
                    .expiryMonth(12)
                    .expiryYear(12)
                    .name("")
                    .customer(UpdateCustomerRequest.builder().build())
                    .accountHolder(AccountHolder.builder().build())
                    .build();

            final UpdateInstrumentResponse updateResponse = api.instrumentsClient().update("instrumentId", updateRequest).get();
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


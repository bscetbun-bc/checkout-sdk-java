package com.checkout.samples.nas.marketplaceentities;// For more information please refer to https://github.com/checkout/checkout-sdk-java

import com.checkout.CheckoutApiException;
import com.checkout.CheckoutArgumentException;
import com.checkout.CheckoutAuthorizationException;
import com.checkout.CheckoutSdk;
import com.checkout.Environment;
import com.checkout.four.CheckoutApi;
import com.checkout.marketplace.ContactDetails;
import com.checkout.marketplace.Individual;
import com.checkout.marketplace.OnboardEntityRequest;
import com.checkout.marketplace.OnboardEntityResponse;
import com.checkout.marketplace.Profile;

import java.util.Map;
import java.util.concurrent.ExecutionException;

public class post {

    public static void main(final String[] args) throws ExecutionException, InterruptedException {

        final CheckoutApi api = CheckoutSdk.fourSdk()
                .staticKeys()
                .publicKey("public_key")
                .secretKey("secret_key")
                .environment(Environment.SANDBOX)
                .build();

        try {
            final OnboardEntityRequest onboardEntityRequest = OnboardEntityRequest.builder()
                    .reference("")
                    .contactDetails(ContactDetails.builder().build())
                    .profile(Profile.builder().build())
                    .individual(Individual.builder().build())
                    .build();

            final OnboardEntityResponse entityResponse = api.marketplaceClient().createEntity(onboardEntityRequest).get();
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


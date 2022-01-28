package com.checkout.samples.abc.events;// For more information please refer to https://github.com/checkout/checkout-sdk-java

import com.checkout.CheckoutApi;
import com.checkout.CheckoutSdk;
import com.checkout.Environment;
import com.checkout.events.EventsPageResponse;
import com.checkout.events.RetrieveEventsRequest;

import java.util.concurrent.ExecutionException;

public class get {

    public static void main(final String[] args) throws ExecutionException, InterruptedException {

        final CheckoutApi api = CheckoutSdk.defaultSdk()
                .staticKeys()
                .publicKey("public_key")
                .secretKey("secret_key")
                .environment(Environment.SANDBOX)
                .build();

        final RetrieveEventsRequest retrieveEventsRequest = RetrieveEventsRequest.builder().build();
        final EventsPageResponse eventsPageResponse = api.eventsClient().retrieveEvents(retrieveEventsRequest).get();

    }

}


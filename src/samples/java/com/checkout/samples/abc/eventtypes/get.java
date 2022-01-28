package com.checkout.samples.abc.eventtypes;// For more information please refer to https://github.com/checkout/checkout-sdk-java

import com.checkout.CheckoutApi;
import com.checkout.CheckoutSdk;
import com.checkout.Environment;
import com.checkout.events.EventTypesResponse;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class get {

    public static void main(final String[] args) throws ExecutionException, InterruptedException {

        final CheckoutApi api = CheckoutSdk.defaultSdk()
                .staticKeys()
                .publicKey("public_key")
                .secretKey("secret_key")
                .environment(Environment.SANDBOX)
                .build();

        /*
           Specify API version:
            "1.0" => Legacy API
            "2.0" => Unified Payments API
            null  => all versions
        */
        final List<EventTypesResponse> response = api.eventsClient().retrieveAllEventTypes(null).get();

    }

}


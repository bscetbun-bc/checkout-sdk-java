package com.checkout.samples.abc.instrumentsid;// For more information please refer to https://github.com/checkout/checkout-sdk-java

import com.checkout.CheckoutApi;
import com.checkout.CheckoutSdk;
import com.checkout.Environment;
import com.checkout.instruments.UpdateInstrumentRequest;
import com.checkout.instruments.UpdateInstrumentResponse;

import java.util.concurrent.ExecutionException;

public class patch {

    public static void main(final String[] args) throws ExecutionException, InterruptedException {

        final CheckoutApi api = CheckoutSdk.defaultSdk()
                .staticKeys()
                .publicKey("public_key")
                .secretKey("secret_key")
                .environment(Environment.SANDBOX)
                .build();

        final UpdateInstrumentRequest updateRequest = UpdateInstrumentRequest.builder()
                .expiryMonth(1)
                .expiryYear(2)
                .name("asdasds")
                .build();

        final UpdateInstrumentResponse updateResponse = api.instrumentsClient().updateInstrument("instrumentId", updateRequest).get();

    }

}


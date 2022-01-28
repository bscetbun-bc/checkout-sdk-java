package com.checkout.samples.abc.instruments;// For more information please refer to https://github.com/checkout/checkout-sdk-java

import com.checkout.CheckoutApi;
import com.checkout.CheckoutSdk;
import com.checkout.Environment;
import com.checkout.instruments.CreateInstrumentRequest;
import com.checkout.instruments.CreateInstrumentResponse;

import java.util.concurrent.ExecutionException;

public class post {

    public static void main(final String[] args) throws ExecutionException, InterruptedException {

        final CheckoutApi api = CheckoutSdk.defaultSdk()
                .staticKeys()
                .publicKey("public_key")
                .secretKey("secret_key")
                .environment(Environment.SANDBOX)
                .build();

        final CreateInstrumentRequest request = CreateInstrumentRequest.builder().build();

        final CreateInstrumentResponse response = api.instrumentsClient().createInstrument(request).get();

    }

}




package com.checkout.samples.abc.paymentsidcaptures;// For more information please refer to https://github.com/checkout/checkout-sdk-java

import com.checkout.CheckoutApi;
import com.checkout.CheckoutSdk;
import com.checkout.Environment;
import com.checkout.payments.CaptureRequest;
import com.checkout.payments.CaptureResponse;

import java.util.HashMap;
import java.util.concurrent.ExecutionException;

public class post {

    public static void main(final String[] args) throws ExecutionException, InterruptedException {

        final CheckoutApi api = CheckoutSdk.defaultSdk()
                .staticKeys()
                .publicKey("public_key")
                .secretKey("secret_key")
                .environment(Environment.SANDBOX)
                .build();

        final CaptureRequest captureRequest = CaptureRequest.builder()
                .reference("")
                .metadata(new HashMap<>())
                .build();

        final CaptureResponse response = api.paymentsClient().capturePayment("", captureRequest).get();

    }

}


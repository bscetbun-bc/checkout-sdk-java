package com.checkout.samples.abc.tokens;// For more information please refer to https://github.com/checkout/checkout-sdk-java

import com.checkout.CheckoutApi;
import com.checkout.CheckoutSdk;
import com.checkout.Environment;
import com.checkout.tokens.CardTokenRequest;
import com.checkout.tokens.CardTokenResponse;

import java.util.concurrent.ExecutionException;

public class post {

    public static void main(final String[] args) throws ExecutionException, InterruptedException {

        final CheckoutApi api = CheckoutSdk.defaultSdk()
                .staticKeys()
                .publicKey("public_key")
                .secretKey("secret_key")
                .environment(Environment.SANDBOX)
                .build();

        final CardTokenRequest request = CardTokenRequest.builder()
                .number("")
                .expiryMonth(1)
                .expiryYear(2)
                .build();

        final CardTokenResponse response = api.tokensClient().request(request).get();
    }

}


package com.checkout.samples.abc.webhooks;// For more information please refer to https://github.com/checkout/checkout-sdk-java

import com.checkout.CheckoutApi;
import com.checkout.CheckoutSdk;
import com.checkout.Environment;
import com.checkout.webhooks.WebhookRequest;
import com.checkout.webhooks.WebhookResponse;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class post {

    public static void main(final String[] args) throws ExecutionException, InterruptedException {

        final CheckoutApi api = CheckoutSdk.defaultSdk()
                .staticKeys()
                .publicKey("public_key")
                .secretKey("secret_key")
                .environment(Environment.SANDBOX)
                .build();

        final List<String> eventTypes = Arrays.asList("payment_captured", "payment_approved", "payment_declined");

        final WebhookRequest webhookRequest = WebhookRequest.builder()
                .url("https://example.com/webhook")
                .eventTypes(eventTypes)
                .build();

        final WebhookResponse response = api.webhooksClient().registerWebhook(webhookRequest).get();

    }

}



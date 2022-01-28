package com.checkout.samples.abc.webhooksid;// For more information please refer to https://github.com/checkout/checkout-sdk-java

import com.checkout.CheckoutApi;
import com.checkout.CheckoutSdk;
import com.checkout.Environment;
import com.checkout.webhooks.WebhookRequest;
import com.checkout.webhooks.WebhookResponse;

import java.util.concurrent.ExecutionException;

public class put {

    public static void main(final String[] args) throws ExecutionException, InterruptedException {

        final CheckoutApi api = CheckoutSdk.defaultSdk()
                .staticKeys()
                .publicKey("public_key")
                .secretKey("secret_key")
                .environment(Environment.SANDBOX)
                .build();

        final WebhookRequest webhookRequest = WebhookRequest.builder().build();
        webhookRequest.setUrl("https://example.com/webhooks/updated");

        final WebhookResponse newWebhook = api.webhooksClient().updateWebhook("webookId", webhookRequest).get();

    }

}


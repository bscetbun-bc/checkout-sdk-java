package com.checkout.samples.abc.sources;// For more information please refer to https://github.com/checkout/checkout-sdk-java

import com.checkout.CheckoutApi;
import com.checkout.CheckoutSdk;
import com.checkout.Environment;
import com.checkout.common.Address;
import com.checkout.sources.SourceData;
import com.checkout.sources.SourceProcessed;
import com.checkout.sources.SourceRequest;
import com.checkout.sources.SourceResponse;

import java.util.concurrent.ExecutionException;

public class post {

    public static void main(final String[] args) throws ExecutionException, InterruptedException {

        final CheckoutApi api = CheckoutSdk.defaultSdk()
                .staticKeys()
                .publicKey("public_key")
                .secretKey("secret_key")
                .environment(Environment.SANDBOX)
                .build();

        final Address billingAddress = new Address();
        final SourceData sourceData = new SourceData();
        final SourceRequest sourceRequest = new SourceRequest("sepa", billingAddress);
        sourceRequest.setSourceData(sourceData);

        final SourceResponse response = api.sourcesClient().requestAsync(sourceRequest).get();

        final SourceProcessed source = response.getSource();

    }

}



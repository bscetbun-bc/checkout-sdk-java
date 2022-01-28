package com.checkout.samples.abc.reportingpayments;// For more information please refer to https://github.com/checkout/checkout-sdk-java

import com.checkout.CheckoutApi;
import com.checkout.CheckoutSdk;
import com.checkout.Environment;
import com.checkout.reconciliation.ReconciliationPaymentReportResponse;
import com.checkout.reconciliation.ReconciliationQueryPaymentsFilter;

import java.util.concurrent.ExecutionException;

public class get {

    public static void main(final String[] args) throws ExecutionException, InterruptedException {

        final CheckoutApi api = CheckoutSdk.defaultSdk()
                .staticKeys()
                .publicKey("public_key")
                .secretKey("secret_key")
                .environment(Environment.SANDBOX)
                .build();

        final ReconciliationQueryPaymentsFilter filter = ReconciliationQueryPaymentsFilter
                .builder()
                .from("")
                .to("")
                .reference("")
                .limit(1)
                .build();

        final ReconciliationPaymentReportResponse response = api.reconciliationClient().queryPaymentsReport(filter).get();

    }

}


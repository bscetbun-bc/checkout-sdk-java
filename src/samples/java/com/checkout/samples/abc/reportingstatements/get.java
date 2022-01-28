package com.checkout.samples.abc.reportingstatements;// For more information please refer to https://github.com/checkout/checkout-sdk-java

import com.checkout.CheckoutApi;
import com.checkout.CheckoutSdk;
import com.checkout.Environment;
import com.checkout.common.QueryFilterDateRange;
import com.checkout.reconciliation.StatementReportResponse;

import java.util.concurrent.ExecutionException;

public class get {

    public static void main(final String[] args) throws ExecutionException, InterruptedException {

        final CheckoutApi api = CheckoutSdk.defaultSdk()
                .staticKeys()
                .publicKey("public_key")
                .secretKey("secret_key")
                .environment(Environment.SANDBOX)
                .build();

        final QueryFilterDateRange filter = QueryFilterDateRange
                .builder()
                .from("")
                .to("")
                .build();

        final StatementReportResponse response = api.reconciliationClient().queryStatementsReport(filter).get();

    }

}



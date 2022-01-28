package com.checkout.samples.abc.paymentsidrefunds;// For more information please refer to https://github.com/checkout/checkout-sdk-java

import com.checkout.CheckoutApi;
import com.checkout.CheckoutSdk;
import com.checkout.Environment;
import com.checkout.payments.RefundRequest;
import com.checkout.payments.RefundResponse;

import java.util.concurrent.ExecutionException;

public class post {

	public static void main(final String[] args) throws ExecutionException, InterruptedException {

		final CheckoutApi api = CheckoutSdk.defaultSdk()
				.staticKeys()
				.publicKey("public_key")
				.secretKey("secret_key")
				.environment(Environment.SANDBOX)
				.build();

		final RefundRequest refundRequest = RefundRequest.builder()
				.reference("")
				.build();

		final RefundResponse response = api.paymentsClient().refundPayment("paymentId", refundRequest).get();

	}

}



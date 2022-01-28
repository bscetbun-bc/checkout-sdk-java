package com.checkout.samples.abc.disputesdispute_idevidence;// For more information please refer to https://github.com/checkout/checkout-sdk-java

import com.checkout.CheckoutApi;
import com.checkout.CheckoutSdk;
import com.checkout.Environment;
import com.checkout.disputes.DisputeEvidenceRequest;

import java.util.concurrent.ExecutionException;

public class put {

    public static void main(final String[] args) throws ExecutionException, InterruptedException {

        final CheckoutApi api = CheckoutSdk.defaultSdk()
                .staticKeys()
                .publicKey("public_key")
                .secretKey("secret_key")
                .environment(Environment.SANDBOX)
                .build();

        final DisputeEvidenceRequest evidenceRequest = DisputeEvidenceRequest.builder()
                .proofOfDeliveryOrServiceFile("")
                .proofOfDeliveryOrServiceText("proof of delivery or service text")
                .invoiceOrReceiptFile("")
                .invoiceOrReceiptText("Copy of the invoice")
                .invoiceShowingDistinctTransactionsFile("")
                .invoiceShowingDistinctTransactionsText("Copy of invoice #1244 showing two transactions")
                .customerCommunicationFile("")
                .customerCommunicationText("Copy of an email exchange with the cardholder")
                .refundOrCancellationPolicyFile("")
                .refundOrCancellationPolicyText("Copy of the refund policy")
                .recurringTransactionAgreementFile("")
                .recurringTransactionAgreementText("Copy of the recurring transaction agreement")
                .additionalEvidenceFile("")
                .additionalEvidenceText("Scanned document")
                .proofOfDeliveryOrServiceDateFile("")
                .proofOfDeliveryOrServiceDateText("Copy of the customer receipt showing the merchandise was delivered on 2018-12-20")
                .build();

        api.disputesClient().putEvidence("disputeId", evidenceRequest).get();

    }

}


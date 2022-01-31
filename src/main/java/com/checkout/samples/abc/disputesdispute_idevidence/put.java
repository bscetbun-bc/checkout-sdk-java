

import com.checkout.CheckoutApi;
import com.checkout.CheckoutApiException;
import com.checkout.CheckoutArgumentException;
import com.checkout.CheckoutAuthorizationException;
import com.checkout.CheckoutSdk;
import com.checkout.Environment;
import com.checkout.disputes.DisputeEvidenceRequest;




public class put {



        CheckoutApi api = CheckoutSdk.defaultSdk()
                .staticKeys()
                .publicKey("public_key")
                .secretKey("secret_key")
                .environment(Environment.SANDBOX) // or Environment.PRODUCTION
                .build();

        DisputeEvidenceRequest evidenceRequest = DisputeEvidenceRequest.builder()
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

        try {
            api.disputesClient().putEvidence("disputeId", evidenceRequest).get();
        } catch (CheckoutApiException e) {
            // API error
            String requestId = e.getRequestId();
            int statusCode = e.getHttpStatusCode();
            Map<String, Object> errorDetails = e.getErrorDetails();
        } catch (CheckoutArgumentException e) {
            // Bad arguments
        } catch (CheckoutAuthorizationException e) {
            // Invalid authorization
        }

    }

}


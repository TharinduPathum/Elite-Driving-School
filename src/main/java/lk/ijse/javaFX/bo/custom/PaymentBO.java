package lk.ijse.javaFX.bo.custom;

import lk.ijse.javaFX.bo.SuperBO;
import lk.ijse.javaFX.dto.PaymentsDTO;

import java.util.List;
import java.util.Optional;

public interface PaymentBO extends SuperBO {

    List<PaymentsDTO> getAllPayments() throws Exception;

    String getLastPaymentId() throws Exception;

    boolean savePayments(PaymentsDTO t) throws Exception;

    boolean updatePayments(PaymentsDTO t) throws Exception;

    boolean deletePayments(String id) throws Exception;

    List<String> getAllPaymentIds() throws Exception;

    Optional<PaymentsDTO> findByPaymentId(String id) throws Exception;

    String generateNewPaymentId();
}

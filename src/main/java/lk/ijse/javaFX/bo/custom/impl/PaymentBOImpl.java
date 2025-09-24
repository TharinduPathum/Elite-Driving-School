package lk.ijse.javaFX.bo.custom.impl;

import lk.ijse.javaFX.bo.custom.PaymentBO;
import lk.ijse.javaFX.bo.exception.DuplicateException;
import lk.ijse.javaFX.bo.exception.NotFoundException;
import lk.ijse.javaFX.bo.util.EntityDTOConverter;
import lk.ijse.javaFX.dao.DAOFactory;
import lk.ijse.javaFX.dao.custom.PaymentDAO;
import lk.ijse.javaFX.dto.PaymentsDTO;
import lk.ijse.javaFX.dao.DAOTypes;
import lk.ijse.javaFX.entity.Payments;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PaymentBOImpl implements PaymentBO {

    private final PaymentDAO paymentDAO = (PaymentDAO) DAOFactory.getInstance().getDAO(DAOTypes.PAYMENT);
    private final EntityDTOConverter converter = new EntityDTOConverter();


    @Override
    public List<PaymentsDTO> getAllPayments() throws Exception {
        List<Payments> paymentsList = paymentDAO.getAll();
        List<PaymentsDTO> list = new ArrayList<>();
        for (Payments payments : paymentsList) {
            list.add(converter.getPaymentsDTO(payments));
        }
        return list;
    }

    @Override
    public String getLastPaymentId() throws Exception {
        return paymentDAO.getLastId();
    }

    @Override
    public boolean savePayments(PaymentsDTO t) throws Exception {
        Optional<Payments> payments = paymentDAO.findById(t.getP_id());
        if (payments.isPresent()) {
            throw new DuplicateException("Payment already exists");
        }
        if (t.getS_id() == null) {
            throw new NotFoundException("Student id is null");
        }
        return paymentDAO.save(converter.getPaymentsEntity(t));
    }

    @Override
    public boolean updatePayments(PaymentsDTO paymentsDTO) throws Exception {
        Optional<Payments> payments = paymentDAO.findById(paymentsDTO.getP_id());
        if (payments.isEmpty()) {
            throw new DuplicateException("Payment Not Found");
        }
        return paymentDAO.update(converter.getPaymentsEntity(paymentsDTO));
    }

    @Override
    public boolean deletePayments(String id) throws Exception {
        Optional<Payments> payments = paymentDAO.findById(id);
        if (payments.isEmpty()) {
            throw new DuplicateException("Payment Not Found");
        }
        return paymentDAO.delete(id);
    }

    @Override
    public List<String> getAllPaymentIds() throws Exception {
        return paymentDAO.getAllIds();
    }

    @Override
    public Optional<PaymentsDTO> findByPaymentId(String id) throws Exception {
        Optional<Payments> payments = paymentDAO.findById(id);
        if (payments.isPresent()) {
            return Optional.of(converter.getPaymentsDTO(payments.get()));
        }
        return Optional.empty();
    }

    @Override
    public String generateNewPaymentId() {
        return paymentDAO.generateNewId();
    }
}

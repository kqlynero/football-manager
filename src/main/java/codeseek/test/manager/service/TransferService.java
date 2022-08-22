package codeseek.test.manager.service;

import codeseek.test.manager.model.Transfer;
import java.util.List;

public interface TransferService {
    Transfer save(Transfer transfer);

    List<Transfer> findAll();

    Transfer getById(Long id);

    void deleteById(Long id);

    Transfer transfer(Transfer transfer);
}

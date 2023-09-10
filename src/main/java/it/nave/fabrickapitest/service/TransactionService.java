package it.nave.fabrickapitest.service;

import it.nave.fabrickapitest.mapper.TransactionMapper;
import it.nave.fabrickapitest.model.Transaction;
import it.nave.fabrickapitest.repository.TransactionRepository;
import java.util.List;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
  private final TransactionMapper transactionMapper;
  private final TransactionRepository transactionRepository;

  public TransactionService(
      TransactionMapper transactionMapper, TransactionRepository transactionRepository) {
    this.transactionMapper = transactionMapper;
    this.transactionRepository = transactionRepository;
  }

  @Async
  public void storeTransaction(List<Transaction> transactions) {
    transactions.stream().map(transactionMapper::toEntity).forEach(transactionRepository::save);
  }
}

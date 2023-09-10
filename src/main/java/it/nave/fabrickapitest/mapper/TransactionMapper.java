package it.nave.fabrickapitest.mapper;

import it.nave.fabrickapitest.entity.TransactionEntity;
import it.nave.fabrickapitest.model.Transaction;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TransactionMapper {
    TransactionEntity toEntity(Transaction transaction);
}

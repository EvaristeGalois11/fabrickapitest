package it.nave.fabrickapitest.mapper;

import it.nave.fabrickapitest.model.TransferRequest;
import it.nave.fabrickapitest.model.TransferRequestApi;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TransferMapper {

  @Mapping(source = "receiverName", target = "creditor.name")
  TransferRequestApi toApi(TransferRequest request);
}

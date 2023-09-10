package it.nave.fabrickapitest.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class TransactionTypeEntity {
  @Column(name = "TYPE_ENUMERATION")
  private String enumeration;
  @Column(name = "TYPE_VALUE")
  private String value;

  public String getEnumeration() {
    return enumeration;
  }

  public void setEnumeration(String enumeration) {
    this.enumeration = enumeration;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }
}

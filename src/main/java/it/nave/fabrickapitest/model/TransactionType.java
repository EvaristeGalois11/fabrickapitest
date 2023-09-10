/*
 *Copyright (C) 2023 Claudio Nave
 *
 *This file is part of fabrickapitest.
 *
 *fabrickapitest is free software: you can redistribute it and/or modify
 *it under the terms of the GNU General Public License as published by
 *the Free Software Foundation, either version 3 of the License, or
 *(at your option) any later version.
 *
 *fabrickapitest is distributed in the hope that it will be useful,
 *but WITHOUT ANY WARRANTY; without even the implied warranty of
 *MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 *GNU General Public License for more details.
 *
 *You should have received a copy of the GNU General Public License
 *along with fabrickapitest. If not, see <https://www.gnu.org/licenses/>.
 */
package it.nave.fabrickapitest.model;

public class TransactionType {
  private String enumeration;
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

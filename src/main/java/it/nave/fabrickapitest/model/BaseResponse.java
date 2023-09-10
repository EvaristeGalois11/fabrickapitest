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

import java.util.List;

public class BaseResponse<T> {
  private Status status;
  private List<Error> errors;
  private T payload;

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  public List<Error> getErrors() {
    return errors;
  }

  public void setErrors(List<Error> errors) {
    this.errors = errors;
  }

  public T getPayload() {
    return payload;
  }

  public void setPayload(T payload) {
    this.payload = payload;
  }
}

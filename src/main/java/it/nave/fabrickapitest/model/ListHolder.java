package it.nave.fabrickapitest.model;

import java.util.List;

public class ListHolder<T> {
  private List<T> list;

  public List<T> getList() {
    return list;
  }

  public void setList(List<T> list) {
    this.list = list;
  }
}

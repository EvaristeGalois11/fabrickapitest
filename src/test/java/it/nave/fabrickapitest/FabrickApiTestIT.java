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
package it.nave.fabrickapitest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;

abstract class FabrickApiTestIT {
  @Autowired private TestRestTemplate rest;

  @Test
  void smokeTest() {}
}

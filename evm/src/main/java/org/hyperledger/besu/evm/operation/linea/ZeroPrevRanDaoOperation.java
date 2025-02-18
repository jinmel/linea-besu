/*
 * Copyright contributors to Hyperledger Besu
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * SPDX-License-Identifier: Apache-2.0
 */
package org.hyperledger.besu.evm.operation.linea;

import org.hyperledger.besu.evm.EVM;
import org.hyperledger.besu.evm.frame.MessageFrame;
import org.hyperledger.besu.evm.gascalculator.GasCalculator;
import org.hyperledger.besu.evm.operation.AbstractFixedCostOperation;

import org.apache.tuweni.units.bigints.UInt256;

/** The Prev randao operation. */
public class ZeroPrevRanDaoOperation extends AbstractFixedCostOperation {

  /**
   * Instantiates a new Prev randao operation.
   *
   * @param gasCalculator the gas calculator
   */
  public ZeroPrevRanDaoOperation(final GasCalculator gasCalculator) {
    super(0x44, "PREVRANDAO", 0, 1, gasCalculator, gasCalculator.getBaseTierGasCost());
  }

  @Override
  public OperationResult executeFixedCostOperation(final MessageFrame frame, final EVM evm) {
    frame.pushStackItem(UInt256.ZERO);
    return successResponse;
  }
}

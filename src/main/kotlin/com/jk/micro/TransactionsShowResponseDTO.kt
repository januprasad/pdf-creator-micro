package com.jk.micro

data class TransactionsShowResponseDTO(
  val amount: Double,
  val transactionStatus: String,
  val transactionDate: String,
  val paymentType: String,
  val bankName: String,
  val bankRefNo: String,
  val orderId: String,
  val surcharge: Double,
  val discount: Double,
  val chargeAmount: Double
) : IDTO {
  val refund: String = "No refund data available"
}

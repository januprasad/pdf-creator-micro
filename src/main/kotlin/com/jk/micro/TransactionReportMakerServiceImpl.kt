package com.jk.micro

//@Service
//class TransactionReportMakerServiceImpl @Autowired constructor(
//        val transactionService: TransactionService,
//        val pdfGeneratorService: PDFGeneratorService,
//        val resourceLoader: ResourceLoader)
//    : TransactionReportMakerService {
//
//    override fun generateTransactionReport(stream:ServletOutputStream, request: GenericRequestDTO<TransactionsShowRequestDTO>) {
//        var transaction = transactionService.fetchTransaction(request.data)
//        pdfGeneratorService.generatePDFReport(stream, transaction, request.data.transactionId)
//    }
//}
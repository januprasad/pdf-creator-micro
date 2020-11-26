package com.jk.micro

import com.lowagie.text.*
import com.lowagie.text.pdf.PdfPCell
import com.lowagie.text.pdf.PdfPTable
import com.lowagie.text.pdf.PdfWriter
import org.springframework.stereotype.Service
import java.awt.Color
import java.io.File
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.nio.file.Files
import javax.servlet.http.HttpServletResponse

@Service
class PDFUtil {
  val font = Font(Font.HELVETICA, 12.0f, Font.NORMAL, Color.BLACK)

  fun create(response: HttpServletResponse, t: TransactionsShowResponseDTO) {
    val outputStream = response.outputStream
    outputStream.use {
      val doc = Document()
      val writer: PdfWriter = PdfWriter.getInstance(doc, it)
      val font = Font(Font.HELVETICA, 16.0f, Font.BOLD, Color.RED)
      doc.open()
      val para = Paragraph("Transaction Report", font)
      addTable(doc, para, t)
      doc.close()
      writer.close()
      it.close()
    }
  }

  private fun addTable(doc: Document, para: Paragraph, t: TransactionsShowResponseDTO) {

    doc.apply {
      para.apply {
        val table = PdfPTable(2)
        table.apply {
          widthPercentage = 100f
          setWidths(floatArrayOf(10.0f, 10.0f))
          val cell = PdfPCell()

          cell.apply {
            phrase = getPhrase("Amount")
          }
          addCell(cell)
          cell.apply {
            phrase = getPhrase(t.amount.toString())
          }
          addCell(cell)
          cell.apply {
            phrase = getPhrase("Transaction Status")
          }
          addCell(cell)
          cell.apply {
            phrase = getPhrase(t.transactionStatus)
          }
          addCell(cell)
          cell.apply {
            phrase = getPhrase("Transaction Date")
          }
          addCell(cell)
          cell.apply {
            phrase = getPhrase(t.transactionDate)
          }
          addCell(cell)
          cell.apply {
            phrase = getPhrase("Payment Type")
          }
          addCell(cell)
          cell.apply {
            phrase = getPhrase(t.paymentType)
          }
          addCell(cell)
          cell.apply {
            phrase = getPhrase("Bank Name")
          }
          addCell(cell)
          cell.apply {
            phrase = getPhrase(t.bankName)
          }
          addCell(cell)
          cell.apply {
            phrase = getPhrase("Bank Ref No")
          }
          addCell(cell)
          cell.apply {
            phrase = getPhrase(t.bankRefNo)
          }
          addCell(cell)
          cell.apply {
            phrase = getPhrase("Order Id")
          }
          addCell(cell)
          cell.apply {
            phrase = getPhrase(t.orderId)
          }
          addCell(cell)
          cell.apply {
            phrase = getPhrase("Surcharge")
          }
          addCell(cell)
          cell.apply {
            phrase = getPhrase(t.surcharge.toString())
          }
          addCell(cell)
          cell.apply {
            phrase = getPhrase("Discount")
          }
          addCell(cell)
          cell.apply {
            phrase = getPhrase(t.discount.toString())
          }
          addCell(cell)
          cell.apply {
            phrase = getPhrase("Charge Amount")
          }
          addCell(cell)
          cell.apply {
            phrase = getPhrase(t.chargeAmount.toString())
          }
          addCell(cell)
        }
        add(table)
      }
      add(para)
    }
  }

  private fun getPhrase(value: String): Phrase {
    return Phrase(value, font)
  }
}
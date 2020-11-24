package com.jk.micro

import com.lowagie.text.*
import com.lowagie.text.pdf.PdfPCell
import com.lowagie.text.pdf.PdfPTable
import com.lowagie.text.pdf.PdfWriter
import java.awt.Color
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.nio.file.Files
import java.text.SimpleDateFormat
import javax.servlet.http.HttpServletResponse


class PDFUtil{
    val DEST = Files.createTempFile(null, ".pdf");

    fun exec() {
        try {
            val doc = Document()
            val writer: PdfWriter = PdfWriter.getInstance(doc, FileOutputStream(DEST.toFile()))
            //setting font family, color
            val font = Font(Font.HELVETICA, 16.0f, Font.BOLDITALIC, Color.RED)
            doc.open()
            val para = Paragraph("Hello! This PDF is created using openPDF", font)
            doc.add(para)
            doc.close()
            writer.close()
            println("document writing...")
            println(DEST)
        } catch (e: DocumentException) {
            // TODO Auto-generated catch block
            e.printStackTrace()
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        }
    }

    fun create(response: HttpServletResponse, users: List<User>) {
        val outputStream = response.outputStream
        val doc = Document()
        val writer: PdfWriter = PdfWriter.getInstance(doc, outputStream)
        val font = Font(Font.HELVETICA, 16.0f, Font.BOLDITALIC, Color.RED)
        doc.open()
        val para = Paragraph("Hello! This PDF is created using openPDF", font)
        doc.add(para)
        //
        val para2 = Paragraph("Generated Users", font)
        addTable(doc, para2, users)
        doc.close()
        writer.close()
        outputStream.close()
    }

    private fun addTable(doc: Document, para2: Paragraph, users: List<User>) {
        val font = Font(Font.HELVETICA, 16.0f, Font.BOLDITALIC, Color.RED)
        val table = PdfPTable(4)
        table.widthPercentage = 100f
        // setting column widths
        // setting column widths
        table.setWidths(floatArrayOf(6.0f, 6.0f, 6.0f, 6.0f))
        val cell = PdfPCell()
        // table headers
        // table headers
        cell.phrase = Phrase("First Name", font)
        table.addCell(cell)
        cell.phrase = Phrase("Last Name", font)
        table.addCell(cell)
        cell.phrase = Phrase("Email", font)
        table.addCell(cell)
        cell.phrase = Phrase("DOB", font)
        table.addCell(cell)
        // adding table rows
        // adding table rows
        for (user in users) {
            table.addCell(user.firstName)
            table.addCell(user.lastName)
            table.addCell(user.email)
            table.addCell(SimpleDateFormat("dd/MM/yyyy").format(user.dob))
        }
        // adding table to document
        // adding table to document
        para2.add(table)
        doc.add(para2)
    }
}
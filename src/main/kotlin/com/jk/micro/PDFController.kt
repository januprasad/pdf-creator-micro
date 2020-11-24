package com.jk.micro

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.Month
import java.time.ZoneId
import java.util.*
import javax.servlet.http.HttpServletResponse


@RestController
class PDFController {
    @GetMapping("/")
    fun get() : String{
        return "hi Spring boot"
    }

    @GetMapping("/pdf")
    fun createpdf(response: HttpServletResponse) : String{

        response.contentType = "application/octet-stream"
        val dateFormatter: DateFormat = SimpleDateFormat("yyyy-MM-dd_HH:mm:ss")
        val currentDateTime = dateFormatter.format(Date())
        val headerKey = "Content-Disposition"
        val headerValue = "attachment; filename=demo_$currentDateTime.pdf"
        response.setHeader(headerKey, headerValue)
        PDFUtil().create(response, getListOfUsers())
        return "generating pdf..."
    }

    // Dummy method for adding List of Users
    private fun getListOfUsers(): List<User> {
        val users: MutableList<User> = ArrayList()
        val dob = Calendar.getInstance()
        dob[1975, 6] = 12
        users.add(User("Vishnu", "VN", "vishnu@hatio.in", dob.time))
        // Using LocalDate from new time&date API Java 8 onward
        val date = LocalDate.of(2016, Month.APRIL, 28)
        users.add(User("Irshad", "PC", "irshad@hatio.in",
                Date.from(date.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant())))
        dob[1965, 12] = 6
        users.add(User("JK", "P", "janu@hatio.im", dob.time))
        return users
    }

}
package com.example.lab3.spring;

import com.example.lab3.beans.Book;
import com.example.lab3.responses.ExceptionResponse;
import com.example.lab3.responses.GetDashboardReponse;
import com.example.lab3.responses.OkResponse;
import com.example.lab3.responses.Response;
import com.google.gson.Gson;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;

@Service
public class DashboardService {
    ArrayList<Book> books=new ArrayList<>();
    private Gson gson;

    public DashboardService() {
        for (int i=0;i<=2;i++){
            Book bookPom= new Book(i);
            this.books.add(bookPom);
        }
        this.gson = new Gson();
    }


    public ResponseEntity GetBooks() {
        HttpStatus defaultStatus = HttpStatus.OK;
        Response defaultResponse;
        try {
            GetDashboardReponse dashboardResponse = new GetDashboardReponse(books, 200);
            return new ResponseEntity(gson.toJson(dashboardResponse), defaultStatus);
        } catch (Exception ex) {
            defaultResponse = new ExceptionResponse((ex.getLocalizedMessage()));
            defaultStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            return new ResponseEntity(gson.toJson(defaultResponse), defaultStatus);
        }
    }


    public ResponseEntity GetBook(int id) {
        HttpStatus defaultStatus = HttpStatus.NOT_FOUND;
        Response response = new ExceptionResponse("Book does not exist");
        try {
            Book book=books.get(id);
            if (book != null) {
                defaultStatus = HttpStatus.OK;
                response = new OkResponse(book);
            }
        } catch (Exception ex) {
            response = new ExceptionResponse(ex.toString());
            defaultStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        } finally {
            return new ResponseEntity(gson.toJson(response), defaultStatus);
        }
    }


    public ResponseEntity AddBook(Book addBook) {
        HttpStatus defaultStatus = HttpStatus.BAD_REQUEST;
        Response response = new ExceptionResponse("Wrong data!");
        try {
            defaultStatus = HttpStatus.OK;
            books.add(addBook);
            GetDashboardReponse dashboardResponse = new GetDashboardReponse(books, 200);
            return new ResponseEntity(gson.toJson(dashboardResponse), defaultStatus);
        } catch (Exception ex) {
            defaultStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            response = new ExceptionResponse(ex.toString());
            return new ResponseEntity(gson.toJson(response), defaultStatus);
        }
    }

    public ResponseEntity DeleteBook(int id) {
        HttpStatus defaultStatus = HttpStatus.BAD_REQUEST;
        Response response = new ExceptionResponse("Book does not exist");
        try {
            Book book=books.get(id);
            if (book != null) {
                books.remove(id);
                defaultStatus = HttpStatus.OK;
                response = new OkResponse(book);
            } else {
                defaultStatus = HttpStatus.NOT_FOUND;
            }
        } catch (Exception ex) {
            response = new ExceptionResponse(ex.toString());
            defaultStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        } finally {
            return new ResponseEntity(gson.toJson(response), defaultStatus);
        }
    }
}

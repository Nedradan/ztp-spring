package com.example.lab3.responses;

import com.example.lab3.beans.Book;

import java.util.ArrayList;

public class GetDashboardReponse {
    private ArrayList<Book> books;
    private int status;

    public GetDashboardReponse() {
    }
    public GetDashboardReponse(ArrayList<Book> books, int status) {
        this.books = books;
        this.status = status;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarysystem;

/**
 *
 * @author AHMED 50070
 */
public class Book {

   static int count ;

    String Book_Name;
    String Author_Name;
    int Book_ID;

    int borrow_Id ;
    String borrow_date ; 
    String borrow_comments ;

   
    public Book(String Book_Name, String Author) {
        this.Book_Name = Book_Name;
        this.Author_Name = Author;
        Book.count++;
	Book_ID = Book.count;

    }

    public int getBook_ID() {
        return Book_ID;
    }

    public void setBook_ID(int Book_ID) {
        this.Book_ID = Book_ID;
    }

    public String getAuthor_Name() {
        return Author_Name;
    }

    public void setAuthor_Name(String Author_Name) {
        this.Author_Name = Author_Name;
    }

    public String getBook_Name() {
        return Book_Name;
    }

    public void setBook_Name(String Book_Name) {
        this.Book_Name = Book_Name;
    }
    
    
     public int getBorrow_Id() {
        return borrow_Id;
    }

    public void setBorrow_Id(int borrow_Id) {
        this.borrow_Id = borrow_Id;
    }

    public String getBorrow_date() {
        return borrow_date;
    }

    public void setBorrow_date(String borrow_date) {
        this.borrow_date = borrow_date;
    }

    public String getBorrow_comments() {
        return borrow_comments;
    }

    public void setBorrow_comments(String borrow_comments) {
        this.borrow_comments = borrow_comments;
    }
    

}
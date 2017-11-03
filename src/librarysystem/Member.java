/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarysystem;

import java.util.ArrayList;

/**
 *
 * @author AHMED 50070
 */
public abstract class Member {

    int member_id, count_Book;
    String member_name;
    Manager man;
    ArrayList<Book> Borrowed_Book;

    public Member(int member_id, String member_name, Manager man) {
        this.member_id = member_id;
        this.member_name = member_name;
        this.man = man;

        this.Borrowed_Book = new ArrayList<>();
    
    }

    abstract void borrowing_book(Book b, int Borrow_ID, String Date, String comments);

    abstract void return_book(Book b);

    public int getMember_id() {
        return member_id;
    }

    public void setMember_id(int member_id) {
        this.member_id = member_id;
    }

    public String getMember_name() {
        return member_name;
    }

    public void setMember_name(String member_name) {
        this.member_name = member_name;
    }

    public ArrayList<Book> getBorrowed_Book() {
        return Borrowed_Book;
    }

    public void setBorrowed_Book(Book b) {

        /// add Book to Borrow List 
        this.Borrowed_Book.add(b);

    }

}

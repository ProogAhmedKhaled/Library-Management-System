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
public class Manager {

    ArrayList<Book> book;
    ArrayList<Member> member;
    ArrayList<Book> borrowed_Book;

////////////////////////////** constructor** /////////////////////////////////////////////
    public Manager() {

        this.book = new ArrayList<>();
        this.member = new ArrayList<>();

    }

    ////////////////////////////////////////////////////////////////////////////////
    public void addBook(Book book) {

        this.book.add(book);

    }

    /// ////////////////////////////////////////////////////////////////////////////
    public Member getMember(int ID) {

        Member m = null;
        for (int i = 0; i < this.member.size(); i++) {

            if (this.member.get(i).getMember_id() == ID) {

                m = this.member.get(i);

                break;
            }
        }
        return m;
    }

    //////////////////////////////////////////////////////////////////////////////////
    public Book getBook(int ID) {

        Book B = null;
        for (int i = 0; i < this.book.size(); i++) {

            if (this.book.get(i).getBook_ID() == ID) {

                B = this.book.get(i);

                break;
            }
        }
        return B;
    }
    
    public Book getBorrowedBook(int ID) {

        Book B = null;
        for (int i = 0; i < this.borrowed_Book.size(); i++) {

            if (this.borrowed_Book.get(i).getBook_ID() == ID) {

                B = this.borrowed_Book.get(i);

                break;
            }
        }
        return B;
    }

 ////////////////////////////////////////////////////////////////////////////////////
    public boolean isExist(Book b) {

        boolean flag = false;
        for (int i = 0; i < this.book.size(); i++) {
            if (this.book.get(i).getBook_ID() == b.getBook_ID()) {

                flag = true;
                break;
            }

        }
        return flag;
    }

/////////////////////////////////////////////////////////////////////////////////
    public void deletBook(Book book) {

        if (isExist(book)) {
            this.book.remove(book);
        }

    }

/////////////////////////////////////////////////////////////////////////////////
    public void addMember(Member m) {

        if (!isMemberExist(m)) {
            this.member.add(m);
        } else {
            System.out.println("Member : " + m.getMember_name() + " is already Exist you are try to add this member Twice ");
        }
    }

/////////////////////////////////////////////////////////////////////////////////
    public boolean isMemberExist(Member m) {

        boolean check = false;

        for (int i = 0; i < this.member.size(); i++) {

            if (this.member.get(i).getMember_id() == m.getMember_id()) {
                check = true;
                break;
            }
        }

        return check;
    }

/////////////////////////////////////////////////////////////////////////////////    
    public void removeMember(Member m) {

        if (isMemberExist(m)) {

            this.member.remove(m);
            System.out.println("Member: " + m.getMember_name() + " removed from the System ");
        }

    }

/////////////////////////////////////////////////////////////////////////////////
    public void printListMember() {

        for (Member member : this.member) {

            System.out.println("ID: " + member.getMember_id() + " || Name: " + member.getMember_name()
                    + " || Type: " + member.getClass().getTypeName().substring(14));
            System.out.println("----------------------------------------------");

        }
    }

////////////////////////////////////////////////////////////////////////////////
    public void printlistBook() {

        for (Book b : this.book) {

            System.out.println("ID: " + b.getBook_ID() + " || Book Name: "
                    + b.getBook_Name() + " || Book Author: " + b.getAuthor_Name());
            System.out.println("----------------------------------------------");
        }
        System.out.println("***********************************************");
    }

/////////////////////////////////////////////////////////////////////////////////
    
    
    
    public void printBorrowList(Member member) {

        this.borrowed_Book = member.getBorrowed_Book();

        System.out.println("Borrow Book List of Member Name: " + member.getMember_name());
        for (int i = 0; i < this.borrowed_Book.size(); i++) {

            System.out.println(
                    "Book Name " + this.borrowed_Book.get(i).getBook_Name()
                    + " | Borrow ID: " + this.borrowed_Book.get(i).getBorrow_Id()
                    + " | Borrow Date: " + this.borrowed_Book.get(i).getBorrow_date()
                    + " | Comments: " + this.borrowed_Book.get(i).getBorrow_comments()
            );

            System.out.println("-------------------------------------------------------------------------------------------------------");

        }

    }

}

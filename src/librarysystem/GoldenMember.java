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
public class GoldenMember extends Member {

    int count;

    public GoldenMember(int member_id, String member_name, Manager man) {
        super(member_id, member_name, man);

    }

    @Override
    void borrowing_book(Book book, int Borrow_ID, String Date, String comments) {
        
        if (!man.isMemberExist(this)) {
            System.out.println("this Member that try to borrow Book Not Exist ");
        } else if (man.isExist(book)) {

            count++;
            super.count_Book = count;

            if (this.count_Book <= 10) {

                book.setBorrow_Id(Borrow_ID);
                book.setBorrow_date(Date);
                book.setBorrow_comments(comments);

                this.setBorrowed_Book(book);

                man.deletBook(book);

            } else {
                System.out.println("Sorry Member " + member_name + " Exceed Maximum number of Borrowing Books ");
                System.out.println("------------------------------------------------------------------------------");

            }

        } else {
            System.out.println("Book: " + book.getBook_Name() + " already borrowed");
            System.out.println("------------------------------------------------------------------------------");
        }
    }

    @Override
    void return_book(Book b) {

        /// make book available to borrowing again by adding it again to the list 
        man.addBook(b);

        for (int i = 0; i < this.getBorrowed_Book().size(); i++) {

            if (this.getBorrowed_Book().get(i).getBook_ID() == b.getBook_ID()) {
                this.getBorrowed_Book().remove(b);
            }
        }
    }

}
